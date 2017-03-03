package com.wsy.lvnews.main.di;

import com.wsy.lvnews.base.di.ActivityScope;
import com.wsy.lvnews.main.view.NewsFragment;
import com.wsy.lvnews.main.viewmodel.NewsViewModel;
import com.wsy.lvnews.net.http.RequestApi;

import dagger.Module;
import dagger.Provides;

/**
 * 王少岩 在 2017/3/2 创建了它
 */
@Module
public class NewsModule {

    private NewsFragment fragment;

    public NewsModule(NewsFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ActivityScope
    public NewsViewModel provideViewModel(RequestApi requestApi) {
        return new NewsViewModel(fragment, requestApi);
    }
}
