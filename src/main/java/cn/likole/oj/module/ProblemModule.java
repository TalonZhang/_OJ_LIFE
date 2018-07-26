package cn.likole.oj.module;

import cn.likole.oj.bean.Problem;
import cn.likole.oj.bean.User;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import javax.servlet.http.HttpSession;

/**
 * Created by likole on 7/26/18.
 */
@IocBean
@At("/problem")
@Filters(@By(type = CheckSession.class, args = {"uid", "/"}))
public class ProblemModule {

    @Inject
    protected Dao dao;

    @At
    public Object getProblem(@Param("id") int id, HttpSession session){
        NutMap re=new NutMap();
        User user=dao.fetch(User.class, (int)session.getAttribute("uid"));

        if(user.getState()==0){
            //第一阶段
            dao.fetchLinks(user,"tutorial");
            dao.fetchLinks(user.getTutorial(),"problems");
            for(Problem problem:user.getTutorial().getProblems()){
                if(problem.getId()==id) return re.setv("ok",true).setv("problem",problem);
            }
            return re.setv("ok",false).setv("msg","用户所在章节无此题目");
        }else {
            //第二阶段
        }
        return re.setv("ok",false);
    }
}
