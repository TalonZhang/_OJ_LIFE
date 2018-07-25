package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by likole on 7/24/18.
 */
@Table("user_tutorial_info")
public class UserTutorialInfo {

    @Id
    private int id;

    @Column("tutorial_id")
    private int tutorialId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTutorialId() {
        return tutorialId;
    }

    public void setTutorialId(int tutorialId) {
        this.tutorialId = tutorialId;
    }
}
