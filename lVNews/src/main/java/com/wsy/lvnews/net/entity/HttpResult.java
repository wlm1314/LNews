package com.wsy.lvnews.net.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by 王少岩 on 2017/2/5.
 */

public class HttpResult {
    private int code;
    private String msg;
    private List<NewsBean> newslist;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    public List<NewsBean> getData() {
        return newslist;
    }

    public String toString() {
        return toJson(this);
    }

    public static String toJson(HttpResult bean) {
        if (bean != null) {
            return new Gson().toJson(bean);
        }
        return null;
    }

    public static class NewsBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public String getUrl() {
            return url;
        }
    }
}
