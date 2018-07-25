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
import javax.swing.text.rtf.RTFEditorKit;

/**
 * Created by likole on 7/24/18.
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"state0", "/"}))
@At("tutorial")
@Ok("json:full")
public class TutorialModule {

    @Inject
    protected Dao dao;

    @At
    public void test0()
    {

    }

    @At
    public Object problems(HttpSession session)
    {
        NutMap re=new NutMap();

        //获取用户目前的章节
        User user=dao.fetch(User.class,(int)session.getAttribute("uid"));
        dao.fetchLinks(user,"tutorial");

        //获取该章节的问题
        Tutorial tutorial=user.getTutorial();
        dao.fetchLinks(tutorial,"problems");

        //检查章节最大编号
        int maxIndex= dao.func(Tutorial.class,"max","id");

        return re.setv("tutorial",tutorial).setv("hasNext",maxIndex!=tutorial.getId());
    }

    @At
    public Object nextStep(HttpSession session)
    {
        NutMap re=new NutMap();

        //获取目前的章节
        User user=dao.fetch(User.class,(int)session.getAttribute("uid"));
        dao.fetchLinks(user,"tutorial");
        Tutorial tutorial=user.getTutorial();

        //检查章节最大编号
        int maxIndex= dao.func(Tutorial.class,"max","id");
        if(maxIndex==tutorial.getId()) return re.setv("ok",false).setv("msg","已到达最大章节");

        //介绍直接跳过
        if(tutorial.isIntroduction()){
            user.setTutorialId(user.getTutorialId()+1);
            dao.update(user,"^tutorialId$");
            return re.setv("ok",true);
        }

        return re.setv("ok",false);

    }

}
