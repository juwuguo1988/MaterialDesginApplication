package cn.jwg.materialdesgin.core.utils.ui;

import android.app.Dialog;
import android.content.Context;
import cn.jwg.materialdesgin.core.R;


public class LoadingDialog extends Dialog {

	public LoadingDialog(Context context, boolean cancel) {
		super(context, R.style.dialog_loading);
		setCanceledOnTouchOutside(cancel);
		init();
	}


	private void init() {
		setContentView(R.layout.dialog_loading);
	}
}
