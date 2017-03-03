package com.wsy.lvnews.app.di;

import com.wsy.lvnews.app.App;
import com.wsy.lvnews.net.http.RequestApi;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by 王少岩 on 2017/2/24.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    App getApp();
    Retrofit getRetrofit();
    RequestApi getRequestApi();
}
