package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.*;

/**
 * Created by likole on 7/23/18.
 */
@Table("user")
public class User {

    @Id
    @Column("user_id")
    private int id;

    @Name
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String sid;

    @Column
    private String qq;

    @Column
    private int money;

    @Column
    private int state;

    @Column
    private int solved;

    private int submit;

    @One(field="id")
    private UserTutorialInfo userTutorialInfo;

    @One(field = "id")
    private UserInfo userInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public UserTutorialInfo getUserTutorialInfo() {
        return userTutorialInfo;
    }

    public void setUserTutorialInfo(UserTutorialInfo userTutorialInfo) {
        this.userTutorialInfo = userTutorialInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
