package com.wsy.lvnews.common.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by 王少岩 on 2017/2/8.
 */

public class ItemViewModel<T> {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> des = new ObservableField<>();
    public final ObservableField<String> ctime = new ObservableField<>();
    public final ObservableField<String> picUrl = new ObservableField<>();
    public final ObservableField<String> Url = new ObservableField<>();

    public T data;

    public ItemViewModel(String title, String content, T data) {
        this.title.set(title);
        this.des.set(content);
        this.data = data;
    }
}
