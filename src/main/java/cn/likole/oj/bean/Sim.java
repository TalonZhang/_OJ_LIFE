package cn.likole.oj.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.mvc.annotation.At;

/**
 * Created by likole on 7/26/18.
 */
@Table("sim")
public class Sim {

//    CREATE TRIGGER jol.simfilter
//    BEFORE INSERT ON jol.sim
//    FOR EACH ROW
//            begin
//    declare new_user_id varchar(64);
//    declare old_user_id varchar(64);
//    select user_id from solution where solution_id=new.s_id into new_user_id;
//    select user_id from solution where solution_id=new.sim_s_id into old_user_id;
// if old_user_id=new_user_id then
//    set new.s_id=0;
//    end if;
//
//    end;


    @Column("s_id")
    private int solutionId;

    @Column("sim_s_id")
    private int targetId;

    @Column("sim")
    private int sim;

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public int getSim() {
        return sim;
    }

    public void setSim(int sim) {
        this.sim = sim;
    }
}
