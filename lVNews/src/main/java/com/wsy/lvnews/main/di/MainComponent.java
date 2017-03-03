package com.wsy.lvnews.main.di;

import com.wsy.lvnews.app.di.AppComponent;
import com.wsy.lvnews.base.di.ActivityComponent;
import com.wsy.lvnews.base.di.ActivityScope;
import com.wsy.lvnews.main.view.MainActivity;

import dagger.Component;

/**
 * 王少岩 在 2017/3/1 创建了它
 */
@ActivityScope
@Component(dependencies = {AppComponent.class, ActivityComponent.class}, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);

    NewsComponent newsComponent(NewsModule module);
}
