package com.wsy.lvnews.app.di;

import com.wsy.lvnews.BuildConfig;
import com.wsy.lvnews.net.http.HttpPath;
import com.wsy.lvnews.net.http.BaseInterceptor;
import com.wsy.lvnews.net.http.LoggerInterceptor;
import com.wsy.lvnews.net.http.RequestApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 王少岩 在 2017/3/1 创建了它
 */
@Module
public class ApiModule {
    private static final int DEFAULT_TIMEOUT = 10;

    @Provides
    @Singleton
    public Retrofit privideRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new BaseInterceptor());
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            //新建log拦截器
            builder.addInterceptor(new LoggerInterceptor());
        }

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(HttpPath.SERVER)
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    public RequestApi provideApi(Retrofit retrofit){
        return retrofit.create(RequestApi.class);
    }
}
