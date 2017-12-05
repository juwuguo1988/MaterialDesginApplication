package cn.jwg.materialdesgin.core.utils.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juwuguo on 2017/10/13.
 */

public class AppConfig {

    //通用设置
    public static String DATABASE_NAME = "demo-db";
    public static String currentUserId;             //当前登录用户的userId


    public static final String XZL_DEBUG_BASE_URL = "http://172.16.10.13:9004/api/v0";


    public static final String WEB_SERVICE_TOKEN_URL = XZL_DEBUG_BASE_URL + "/oauth/token";              //申请Token

    public static final String WEB_SERVICE_PATIENT_URL = XZL_DEBUG_BASE_URL + "/patient";

    public static final String WEB_APP_PLAN_URL = WEB_SERVICE_PATIENT_URL + "/plan";

    public static final String DEMO_FILE_PATH_SDCARD =
            "data/data/" + "cn.jwg.materialdesgin.core" + "/databases/";


    public static List<String> getEmptyBoxCode() {
        List<String> mBoxCodeList = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
        }};
        return mBoxCodeList;
    }

}
