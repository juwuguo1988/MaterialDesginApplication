package cn.jwg.materialdesgin.core.utils.ui;

import android.content.Context;
import cn.jwg.materialdesgin.core.R;

/**
 * 项目中需添加特殊逻辑判断的字符串工具
 */
public class StringValidUtils {

    public static String validBoxNum(Context context, String selectResult) {
        String returnStr = "";
        if (selectResult.equals(context.getString(R.string.medic_box_no_code))) {
            returnStr = "0";
        } else {
            returnStr = selectResult;
        }
        return returnStr;
    }
}
