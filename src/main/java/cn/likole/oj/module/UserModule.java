package cn.likole.oj.module;

import cn.likole.oj.bean.User;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.meta.Email;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.WhaleFilter;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CrossOriginFilter;

import java.util.List;

/**
 * Created by likole on 7/24/18.
 */
@IocBean
@At("/user")
@Ok("json:full")
@Fail("jsp:jsp.500")
@Filters(@By(type = CrossOriginFilter.class))
public class UserModule {

    @Inject
    protected Dao dao;


    private String checkEmailAndPassword(User user){
        //验证邮箱
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String email=user.getEmail();
        if(email==null) return "Email地址不能为空";
        if(!email.matches(EMAIL_REGEX)) return "Email格式错误";

        //验证密码
        String password=user.getPassword();
        if(password==null) return "密码不能为空";

        return null;
    }

    @At
    public Object checkEmail(@Param("email") String email){
        NutMap re=new NutMap();
        List<User> users= dao.query(User.class, Cnd.where("email","=",email));
        if(users.size()!=0) return re.setv("ok",false).setv("msg","该邮箱已被注册");
        return re.setv("ok",true);
    }

    @At
    public Object checkNickname(@Param("nickname") String nickname){
        NutMap re=new NutMap();
        List<User> users= dao.query(User.class, Cnd.where("nickname","=",nickname));
        if(users.size()!=0) return re.setv("ok",false).setv("msg","该昵称已被使用");
        return re.setv("ok",true);
    }

    @At
    @POST
    public Object register(@Param("..")User user){
        NutMap re=new NutMap();

        //检查邮箱密码格式
        String msg=checkEmailAndPassword(user);
        if(msg!=null) return re.setv("ok",false).setv("msg",msg);

        //检查昵称格式
        if(user.getNickname()==null||user.getNickname().length()<3)
            return re.setv("ok",false).setv("msg","昵称至少为三个字");

        //检查邮箱和昵称是否重复
        List<User> users= dao.query(User.class, Cnd.where("email","=",user.getEmail()).or("nickname","=",user.getNickname()));
        if(users.size()!=0 ) return re.setv("ok",false).setv("msg","该邮箱已被注册");

        //注册
        user.setMoney(0);
        user.setState(0);
        dao.insert(user);

        return re.setv("ok",true);
    }

    @At
    public Object login(){
        return null;
    }

    @At
    public Object logout(){
        return null;
    }
}
