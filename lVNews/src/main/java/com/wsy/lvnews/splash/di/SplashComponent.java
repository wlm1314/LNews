package com.wsy.lvnews.splash.di;

import com.wsy.lvnews.base.di.ActivityComponent;
import com.wsy.lvnews.base.di.ActivityScope;
import com.wsy.lvnews.splash.view.SplashActivity;

import dagger.Component;

/**
 * Created by 王少岩 on 2017/2/24.
 */
@ActivityScope
@Component(dependencies = ActivityComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}
