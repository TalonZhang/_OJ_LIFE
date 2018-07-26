package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.*;
import org.nutz.json.JsonField;

import java.util.Date;

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

    @Column
    private int submit;

    @Column
    private int tutorialId;

    @Column
    private Date registerTime;

    @Column
    private Date tutorialFinishTime;

    @Column
    private int infoId;

    @Column
    @JsonField(ignore = true)
    private byte[] avatar;

//    @One(field = "tutorialId", key = "id")
//    private UserTutorialInfo userTutorialInfo;

    @One(field = "tutorialId",key = "id")
    private Tutorial tutorial;

    @One(field = "infoId", key = "id")
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

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }

    public int getSubmit() {
        return submit;
    }

    public void setSubmit(int submit) {
        this.submit = submit;
    }

    public int getTutorialId() {
        return tutorialId;
    }

    public void setTutorialId(int tutorialId) {
        this.tutorialId = tutorialId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getTutorialFinishTime() {
        return tutorialFinishTime;
    }

    public void setTutorialFinishTime(Date tutorialFinishTime) {
        this.tutorialFinishTime = tutorialFinishTime;
    }


    public byte[] getAvatar() { return avatar; }

    public void setAvatar(byte[] avatar) { this.avatar = avatar; }
}
