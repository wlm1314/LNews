package com.wsy.lvnews.net.http;

/**
 * Created by 王少岩 on 2016/11/9.
 */

import com.wsy.lvnews.net.entity.HttpResult;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * retrofit 以注解的方式访问接口
 * <p>
 * post请求方式如下
 *
 * @FormUrlEncoded
 * @POST(url) Observable<T> method(@FieldMap Map<String, String> params);
 */
public interface RequestApi {
    @GET(HttpPath.socialNewsUrl)
    Observable<HttpResult> getSocialNews(@QueryMap Map<String, String> params);
    @GET(HttpPath.guoneiNewsUrl)
    Observable<HttpResult> getGuoNeiNews(@QueryMap Map<String, String> params);
    @GET(HttpPath.worldNewsUrl)
    Observable<HttpResult> getWorldNews(@QueryMap Map<String, String> params);
    @GET(HttpPath.huabianNewsUrl)
    Observable<HttpResult> getHuaBianNews(@QueryMap Map<String, String> params);
    @GET(HttpPath.tiyuNewsUrl)
    Observable<HttpResult> getTiYuNews(@QueryMap Map<String, String> params);
    @GET(HttpPath.nbaNewsUrl)
    Observable<HttpResult> getNBANews(@QueryMap Map<String, String> params);
    @GET(HttpPath.footballNewsUrl)
    Observable<HttpResult> getFootBallNews(@QueryMap Map<String, String> params);
    @GET(HttpPath.kejiNewsUrl)
    Observable<HttpResult> getKejiNews(@QueryMap Map<String, String> params);
    @GET(HttpPath.startupNewsUrl)
    Observable<HttpResult> getStartUpNews(@QueryMap Map<String, String> params);

}
