package cn.likole.oj.module;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.filter.CheckSession;

/**
 * Created by likole on 7/24/18.
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"state0", "/"}))
@At("tutorial")
public class TutorialModule {

    @Inject
    protected Dao dao;

    @At
    public void test0()
    {

    }

    @At
    public void test1()
    {

    }

}
