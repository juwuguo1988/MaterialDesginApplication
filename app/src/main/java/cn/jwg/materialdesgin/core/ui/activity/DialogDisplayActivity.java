package cn.jwg.materialdesgin.core.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.views.picker.PickerView;
import cn.jwg.materialdesgin.core.ui.base.BaseFragmentActivity;
import cn.jwg.materialdesgin.core.utils.config.AppConfig;
import cn.jwg.materialdesgin.core.utils.ui.BoxGifGlide;
import com.example.dialoglib.VarietyDialog;

public class DialogDisplayActivity extends BaseFragmentActivity implements OnClickListener {

    private RelativeLayout rl_menu_container;
    public static VarietyDialog gifOpenDialog;//开盖gif
    public static VarietyDialog gifCloseDialog;//关盖gif
    private static final int CYCLE_GET_CHAT_DATA = 1;
    private static final int CYCLE_GET_CLOSE = 2;
    private static final int INTERVAL = 1000 * 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViewById();
        initView();
        setListener();
    }

    private void findViewById() {
        rl_menu_container = (RelativeLayout) findViewById(R.id.rl_menu_container);
    }

    private void initView() {
        rl_menu_container.setVisibility(View.VISIBLE);
        showBoxGifDialog(DialogDisplayActivity.this, 2);
    }

    /**
     * 选药仓dialog
     */
    public void showBoxGifDialog(final Activity context, int selectNum) {
        final Dialog dialogList = new AlertDialog.Builder(context).create();
        dialogList.setCancelable(false);
        dialogList.show();
        PickerView pickerView = new PickerView(context, AppConfig.getEmptyBoxCode(),
                String.valueOf(selectNum));
        pickerView.setPickClickCallBack(new PickerView.PickClickCallBack() {
            @Override
            public void leftClick() {
                //取消
                dialogList.dismiss();
                context.finish();
            }

            @Override
            public void rightClick(String selectResult) {
                //确定
                dialogList.dismiss();
                mHandler.sendEmptyMessageDelayed(CYCLE_GET_CHAT_DATA,INTERVAL);
                showGifOpenDialog(context, 1);
            }
        });
     /*   dialogList.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                context.finish();
            }
        });*/
        dialogList.getWindow().setContentView(pickerView.getLayout());

    }

    /**
     * 初始化开盖gif展示框
     */
    public void showGifOpenDialog(final Activity context, final int searchBy) {
        View gifLayout = LayoutInflater.from(context).inflate(R.layout.gif_imageview, null);
        VarietyDialog.DialogViewBuilder builder = new VarietyDialog.DialogViewBuilder(context);
        gifOpenDialog = builder.setDialogType(VarietyDialog.TYPE_CENTER)
                .setDialogSize(R.dimen.gif_view_height, R.dimen.gif_view_width)
                .setDialogCenterView(gifLayout)
                .setDialogCancelOutSide(false)
                .setDialogIsCanceled(false)
                .build();
        showGif(context, R.drawable.open, gifLayout);
        gifOpenDialog.show();
        gifOpenDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                showGifCloseDialog(context, searchBy);
                gifOpenDialog = null;
            }
        });
    }

    /**
     * 初始化关盖gif展示框
     */
    public void showGifCloseDialog(final Activity context, final int searchBy) {
        View gifLayout = LayoutInflater.from(context).inflate(R.layout.gif_imageview, null);
        VarietyDialog.DialogViewBuilder builder = new VarietyDialog.DialogViewBuilder(context);
        gifCloseDialog = builder.setDialogType(VarietyDialog.TYPE_CENTER)
                .setDialogSize(R.dimen.gif_view_height, R.dimen.gif_view_width)
                .setDialogCenterView(gifLayout)
                .setDialogCancelOutSide(false)
                .setDialogIsCanceled(false)
                .build();
        showGif(context, R.drawable.close, gifLayout);
        gifCloseDialog.show();
        gifCloseDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                context.finish();
                gifCloseDialog = null;
            }
        });
    }

    /**
     * 处理gif的dialogUI展示（文案）
     */
    public void showGif(Context context, int drawable, View gifLayout) {
        new BoxGifGlide(context).startOpen(drawable, (ImageView) gifLayout.findViewById(R.id.gif_img));
        TextView firstLine = (TextView) gifLayout.findViewById(R.id.box_dialog_first);
        TextView secondLine = (TextView) gifLayout.findViewById(R.id.box_dialog_second);
        switch (drawable) {
            case R.drawable.open:
                firstLine.setText(context.getString(R.string.box_open_first));
                secondLine.setText(context.getString(R.string.box_open_second));
                break;
            case R.drawable.close:
                firstLine.setText(context.getString(R.string.box_close_first));
                secondLine.setText(context.getString(R.string.box_close_second));
                break;
        }
    }

    private void setListener() {
        rl_menu_container.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_menu_container:
                finish();
                break;
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CYCLE_GET_CHAT_DATA:
                    mHandler.sendEmptyMessageDelayed(CYCLE_GET_CLOSE, INTERVAL);
                    gifOpenDialog.dismiss();
                    break;
                case CYCLE_GET_CLOSE:
                    gifCloseDialog.dismiss();
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
