package cn.jwg.materialdesgin.core.common.bean;

import cn.jwg.materialdesgin.core.database.sqlite.bean.MedicPlan;
import java.util.List;

/**
 * Created by Juwuguo on 2017/8/17.
 */

public class JavaDataBean {

    private List<MedicPlan> plans;

    public List<MedicPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<MedicPlan> plans) {
        this.plans = plans;
    }
}
