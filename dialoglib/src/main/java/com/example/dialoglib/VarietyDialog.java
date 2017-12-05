package com.example.dialoglib;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * 多样化自定义dialog
 * created by mms on 21/11/2017
 */
public class VarietyDialog extends Dialog {
    /**
     * 标题＋消息＋中间layout＋两个按钮
     */
    public static final int TYPE_TITLE_MESSAGE_CENTER_DOUBLEBTN = 10000;
    /**
     * 标题＋消息＋中间layout＋一个按钮
     */
    public static final int TYPE_TITLE_MESSAGE_CENTER_SINGLEBTN = 10001;
    /**
     * 标题＋消息+一个按钮
     */
    public static final int TYPE_TITLE_MESSAGE_SINGLEBTN = 10002;
    /**
     * 标题＋消息+两个按钮
     */
    public static final int TYPE_TITLE_MESSAGE_DOUBLEBTN = 10003;
    /**
     * 标题＋中间layout＋一个按钮
     */
    public static final int TYPE_TITLE_CENTER_SINGLEBTN = 10004;
    /**
     * 消息＋中间layout＋一个按钮
     */
    public static final int TYPE_MESSAGE_CENTER_SINGLEBTN = 10005;
    /**
     * 标题＋中间layout＋两个按钮
     */
    public static final int TYPE_TITLE_CENTER_DOUBLEBTN = 10006;
    /**
     * 消息＋中间layout＋两个按钮
     */
    public static final int TYPE_MESSAGE_CENTER_DOUBLEBTN = 10007;
    /**
     * 中间layout＋一个按钮
     */
    public static final int TYPE_CENTER_SINGLEBTN = 10008;
    /**
     * 中间layout＋两个按钮
     */
    public static final int TYPE_CENTER_DOUBLEBTN = 10009;
    /**
     * 中间layout＋两个按钮
     */
    public static final int TYPE_CENTER = 10010;

    private Context context;
    private ViewGroup rootView;
    private View centerView;
    private View topView;
    private View btnView;

    private TextView titleTv;
    private TextView msgTv;
    private TextView leftBtnTv;
    private TextView rightBtnTv;

    private int height;
    private int width;
    private int gravity = Gravity.CENTER;
    private String centerBtnStr;
    private String leftBtnStr;
    private String rightBtnStr;
    private String titleStr;
    private String msgStr;
    private int dialogType;
    private boolean canceledOutSide;//dialog外部点击可否消失

    private DialogClickBack clickBack;
    private boolean cancelable;


    public VarietyDialog(DialogViewBuilder builder) {
        super(builder.context);
        this.context = builder.context;
        this.centerView = builder.centerView;
        this.titleStr = builder.titleStr;
        this.msgStr = builder.msgStr;
        this.leftBtnStr = builder.leftBtnStr;
        this.rightBtnStr = builder.rightBtnStr;
        this.canceledOutSide = builder.canceledOutSide;
        this.cancelable = builder.isCanceled;
        this.clickBack = builder.clickBack;
        this.dialogType = builder.dialogType;
        this.height = builder.height;
        this.width = builder.width;
        this.gravity = builder.gravity;

    }

    public VarietyDialog(DialogViewBuilder builder, int theme) {
        super(builder.context, theme);
        this.context = builder.context;
        this.centerView = builder.centerView;
        this.titleStr = builder.titleStr;
        this.msgStr = builder.msgStr;
        this.leftBtnStr = builder.leftBtnStr;
        this.rightBtnStr = builder.rightBtnStr;
        this.canceledOutSide = builder.canceledOutSide;
        this.clickBack = builder.clickBack;
        this.dialogType = builder.dialogType;
        this.height = builder.height;
        this.width = builder.width;
        this.gravity = builder.gravity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initView();
        setContentView(rootView);
        setCanceledOnTouchOutside(canceledOutSide);
        setCancelable(cancelable);
        setDialogUI(dialogType);
        setDialogSize();
    }

    /**
     * 根据type设置布局样式
     *
     * @param centerViewType
     */
    private void setDialogUI(int centerViewType) {

        switch (centerViewType) {
            case TYPE_TITLE_MESSAGE_CENTER_DOUBLEBTN:
                setTitleAndMsg(true, true);
                setBtnstr(false);
                rootView.addView(topView);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_TITLE_MESSAGE_CENTER_SINGLEBTN:
                setTitleAndMsg(true, true);
                setBtnstr(true);
                rootView.addView(topView);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_TITLE_MESSAGE_SINGLEBTN:
                setTitleAndMsg(true, true);
                setBtnstr(true);
                rootView.addView(topView);
                rootView.addView(btnView);
                break;
            case TYPE_TITLE_MESSAGE_DOUBLEBTN:
                setTitleAndMsg(true, true);
                setBtnstr(false);
                rootView.addView(topView);
                rootView.addView(btnView);
                break;
            case TYPE_TITLE_CENTER_SINGLEBTN:
                setTitleAndMsg(true, false);
                setBtnstr(true);
                rootView.addView(topView);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_MESSAGE_CENTER_SINGLEBTN:
                setTitleAndMsg(false, true);
                setBtnstr(true);
                rootView.addView(topView);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_TITLE_CENTER_DOUBLEBTN:
                setTitleAndMsg(true, false);
                setBtnstr(false);
                rootView.addView(topView);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_MESSAGE_CENTER_DOUBLEBTN:
                setTitleAndMsg(false, true);
                setBtnstr(false);
                rootView.addView(topView);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_CENTER_SINGLEBTN:
                setBtnstr(true);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_CENTER_DOUBLEBTN:
                setBtnstr(false);
                rootView.addView(centerView);
                rootView.addView(btnView);
                break;
            case TYPE_CENTER:
                rootView.addView(centerView);
                break;
        }
    }

    private void initView() {
        rootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_root_view, null);
        topView = LayoutInflater.from(context).inflate(R.layout.layout_top_view, null);
        btnView = LayoutInflater.from(context).inflate(R.layout.layout_btn_view, null);
        msgTv = (TextView) topView.findViewById(R.id.tvMsg);
        titleTv = (TextView) topView.findViewById(R.id.tvTitle);
        leftBtnTv = (TextView) btnView.findViewById(R.id.left_btn_tv);
        rightBtnTv = (TextView) btnView.findViewById(R.id.right_btn_tv);
        leftBtnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBack.left();
            }
        });
        rightBtnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBack.right();
            }
        });
    }

    /**
     * 设置按钮个数及文字
     *
     * @param isSingle
     */
    private void setBtnstr(boolean isSingle) {
        leftBtnTv.setText(leftBtnStr);
        if (isSingle) {
            rightBtnTv.setVisibility(View.GONE);
        } else {
            rightBtnTv.setText(rightBtnStr);
        }
    }

    /**
     * 设置标题和消息的显示及文案展示
     *
     * @param hasTitle
     * @param hasMsg
     */
    private void setTitleAndMsg(boolean hasTitle, boolean hasMsg) {
        if (hasTitle) {
            titleTv.setText(titleStr);
        } else {
            titleTv.setVisibility(View.GONE);
        }
        if (hasMsg) {
            msgTv.setText(msgStr);
        } else {
            msgTv.setVisibility(View.GONE);
        }
    }

    private void setDialogSize() {
        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = gravity;
        lp.height = height;
        lp.width = width;
        win.setAttributes(lp);
//        win.requestFeature(Window.FEATURE_NO_TITLE);
        win.setBackgroundDrawableResource(android.R.color.white);
    }

    public void dialogDissmis() {
        if (null != this && isShowing())
            dismiss();
    }

    public View getCenterView() {
        return centerView;
    }

    public interface DialogClickBack {
        void left();

        void right();
    }

    /**
     * Created by mms on 17/11/22.
     */

    public static final class DialogViewBuilder {
        private Context context;
        private View centerView;
        private int theme = -1;
        private int dialogType;
        private int height;
        private int width;
        private int gravity;
        private String titleStr;
        private String msgStr;
        private String leftBtnStr;
        private String rightBtnStr;
        private boolean canceledOutSide = true;//dialog外部点击可否消失
        private DialogClickBack clickBack;
        private boolean isCanceled = true;

        public DialogViewBuilder(Context context) {
            this.context = context;
        }

        public DialogViewBuilder setDialogCenterView(int layoutId) {
            this.centerView = LayoutInflater.from(context).inflate(layoutId, null);
            return this;
        }

        public DialogViewBuilder setDialogCenterView(View centerView) {
            this.centerView = centerView;
            return this;
        }

        public DialogViewBuilder setDialogTheme(int theme) {
            this.theme = theme;
            return this;
        }

        /**
         * 设置dialog显示样式
         *
         * @param dialogType
         * @return
         */
        public DialogViewBuilder setDialogType(int dialogType) {
            this.dialogType = dialogType;
            return this;
        }

        /**
         * 设置dialog大小
         *
         * @param heightDimen
         * @param widthDimen
         * @return
         */
        public DialogViewBuilder setDialogSize(int heightDimen, int widthDimen) {
            this.height = heightDimen < 0 ? heightDimen : context.getResources().getDimensionPixelOffset(heightDimen);
            this.width = widthDimen < 0 ? widthDimen : context.getResources().getDimensionPixelOffset(widthDimen);
            return this;
        }

        /**
         * 设置dialog在屏幕的位置
         *
         * @param gravity
         * @return
         */
        public DialogViewBuilder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        /**
         * dialog标题和消息文案
         *
         * @param titleStr
         * @param msgStr
         * @return
         */
        public DialogViewBuilder setTitleOrMsg(String titleStr, String msgStr) {
            this.titleStr = titleStr;
            this.msgStr = msgStr;
            return this;
        }

        /**
         * dialog按钮文案
         *
         * @param leftBtnStr
         * @param rightBtnStr
         * @return
         */
        public DialogViewBuilder setBtnStr(String leftBtnStr, String rightBtnStr) {
            this.leftBtnStr = leftBtnStr;
            this.rightBtnStr = rightBtnStr;
            return this;
        }

        public DialogViewBuilder setDialogCancelOutSide(boolean canceledOutSide) {
            this.canceledOutSide = canceledOutSide;
            return this;
        }

        public DialogViewBuilder setDialogIsCanceled(boolean isCanceled) {
            this.isCanceled = isCanceled;
            return this;
        }

        public DialogViewBuilder setClickBack(DialogClickBack clickBack) {
            this.clickBack = clickBack;
            return this;
        }


        public VarietyDialog build() {
            if (-1 == theme)
                return new VarietyDialog(this);
            else
                return new VarietyDialog(this, theme);
        }
    }
}
