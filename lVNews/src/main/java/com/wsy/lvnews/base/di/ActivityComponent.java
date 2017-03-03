package com.wsy.lvnews.base.di;

import android.app.Activity;

import dagger.Component;

/**
 * Created by 王少岩 on 2017/2/24.
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    Activity Activity();
}
