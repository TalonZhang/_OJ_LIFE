package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.*;

/**
 * Created by likole on 7/26/18.
 */
@Table("source_code")
public class SourceCode {

    @Id(auto = false)
    @Column("solution_id")
    private int solutionId;

    @Column
    @ColDefine(type = ColType.TEXT)
    private String source;

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
