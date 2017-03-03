package com.wsy.lvnews.net.http;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王少岩 on 2016/9/14.
 */
public class HttpParams {

    //获取社会新闻
    public static Map<String, String> getNews(String page) {
        Map<String, String> params = new HashMap<>();
        params.put("num", "10");
        params.put("page", page);
        return params;
    }

}
