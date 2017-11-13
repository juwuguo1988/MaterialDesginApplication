package cn.jwg.materialdesgin.core.ui.activity;


import android.util.Log;
import android.view.View;
import android.widget.TextView;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.bean.SucLoginAllDataBean;
import cn.jwg.materialdesgin.core.database.sp.UserInfoUtils;
import cn.jwg.materialdesgin.core.ui.base.TitleActivity;
import cn.jwg.materialdesgin.core.utils.config.AppConfig;
import cn.jwg.materialdesgin.core.utils.network.callback.DialogCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

/**
 * Created by Juwuguo on 2017/9/11.
 */

public class RxJavaActivity extends TitleActivity implements View.OnClickListener {

    private static final String TAG = "RxJavaActivity";
    private TextView tv_get_medic_plan;

    @Override
    protected void findViewId() {
        addView(View.inflate(this, R.layout.activity_rx_java, null));
        tv_get_medic_plan = (TextView) findViewById(R.id.tv_get_medic_plan);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        hideView(iv_title_right);
    }

    @Override
    protected void setListener() {
        rl_title_left.setOnClickListener(this);
        tv_get_medic_plan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_title_left:
                finish();
                break;
            case R.id.tv_get_medic_plan:
                userMedicPlanAction();
                break;
        }
    }


    private void userMedicPlanAction() {
        OkGo.<SucLoginAllDataBean>get(AppConfig.WEB_APP_PLAN_URL)
                .tag(this)
                .headers("Authorization", "Bearer " + UserInfoUtils.getAccessToken(this))
                .execute(new DialogCallback<SucLoginAllDataBean>(this) {
                    @Override
                    public void onSuccess(Response<SucLoginAllDataBean> response) {
                        SucLoginAllDataBean sLADBean = response.body();
                        if (sLADBean != null) {
                            Log.e(TAG, "========getPlans=======>" + sLADBean.data.getPlans().size());
                        }
                    }

                    @Override
                    public void onError(Response<SucLoginAllDataBean> response) {
                    }
                });
    }
}
