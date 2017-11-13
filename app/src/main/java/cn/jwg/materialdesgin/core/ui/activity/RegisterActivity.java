package cn.jwg.materialdesgin.core.ui.activity;

import android.view.View;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.ui.base.TitleActivity;


public class RegisterActivity extends TitleActivity implements View.OnClickListener {

    @Override
    protected void findViewId() {
        addView(View.inflate(this, R.layout.activity_register, null));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tv_title_view.setText(getString(R.string.user_register));
        hideButton(rl_title_right);
    }

    @Override
    protected void setListener() {
        rl_title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_title_left:
                finish();
                break;
        }
    }
}
