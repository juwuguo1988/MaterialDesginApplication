package cn.jwg.materialdesgin.core.ui.base;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.utils.device.DeviceUtils;
import cn.jwg.materialdesgin.core.utils.ui.LoadingDialog;
import cn.jwg.materialdesgin.core.utils.ui.UI;
import cn.jwg.materialdesgin.core.utils.ui.UIUtils;
import cn.jwg.materialdesgin.core.utils.status.StatusBarUtil;
import java.io.File;
import java.util.List;

/**
 * 带Title的Activity的基类
 */
public abstract class TitleActivity extends BaseFragmentActivity {

    public TextView tv_title_view;
    public TextView tv_title_left;
    public TextView view_cut_line;
    public TextView tv_title_right;
    public ImageView iv_title_left;
    public ImageView iv_title_right;
    public ImageView iv_title_view;
    public RelativeLayout rl_title_left;
    public RelativeLayout rl_title_right;
    public RelativeLayout rlTitle;
    public RelativeLayout rl_navi_bar_mask;

    public int dmw, dmh;
    public DisplayMetrics dm;
    private LoadingDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        setStatusBar();
        init();
        findViewId();
        initData();
        initView();
        setListener();
    }

    private void init() {
        tv_title_view = (TextView) findViewById(R.id.tv_title_view);
        tv_title_left = (TextView) findViewById(R.id.tv_title_left);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
        view_cut_line = (TextView) findViewById(R.id.view_cut_line);
        iv_title_left = (ImageView) findViewById(R.id.iv_title_left);
        iv_title_right = (ImageView) findViewById(R.id.iv_title_right);
        iv_title_view = (ImageView) findViewById(R.id.iv_title_view);
        rl_title_left = (RelativeLayout) findViewById(R.id.rl_title_left);
        rl_title_right = (RelativeLayout) findViewById(R.id.rl_title_right);
        rlTitle = (RelativeLayout) findViewById(R.id.rl_title);
        rl_navi_bar_mask = (RelativeLayout) findViewById(R.id.rl_navi_bar_mask);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        dmw = dm.widthPixels;
        dmh = dm.heightPixels;
        rlTitle.setLayoutParams(UI.getLinearLayoutPararmWH(dmw, dmh, UI.ORG_SCREEN_WIDTH, 60));
    }

    protected abstract void findViewId();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setListener();

    public void addView(View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.view_contenner);
        layout.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    public void removeView(View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.view_contenner);
        layout.removeView(view);
    }

    public void setBackgroudColor(int color) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.view_contenner);
        layout.setBackgroundColor(color);
    }

    public void setBackgroudResouce(int resid) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.view_contenner);
        layout.setBackgroundResource(resid);
    }

    public void setTitle(String title) {
        tv_title_view.setText(title);
    }

    public void setTextRight(String str) {
        tv_title_right.setText(str);
    }

    public void setImageRight(int resid) {
        iv_title_right.setVisibility(View.VISIBLE);
        iv_title_right.setImageResource(resid);
    }

    public void setTextLeft(String str) {
        tv_title_left.setText(str);
    }

    public void setImageLeft(int resid) {
        iv_title_left.setVisibility(View.VISIBLE);
        iv_title_left.setImageResource(resid);
    }

    public void showButton(View view, int backRes) {
        if (backRes != 0) {
            view.setBackgroundResource(backRes);
        }
        view.setVisibility(View.VISIBLE);
    }

    public void hideButton(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    public void hideView(View view) {
        view.setVisibility(View.GONE);
    }

    public void hideTitleBar() {
        rlTitle.setVisibility(View.GONE);
    }

    public void showTitleBar() {
        rlTitle.setVisibility(View.GONE);
    }

    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();
        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }

        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName) && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得sd卡剩余容量
     */
    public long getSDAvailableSizes() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return blockSize * availableBlocks;
    }

    public String getAppVer() {
        return DeviceUtils.getVersionName(this);
    }

    protected void gotoActivity(Class<?> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    protected void gotoActivity(Class<?> c, Bundle bundle) {
        Intent intent = new Intent(this, c);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void showProgressDialog() {
        try {
            dismissProgressDialog();
            dialog = new LoadingDialog(this, false);
            dialog.show();
        } catch (Exception e) {
        }
    }

    public void dismissProgressDialog() {
        try {
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e) {
        }
    }

    protected String s(int resId) {
        return getString(resId);
    }

    protected boolean isNetwork() {
        return UIUtils.isNetworkConnected(this);
    }

    public void showToast(String str) {
        UIUtils.createToast(mContext, str);
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.c_2bb2ba));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
    }
}
