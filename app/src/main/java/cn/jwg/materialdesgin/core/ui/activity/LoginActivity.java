package cn.jwg.materialdesgin.core.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.bean.SucLoginBean;
import cn.jwg.materialdesgin.core.database.sp.SharedPreferencesUtil;
import cn.jwg.materialdesgin.core.database.sp.UserInfoUtils;
import cn.jwg.materialdesgin.core.ui.base.TitleActivity;
import cn.jwg.materialdesgin.core.utils.config.AppConfig;
import cn.jwg.materialdesgin.core.utils.network.callback.DialogCallback;
import cn.jwg.materialdesgin.core.utils.string.StringUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;


public class LoginActivity extends TitleActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private EditText et_telephone_content, et_pwd_content;
    private String mPhoneNum, mPassword;
    private TextView tv_user_login;

    @Override
    protected void findViewId() {
        addView(View.inflate(this, R.layout.activity_login, null));
        et_telephone_content = (EditText) findViewById(R.id.et_telephone_content);
        et_pwd_content = (EditText) findViewById(R.id.et_pwd_content);
        tv_user_login = (TextView) findViewById(R.id.tv_user_login);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        hideButton(iv_title_right);
        tv_title_view.setText(getString(R.string.user_login));
        tv_title_right.setText(getString(R.string.user_register));
    }

    @Override
    protected void setListener() {
        rl_title_left.setOnClickListener(this);
        rl_title_right.setOnClickListener(this);
        tv_user_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_title_left:
                finish();
                break;
            case R.id.rl_title_right:
                gotoActivity(RegisterActivity.class);
                break;
            case R.id.tv_user_login:
                if (checkLogin()) {
                    //登录
                    userLoginAction();
                }
                break;
        }

    }

    private void userLoginAction() {
        OkGo.<SucLoginBean>post(AppConfig.WEB_SERVICE_TOKEN_URL)
                .tag(this)
                .params("grant_type", "password")
                .params("username", "17710189466")
                .params("password", "123456")
                .params("device_type", "android")
                .params("device_token", "111111111111111111111111")
                .headers("Authorization", "Basic cGF0aWVudF9hcHA6")
                .execute(new DialogCallback<SucLoginBean>(this) {
                    @Override
                    public void onSuccess(Response<SucLoginBean> response) {
                        SucLoginBean sLBean = response.body();
                        if (sLBean != null) {
                            loginSuccess(sLBean);
                        }

                    }

                    @Override
                    public void onError(Response<SucLoginBean> response) {
                    }
                });
    }


    private void loginSuccess(SucLoginBean bean) {
        SharedPreferencesUtil.getInstance(this).putAppLogoutFlag(false);
        UserInfoUtils.saveTokenInfo(this, bean);// 如有user_info.xml被删除的现象
        startActivity(new Intent(this, RxJavaActivity.class));
        finish();
    }

    private boolean checkLogin() {
        mPhoneNum = et_telephone_content.getText().toString().trim();
        if (TextUtils.isEmpty(mPhoneNum)) {
            showToast(getString(R.string.login_input_phone_num));
            return false;
        } else if (!StringUtils.isPhoneNumber(mPhoneNum)) {
            showToast(getString(R.string.register_phone_format_error));
            return false;
        }
        // 设置密码
        mPassword = et_pwd_content.getText().toString();
        if (TextUtils.isEmpty(mPassword)) {
            showToast(getString(R.string.login_input_password));
            return false;
        } else if (!StringUtils.checkPwdForm(mPassword)) {
            //当密码格式错误时直接提示"手机号或者密码错误"，不再发送网络请求
            showToast(getString(R.string.login_password_error));
            return false;
        }
        return true;
    }
}
