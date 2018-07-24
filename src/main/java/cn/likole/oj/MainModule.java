package cn.likole.oj;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * Created by likole on 7/23/18.
 */
@SetupBy(value=MainSetup.class)
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
        "*anno", "cn.likole.oj",
        "*tx", // 事务拦截 aop
        "*async"}) // 异步执行aop
@Modules()
public class MainModule {

    @At("/register")
    @Ok("json")
    public String dolala(@Param("username") String username){
        return "馬鹿"+username;
    }

}
