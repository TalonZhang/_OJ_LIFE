package cn.likole.oj;

import cn.likole.oj.bean.User;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

/**
 * Created by likole on 7/23/18.
 */
public class MainSetup implements Setup {

    public void init(NutConfig nc) {
        Ioc ioc = nc.getIoc();
        Dao dao = ioc.get(Dao.class);
        Daos.createTablesInPackage(dao, "cn.likole.oj.bean", false);
        Daos.migration(dao, "cn.likole.oj.bean", true, false, false);
    }

    public void destroy(NutConfig nc) {
    }

}