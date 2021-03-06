package com.wsy.lvnews.net;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;

import com.wsy.lvnews.R;


/**
 * Created by 王少岩 on 2017/1/19.
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;
    private Activity mActivity;

    private ProgressDialog pd;

    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;

    public ProgressDialogHandler(Activity activity, ProgressCancelListener mProgressCancelListener, boolean cancelable) {
        super();
        this.mActivity = activity;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
    }

    private void initProgressDialog() {
        if (pd == null) {
            pd = new ProgressDialog(mActivity, R.style.AppTheme_Dark_Dialog);
            pd.setIndeterminate(true);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage("加载中");
            pd.show();

            pd.setCancelable(cancelable);

            if (cancelable) {
                pd.setOnCancelListener(dialogInterface -> mProgressCancelListener.onCancelProgress());
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
