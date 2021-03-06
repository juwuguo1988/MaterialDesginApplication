package cn.jwg.materialdesgin.core.ui.activity.db;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.bean.JavaDataBean;
import cn.jwg.materialdesgin.core.database.sqlite.bean.MedicPlan;
import cn.jwg.materialdesgin.core.database.sqlite.bean.UserBean;
import cn.jwg.materialdesgin.core.database.sqlite.utils.MedicPlanTableUtils;
import cn.jwg.materialdesgin.core.database.sqlite.utils.UserTableUtils;
import cn.jwg.materialdesgin.core.ui.base.TitleActivity;
import cn.jwg.materialdesgin.core.utils.config.AppConfig;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Juwuguo on 2017/8/16.
 */

public class MedicPlanActivity extends TitleActivity implements View.OnClickListener {

    private static final String TAG = "MedicPlanActivity";
    private ListView listView;
    private TextView tv_note_add, tv_note_delete, tv_note_edit, tv_note_query;
    private JavaDataBean javaDataBean;
    private UserBean mUserBean;

    private String jsonData = "{\n"
            + "    \"plans\": [\n"
            + "        {\n"
            + "            \"id\": \"roPqRl\",\n"
            + "            \"takeAt\": 915,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"卡托普利\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWNoeaJmOaZruWIqQ==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977862415,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505978100000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"r6wXnl\",\n"
            + "            \"takeAt\": 930,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"卡托普利\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWNoeaJmOaZruWIqQ==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977862415,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505979000000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"lj0DN5\",\n"
            + "            \"takeAt\": 945,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"卡托普利\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWNoeaJmOaZruWIqQ==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977862415,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505979900000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8VXVdr\",\n"
            + "            \"takeAt\": 960,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"卡托普利\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWNoeaJmOaZruWIqQ==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 4000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977862415,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505980800000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"lLXYNl\",\n"
            + "            \"takeAt\": 975,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"卡托普利\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWNoeaJmOaZruWIqQ==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 4000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977862415,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505981700000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8PXWm8\",\n"
            + "            \"takeAt\": 990,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"卡托普利\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWNoeaJmOaZruWIqQ==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 4000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977862415,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505982600000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8gB2zl\",\n"
            + "            \"takeAt\": 915,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"厄贝沙坦\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWOhOi0neaymeWdpg==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977927956,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505978100000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"l91QAl\",\n"
            + "            \"takeAt\": 930,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"厄贝沙坦\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWOhOi0neaymeWdpg==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977927956,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505979000000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"rwAYP8\",\n"
            + "            \"takeAt\": 945,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"厄贝沙坦\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWOhOi0neaymeWdpg==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977927956,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505979900000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"lOXyE8\",\n"
            + "            \"takeAt\": 960,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"厄贝沙坦\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWOhOi0neaymeWdpg==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977927956,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505980800000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"rq9Knr\",\n"
            + "            \"takeAt\": 975,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"厄贝沙坦\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWOhOi0neaymeWdpg==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977927956,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505981700000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"l1VEz8\",\n"
            + "            \"takeAt\": 990,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"厄贝沙坦\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWOhOi0neaymeWdpg==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1505977927956,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1505982600000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8PXGj8\",\n"
            + "            \"takeAt\": 480,\n"
            + "            \"medicineId\": \"rqyqKr\",\n"
            + "            \"medicineName\": \"复方熊胆滴眼液\",\n"
            + "            \"medicineHash\": \"cnF5cUtyfOWkjeaWueeGiuiDhua7tOecvOa2sg==\",\n"
            + "            \"medicineVia\": 1,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1501578761785,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1501632000000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"l3PRd8\",\n"
            + "            \"takeAt\": 480,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"尼群地平\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWwvOe+pOWcsOW5sw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1500359997626,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1500422400000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"5xKzZ8\",\n"
            + "            \"takeAt\": 720,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"尼群地平\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWwvOe+pOWcsOW5sw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1500359997626,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1500436800000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"lQDvMr\",\n"
            + "            \"takeAt\": 1080,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"尼群地平\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWwvOe+pOWcsOW5sw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1500359997626,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1500372000000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8yEz28\",\n"
            + "            \"takeAt\": 1320,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"尼群地平\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOWwvOe+pOWcsOW5sw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1500359997626,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1500386400000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"reBj7l\",\n"
            + "            \"takeAt\": 360,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"欣康\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOaso+W6tw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1502078575965,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1502143200000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"lGXRe8\",\n"
            + "            \"takeAt\": 480,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"欣康\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOaso+W6tw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1502078575965,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1502150400000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8N6Oa8\",\n"
            + "            \"takeAt\": 540,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"泰嘉\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOazsOWYiQ==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1502086801484,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1502154000000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"5bBYX5\",\n"
            + "            \"takeAt\": 480,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"蒙诺\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOiSmeivug==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1500446750151,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1500508800000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"5AMm05\",\n"
            + "            \"takeAt\": 495,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"蒙诺\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOiSmeivug==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1500446750151,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1500509700000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8K6LJl\",\n"
            + "            \"takeAt\": 510,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"蒙诺\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOiSmeivug==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1500446750151,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1500510600000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"ldJWX5\",\n"
            + "            \"takeAt\": 480,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"阿司匹林肠溶片\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOmYv+WPuOWMueael+iCoOa6tueJhw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 0,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1499246443177,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1499299200000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"rYB4xl\",\n"
            + "            \"takeAt\": 840,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"阿司匹林肠溶片\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOmYv+WPuOWMueael+iCoOa6tueJhw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 1,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1499246443177,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1499320800000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        },\n"
            + "        {\n"
            + "            \"id\": \"8XXxo8\",\n"
            + "            \"takeAt\": 960,\n"
            + "            \"medicineId\": \"a8V4rK\",\n"
            + "            \"medicineName\": \"阿司匹林肠溶片\",\n"
            + "            \"medicineHash\": \"YThWNHJLfOmYv+WPuOWMueael+iCoOa6tueJhw==\",\n"
            + "            \"medicineVia\": 2,\n"
            + "            \"count\": 1000,\n"
            + "            \"dosage\": 20000,\n"
            + "            \"cycleDays\": 0,\n"
            + "            \"zone\": 2,\n"
            + "            \"positionNo\": 0,\n"
            + "            \"dosageUnit\": \"mg\",\n"
            + "            \"started\": 1499246443177,\n"
            + "            \"ended\": null,\n"
            + "            \"remindFirstAt\": 1499328000000,\n"
            + "            \"boxUuid\": null,\n"
            + "            \"planSeqWithBox\": null\n"
            + "        }\n"
            + "    ]\n"
            + "}";

    private String userJson = "{\n"
            + "    \"name\": \"张三\",\n"
            + "    \"area\": \"河北省 张家口市 崇礼县\",\n"
            + "    \"address\": \"，？B-)土楼MSN给哦累\",\n"
            + "    \"avatar\": \"https://s3.cn-north-1.amazonaws.com.cn/patient-avatars-dev/1c958592-410e-487f-b758-870d24f046ca\",\n"
            + "    \"tel\": \"17710189466\",\n"
            + "    \"birthday\": 1246377600000,\n"
            + "    \"sex\": 0,\n"
            + "    \"status\": 1,\n"
            + "    \"type\": 1,\n"
            + "    \"height\": \"134\",\n"
            + "    \"weight\": \"119\",\n"
            + "    \"waistline\": \"52\",\n"
            + "    \"marriage\": 1,\n"
            + "    \"education\": 2,\n"
            + "    \"ethnicity\": \"汉族\"\n"
            + "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void findViewId() {
        addView(View.inflate(this, R.layout.activity_note, null));
        listView = (ListView) findViewById(R.id.listView);
        tv_note_add = (TextView) findViewById(R.id.tv_note_add);
        tv_note_delete = (TextView) findViewById(R.id.tv_note_delete);
        tv_note_edit = (TextView) findViewById(R.id.tv_note_edit);
        tv_note_query = (TextView) findViewById(R.id.tv_note_query);
    }

    @Override
    protected void initData() {
        javaDataBean = new Gson().fromJson(jsonData, JavaDataBean.class);
        mUserBean = new Gson().fromJson(userJson, UserBean.class);
    }

    @Override
    protected void initView() {
        hideButton(rl_title_right);
    }

    @Override
    protected void setListener() {
        rl_title_left.setOnClickListener(this);
        tv_note_add.setOnClickListener(this);
        tv_note_delete.setOnClickListener(this);
        tv_note_edit.setOnClickListener(this);
        tv_note_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_note_add:
                for (MedicPlan mp : javaDataBean.getPlans()) {
                    MedicPlanTableUtils.saveMedicPlan(mp);
                }
                break;
            case R.id.tv_note_delete:
                mUserBean.setUId(AppConfig.currentUserId);
                UserTableUtils.saveUser(mUserBean);
                break;
            case R.id.tv_note_edit:
                MedicPlan medicPlan = MedicPlanTableUtils.getMedicPlanByMedicPlanId("r6wXnl");
                List<MedicPlan> strings = MedicPlanTableUtils.getMedicPlansByMedicHash(medicPlan.getMedicineHash());
                Log.e(TAG, "================>" + strings.size());
                break;
            case R.id.tv_note_query:
                disPlayMedicPlan();
                break;
            case R.id.rl_title_left:
                finish();
                break;
        }

    }

    private void disPlayMedicPlan() {
        SimpleAdapter adapter = new SimpleAdapter(this, getMedicPlanData(),
                R.layout.item_note_layout, new String[]{"name", "time", "count"},
                new int[]{R.id.title, R.id.content, R.id.time});
        listView.setAdapter(adapter);
    }

    private List<Map<String, Object>> getMedicPlanData() {
        List<MedicPlan> medicPlens = MedicPlanTableUtils.getAllMedicPlans();
        List<Map<String, Object>> list = new ArrayList<>();
        for (MedicPlan mp : medicPlens) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", mp.getMedicineName());
            map.put("time", mp.getTakeAt());
            map.put("count", mp.getCount());
            list.add(map);
        }
        return list;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
