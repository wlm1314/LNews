package com.wsy.lvnews.net.subscribers;


import android.app.Activity;

import com.google.gson.JsonSyntaxException;
import com.wsy.lvnews.net.ProgressCancelListener;
import com.wsy.lvnews.net.ProgressDialogHandler;
import com.wsy.lvnews.utils.BaseLog;
import com.wsy.lvnews.utils.Utils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Created by 王少岩 on 2017/2/5.
 */

public abstract class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
    private ProgressDialogHandler mProgressDialogHandler;

    public ProgressSubscriber(Activity activity) {
        mProgressDialogHandler = new ProgressDialogHandler(activity, this, true);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        showProgressDialog();
    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            Utils.showToast("请求超时,请重试");
        } else if (e instanceof ConnectException) {
            Utils.showToast("请求超时,请重试");
        } else if (e instanceof JsonSyntaxException) {
            Utils.showToast("数据解析错误");
            BaseLog.e("数据解析错误:::" + e.getMessage());
        } else {
            BaseLog.e(e.getMessage());
        }
        dismissProgressDialog();
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}