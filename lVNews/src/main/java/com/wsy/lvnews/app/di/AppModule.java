package com.wsy.lvnews.app.di;

import com.wsy.lvnews.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 王少岩 on 2017/2/24.
 */
@Module
public class AppModule {
    private App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return mApp;
    }
}
