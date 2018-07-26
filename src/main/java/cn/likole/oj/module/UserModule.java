package cn.likole.oj.module;

import cn.likole.oj.bean.User;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.DaoException;
import org.nutz.dao.FieldFilter;
import org.nutz.dao.util.Daos;
import org.nutz.http.Http;
import org.nutz.img.Images;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.Scope;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CrossOriginFilter;
import org.nutz.mvc.impl.AdaptorErrorContext;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by likole on 7/24/18.
 */
@IocBean
@At("/user")
@Ok("json:full")
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
        if(users.size()!=0) return re.setv("ok",false).setv("msg","该邮箱已被注册").setv("valid",false);
        return re.setv("ok",true).setv("valid",true);
    }

    @At
    public Object checkNickname(@Param("nickname") String nickname){
        NutMap re=new NutMap();
        List<User> users= dao.query(User.class, Cnd.where("nickname","=",nickname));
        if(users.size()!=0) return re.setv("ok",false).setv("msg","该昵称已被使用").setv("valid",false);
        return re.setv("ok",true).setv("valid",true);
    }

    @At
    @POST
    public Object register(@Param("..")User user, HttpSession session){
        NutMap re=new NutMap();

        //检查邮箱密码格式
        String msg=checkEmailAndPassword(user);
        if(msg!=null) return re.setv("ok",false).setv("msg",msg);

        //检查昵称格式
        if(user.getNickname()==null||user.getNickname().length()<3)
            return re.setv("ok",false).setv("msg","昵称至少为三个字");

        //检查邮箱和昵称是否重复
        List<User> users= dao.query(User.class, Cnd.where("email","=",user.getEmail()).or("nickname","=",user.getNickname()));
        if(users.size()!=0 ) return re.setv("ok",false).setv("msg","该邮箱或昵称已被注册");

        //注册
        user.setMoney(0);
        user.setState(0);
        user.setTutorialId(1);
        user.setRegisterTime(new Date());
        dao.insert(user);

        //登陆
        session.setAttribute("uid",user.getId());
        session.setAttribute("nickname",user.getNickname());
        session.removeAttribute("state0");
        session.removeAttribute("state1");
        session.setAttribute("state"+user.getState(),1);

        return re.setv("ok",true);
    }

    @At
    @POST
    public Object login(@Param("..")User user,HttpSession session){
        NutMap re=new NutMap();

        //检查邮箱密码格式
        String msg=checkEmailAndPassword(user);
        if(msg!=null) return re.setv("ok",false).setv("msg",msg);

        //检查用户名密码
        List<User> users=dao.query(User.class,Cnd.where("email","=",user.getEmail()).and("password","=",user.getPassword()));
        if(users.size()==0) return re.setv("ok",false).setv("msg","用户名或密码错误");

        //登陆
        session.setAttribute("uid",users.get(0).getId());
        session.setAttribute("nickname",users.get(0).getNickname());
        session.removeAttribute("state0");
        session.removeAttribute("state1");
        session.setAttribute("state"+users.get(0).getState(),1);

        return re.setv("ok",true);
    }

    @At
    @Ok("re")
    public String loginPage(HttpSession session){
        if(session.getAttribute("uid")!=null) return ">>:/";
        return "jsp:jsp.loginpage";
    }

    @At
    @Ok(">>:/user/loginpage")
    public void logout(HttpSession session){
        session.invalidate();
    }


    @AdaptBy(type = UploadAdaptor.class, args = {"${app.root}/WEB-INF/tmp/user_avatar","8192","utf-8","20000","102400"})
    @POST
    @At("/avator")
    public Object uploadAcatar(@Param("file")TempFile tf, @Param("userId")int id,AdaptorErrorContext err){
        NutMap re=new NutMap();
        String msg=null;
        if(err!=null && err.getAdaptorErr()!=null){
            msg="上传文件大小不符合规定";
        }else if(tf==null){
            msg="空文件";
        }else {
            User user=dao.fetch(User.class,id);
            try {
                BufferedImage image= Images.read(tf.getFile());
                //缩放
                image=Images.zoomScale(image,128,128, Color.WHITE);
                ByteArrayOutputStream out =new ByteArrayOutputStream();
                /**
                 * quality:图片输出质量
                 */
                Images.writeJpeg(image,out,0.9f);
                user.setAvatar(out.toByteArray());
                dao.update(user,"^avatar$");
            } catch (DaoException e) {
                msg="系统错误";
            } catch (Throwable e){
                msg="图片格式错误";
            }
        }
        if(msg!=null) Mvcs.getHttpSession().setAttribute("upload-error-msg",msg);
        return re.setv("ok",true).setv("msg",msg);
    }


    public Object readAvatar(@Param("user")int id, HttpServletRequest req)throws SQLException{
        User user= Daos.ext(dao, FieldFilter.create(User.class,"^avatar$")).fetch(User.class,id);
        if(user==null || user.getAvatar()==null){
            return new File(req.getSession().getServletContext().getRealPath("/rs/user_avatar/none.jpg"));
        }
        return user.getAvatar();
    }
}
