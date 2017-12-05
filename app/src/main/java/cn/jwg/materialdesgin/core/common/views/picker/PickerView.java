package cn.jwg.materialdesgin.core.common.views.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.views.wheelview.MedicPlanBoxNumWheelView;
import java.util.List;

/**
 * Created by mms on 17/11/30.
 */

public class PickerView {
    private Context mContext;
    private View layout;
    private MedicPlanBoxNumWheelView pickerView;
    private PickClickCallBack clickCallBack;

    public PickerView(Context mContext, List<String> pickerDatas, String curItem) {
        this.mContext = mContext;
        layout = LayoutInflater.from(mContext).inflate(R.layout.popu_medic_box_code_picker, null);
        initPickerView(pickerDatas, curItem);
        initBtn();
    }

    public void setPickClickCallBack(PickClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    private void initPickerView(List<String> pickerDatas, String curItem) {
        pickerView = new MedicPlanBoxNumWheelView(mContext, layout);
        pickerView.initMedicPlanRemindCountPicker(pickerDatas, curItem);
    }

    private void initBtn() {
        RelativeLayout leftBtn = (RelativeLayout) layout.findViewById(R.id.rl_select_cancel_btn);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取消
                clickCallBack.leftClick();
            }
        });

        //确定按钮
        RelativeLayout rightBtn = (RelativeLayout) layout.findViewById(R.id.rl_select_sure_btn);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确定
                clickCallBack.rightClick(pickerView.getMedicBoxNum());
            }
        });
    }

    public View getLayout() {
        return layout;
    }

    public interface PickClickCallBack {
        void leftClick();

        void rightClick(String selectResult);
    }
}
