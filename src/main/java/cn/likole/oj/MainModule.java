package cn.likole.oj;

import cn.likole.oj.bean.User;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CrossOriginFilter;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import javax.servlet.http.HttpSession;

/**
 * Created by likole on 7/23/18.
 */
@SetupBy(value=MainSetup.class)
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
        "*anno", "cn.likole.oj",
        "*tx", // 事务拦截 aop
        "*async"}) // 异步执行aop
@Modules()
@Ok("json:full")
@Fail("jsp:jsp.500")
@Filters(@By(type = CrossOriginFilter.class))
public class MainModule {

    @At("/")
    @Ok("re")
    public String index(HttpSession session){
        if(session.getAttribute("uid")==null) return ">>:/user/loginpage";
        if(session.getAttribute("state0")!=null) return ">>:/tutorial/test0";
        return "jsp:500";
    }

}
