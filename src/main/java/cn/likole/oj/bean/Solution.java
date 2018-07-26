package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.*;

import java.util.Date;

/**
 * Created by likole on 7/26/18.
 */
@Table("solution")
@TableIndexes({@Index(fields = "problemId", unique = false),
        @Index(fields = "userId", unique = false),
        @Index(fields = "contestId", unique = false)})
public class Solution {

    @Id
    @Column("solution_id")
    private int id;

    @Column("problem_id")
    private int problemId;

    @Column("user_id")
    private int userId;

    @Column
    private int time;

    @Column
    private int memory;

    @Column("in_date")
    private Date inDate;

    @Column
    @ColDefine(type = ColType.INT, width = 6)
    private int result;

    @Column
    private int language;

    @Column
    private String ip;

    @Column("code_length")
    private int codeLength;

    @Column("judge_time")
    private Date judgeTime;

    @Column
    private String judger;

    //以下为contest部分
    @Column("contest_id")
    private int contestId;

    @Column("content_num")
    private int contestNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public Date getJudgeTime() {
        return judgeTime;
    }

    public void setJudgeTime(Date judgeTime) {
        this.judgeTime = judgeTime;
    }

    public String getJudger() {
        return judger;
    }

    public void setJudger(String judger) {
        this.judger = judger;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getContestNum() {
        return contestNum;
    }

    public void setContestNum(int contestNum) {
        this.contestNum = contestNum;
    }
}
