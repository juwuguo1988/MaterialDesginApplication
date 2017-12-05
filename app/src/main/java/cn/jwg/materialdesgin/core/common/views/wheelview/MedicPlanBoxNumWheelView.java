package cn.jwg.materialdesgin.core.common.views.wheelview;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.views.pickers.SinglePicker;
import cn.jwg.materialdesgin.core.common.views.pickers.listeners.OnSingleWheelListener;
import java.util.List;

public class MedicPlanBoxNumWheelView {

    private Context mContext;
    private View view;
    private LinearLayout ll_nums;
    private SinglePicker mNumsPicker;
    private int medicBoxNum;
    private String[] boxNumArray;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public MedicPlanBoxNumWheelView(Context mContext, View view) {
        super();
        this.view = view;
        this.mContext = mContext;
        setView(view);
    }

    /**
     * 弹出剂量选择器
     */
    public void initMedicPlanRemindCountPicker(List<String> mBoxCodeList, String nums) {
        boxNumArray = mBoxCodeList.toArray(new String[mBoxCodeList.size()]);
        // 片数
        ll_nums = (LinearLayout) view.findViewById(R.id.ll_nums);
        mNumsPicker = new SinglePicker(mContext, boxNumArray);
        mNumsPicker.setCanLoop(false);//不禁用循环
        mNumsPicker.setWheelModeEnable(true);
        mNumsPicker.setTextSize(18);
        mNumsPicker.setSelectedTextColor(mContext.getResources().getColor(R.color.c_2bb2ba));
        mNumsPicker.setUnSelectedTextColor(mContext.getResources().getColor(R.color.c_c5c5c5));
        mNumsPicker.setItemWidth(200);
        mNumsPicker.setLineVisible(true);
        mNumsPicker.setShadowVisible(false);

        try {
            if(nums.equals(mContext.getString(R.string.medic_box_no_code))){
                medicBoxNum = 0;
            }else{
                medicBoxNum = mBoxCodeList.indexOf(nums);
            }
        } catch (Exception e) {
            medicBoxNum = 0;
        }
        mNumsPicker.setSelectedIndex(medicBoxNum);
        ll_nums.removeAllViews();
        ll_nums.addView(mNumsPicker.getContentView());
        mNumsPicker.setOnSingleWheelListener(new OnSingleWheelListener() {
            @Override
            public void onWheeled(int index, String item) {
                medicBoxNum = index;
            }
        });


    }

    /**
     * 获取服药片数
     */
    public String getMedicBoxNum() {
        return boxNumArray[medicBoxNum];
    }
}
