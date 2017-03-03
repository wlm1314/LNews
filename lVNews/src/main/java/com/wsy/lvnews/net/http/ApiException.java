package com.wsy.lvnews.net.http;


import com.wsy.lvnews.utils.Utils;

/**
 * Created by 王少岩 on 2017/2/5.
 */

public class ApiException extends RuntimeException {

    public ApiException(int code, String msg) {
        super(msg);
        Utils.showToast(msg);
    }

}