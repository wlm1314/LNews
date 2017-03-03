package com.wsy.lvnews.common.viewmodel;

import android.databinding.ObservableField;

import com.binding.command.ReplyCommand;
import com.wsy.lvnews.R;

/**
 * Created by 王少岩 on 2016/12/20.
 */

public class AppBar {
    public final ObservableField<Integer> navigation = new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();

    public ReplyCommand naviCommond = new ReplyCommand(() -> {
    });

    public AppBar(String title, int navId, ReplyCommand command) {
        this.title.set(title);
        this.navigation.set(navId);
        this.naviCommond = command;
    }

    public AppBar(String title, boolean showLeft) {
        this.title.set(title);
        navigation.set(showLeft ? R.mipmap.icon_back : 0);
    }
}
