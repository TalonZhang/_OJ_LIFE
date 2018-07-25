package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.*;

/**
 * Created by likole on 7/25/18.
 */
@Table("problem")
public class Problem {

    @Id
    @Column("problem_id")
    private int id;

    @Column
    private String title;

    @Column
    @ColDefine(type = ColType.TEXT)
    private String description;

    @Column
    @ColDefine(type = ColType.TEXT)
    private String input;

    @Column
    @ColDefine(type = ColType.TEXT)
    private String output;

    @Column("sample_input")
    @ColDefine(type = ColType.TEXT)
    private String sampleInput;

    @Column("sample_output")
    @ColDefine(type = ColType.TEXT)
    private String sampleOutput;

    @Column
    @ColDefine(type = ColType.CHAR)
    private String spj;

    @Column
    @ColDefine(type = ColType.TEXT)
    private String hint;

    @Column
    private String source;

    @Column("time_limit")
    private int timeLimit;

    @Column("memory_limit")
    private int memoryLimit;

    @Column
    private int accepted;

    @Column
    private int submit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public String getSpj() {
        return spj;
    }

    public void setSpj(String spj) {
        this.spj = spj;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public int getSubmit() {
        return submit;
    }

    public void setSubmit(int submit) {
        this.submit = submit;
    }
}
