package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Index;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.TableIndexes;

import java.util.Date;

/**
 * Created by likole on 7/26/18.
 */
@Table("login_log")
@TableIndexes({@Index(fields={"userId","time"}),@Index(fields = "userId",unique = false)})
public class LoginLog {

    @Column("user_id")
    private int userId;

    @Column
    private String password;

    @Column
    private Date time;

    @Column
    private String ip;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
