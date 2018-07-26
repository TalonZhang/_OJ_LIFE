package cn.likole.oj.module;

import cn.likole.oj.bean.Tutorial;
import cn.likole.oj.bean.User;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by likole on 7/24/18.
 */
@IocBean
//@Filters(@By(type = CheckSession.class, args = {"state0", "/"}))
//todo:去掉注释
@At("tutorial")
@Ok("json:full")
public class TutorialModule {

    @Inject
    protected Dao dao;

    @At
    public void test0() {

    }

    /**
     * 获取当前所在的章节
     *
     * @param userId       用户编号
     * @param withProblems 是否获取本章节的问题
     * @return
     */
    private User getUserWithTutorial(int userId, boolean withProblems) {
        User user = dao.fetch(User.class, userId);
        dao.fetchLinks(user, "tutorial");
        if (withProblems) dao.fetchLinks(user.getTutorial(), "problems");
        return user;
    }

    @At
    public Object problems(HttpSession session) {
        NutMap re = new NutMap();

        Tutorial tutorial = getUserWithTutorial((int) session.getAttribute("uid"), true).getTutorial();
        int maxIndex = dao.func(Tutorial.class, "max", "id");

        return re.setv("tutorial", tutorial).setv("hasNext", maxIndex != tutorial.getId());
    }

    @At
    public Object nextStep(HttpSession session) {
        NutMap re = new NutMap();

        //获取目前的章节
        User user = getUserWithTutorial((int) session.getAttribute("uid"), false);
        Tutorial tutorial = user.getTutorial();

        //检查章节最大编号
        int maxIndex = dao.func(Tutorial.class, "max", "id");
        if (maxIndex == tutorial.getId()) return re.setv("ok", false).setv("msg", "已到达最大章节");

        //介绍直接跳过
        if (tutorial.isIntroduction()) {
            user.setTutorialId(user.getTutorialId() + 1);
            dao.update(user, "^tutorialId$");
            return re.setv("ok", true);
        }

        //todo:判断当前题目是否刷够
        return re.setv("ok", false);

    }

    @At()
    @Ok("json")
    public Object finish(HttpSession session) {
        NutMap re = new NutMap();

        //获取
        User user = getUserWithTutorial((int) session.getAttribute("uid"), false);
        Tutorial tutorial=user.getTutorial();

        //最大章节检测
        int maxIndex = dao.func(Tutorial.class, "max", "id");
        if (maxIndex != user.getTutorialId()) return re.setv("ok", false).setv("msg", "尚未到达最大章节");

        //介绍直接跳过
        if (tutorial.isIntroduction()) {
            //更新数据库
            user.setState(1);
            user.setTutorialFinishTime(new Date());
            dao.update(user);

            //更新session
            session.removeAttribute("state0");
            session.setAttribute("state1",1);

            return re.setv("ok",true);
        }

        //todo:判断当前题目是否刷够
        return re.setv("ok", false);
    }


}
