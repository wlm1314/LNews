package com.wsy.lvnews.base.di;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 王少岩 on 2017/2/24.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    public Activity provideActivity(){
        return mActivity;
    }
}
