package com.wsy.lvnews.splash.viewmodel;

import android.app.Activity;
import android.databinding.ObservableField;
import android.os.CountDownTimer;

import com.wsy.lvnews.main.view.MainActivity;
import com.wsy.lvnews.utils.NavigateUtils;

import javax.inject.Inject;

/**
 * Created by 王少岩 on 2016/12/20.
 */
public class SplashViewModel {
    private Activity mActivity;
    private MyCount mCount;
    public final ObservableField<String> seconds = new ObservableField<>();

    @Inject
    public SplashViewModel(Activity activity) {
        this.mActivity = activity;
        mCount = new MyCount(3000, 1000);
        mCount.start();
    }

    public class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            seconds.set("0s");
            NavigateUtils.startActivity(mActivity, MainActivity.class);
            mActivity.finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            seconds.set(millisUntilFinished / 1000 + "s");
        }
    }
}
