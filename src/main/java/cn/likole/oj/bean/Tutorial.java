package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.*;
import org.nutz.mvc.annotation.Filters;

import java.util.List;

/**
 * Created by likole on 7/25/18.
 */
@Table("tutorial")
public class Tutorial {

    @Id
    private int id;

    @Column
    private int chapter;

    @Column
    private int section;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private boolean introduction;

    @ManyMany(relation = "tutorial_problem",from = "tutorial_id",to="problem_id")
    private List<Problem> problems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIntroduction() {
        return introduction;
    }

    public void setIntroduction(boolean introduction) {
        this.introduction = introduction;
    }


    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }
}
