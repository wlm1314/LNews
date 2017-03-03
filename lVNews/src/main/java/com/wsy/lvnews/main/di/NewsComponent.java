package com.wsy.lvnews.main.di;

import com.wsy.lvnews.base.di.ActivityScope;
import com.wsy.lvnews.main.view.NewsFragment;

import dagger.Subcomponent;

/**
 * 王少岩 在 2017/3/2 创建了它
 */
@ActivityScope
@Subcomponent(modules = NewsModule.class)
public interface NewsComponent {
    void inject(NewsFragment fragment);
}
