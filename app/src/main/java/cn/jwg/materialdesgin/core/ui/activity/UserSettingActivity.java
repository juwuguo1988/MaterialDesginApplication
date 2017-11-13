package cn.jwg.materialdesgin.core.ui.activity;


import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.ui.base.TitleActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juwuguo on 2017/9/11.
 */

public class UserSettingActivity extends TitleActivity implements View.OnClickListener {

    private static final String TAG = "UserSettingActivity";

    @Override
    protected void findViewId() {
        addView(View.inflate(this, R.layout.activity_user_setting, null));
    }

    @Override
    protected void initData() {
        initViewTwo();
    }


    public void initViewTwo(){
        RadioGroup radiogroup=(RadioGroup) findViewById(R.id.gadiogroup);
        addview(radiogroup);
    }
    public List<String> getListSize(){
        List<String>list=new ArrayList<>();
        list.add("服装33333");
        list.add("玩具44444");
        list.add("饰品5555");
        list.add("饰品6666");
        list.add("文具7777");
        list.add("文具8888");
        list.add("文具9999");
        return list;
    }

    //动态添加视图
    public void addview(RadioGroup radiogroup){
        for(String ss:getListSize()){
            RadioButton  button=new RadioButton(this);
            setRaidBtnAttribute(button,ss);
            radiogroup.addView(button);
        }
    }
    private void setRaidBtnAttribute( final RadioButton codeBtn, String btnContent){
        if( null == codeBtn ){
            return;
        }
        codeBtn.setButtonDrawable(R.color.transparent);
        Drawable drawable = getResources().getDrawable(R.drawable.btn_medic_check_box);
        drawable.setBounds(-10, 0, 60, 70);
        codeBtn.setCompoundDrawables(drawable, null, null, null);
        codeBtn.setCompoundDrawablePadding(20);
        codeBtn.setPadding(10, 30, 10, 30);
        codeBtn.setText(btnContent);
        codeBtn.setTextSize(16);
        codeBtn.setTextColor(getResources().getColor(R.color.c_666666));
        codeBtn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserSettingActivity.this, codeBtn.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void initView() {
        hideView(iv_title_right);
    }

    @Override
    protected void setListener() {
        rl_title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_title_left:
                finish();
                break;
        }
    }
}
