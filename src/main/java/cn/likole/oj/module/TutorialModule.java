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

        return tutorial;
    }

//    @At
//    public Object nextSection(HttpSession session)
//    {
//        User user=dao.fetch(User.class,(int)session.getAttribute("uid"));
//
//    }

}
