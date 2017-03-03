package com.wsy.lvnews.app;

import android.app.Application;

import com.wsy.lvnews.app.di.AppComponent;
import com.wsy.lvnews.app.di.AppModule;
import com.wsy.lvnews.app.di.DaggerAppComponent;

/**
 * 王少岩 在 2017/2/27 创建了它
 */

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
