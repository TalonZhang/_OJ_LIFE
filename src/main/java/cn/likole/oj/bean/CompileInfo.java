package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.*;

/**
 * Created by likole on 7/25/18.
 */
@Table("compileinfo")
public class CompileInfo {

    @Id(auto = false)
    @Column("solution_id")
    private int id;

    @Column
    @ColDefine(type = ColType.TEXT)
    private String error;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
