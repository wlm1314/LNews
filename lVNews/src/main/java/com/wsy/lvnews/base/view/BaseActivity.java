package com.wsy.lvnews.base.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wsy.lvnews.app.App;
import com.wsy.lvnews.app.di.AppComponent;
import com.wsy.lvnews.base.di.ActivityComponent;
import com.wsy.lvnews.base.di.ActivityModule;
import com.wsy.lvnews.base.di.DaggerActivityComponent;

/**
 * Created by 王少岩 on 2017/2/24.
 */

public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {
    protected B mBinding;
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build();
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        initView();
    }

    protected AppComponent getAppComponent(){
        return ((App)getApplication()).getAppComponent();
    }

    protected ActivityComponent getActivityComponent(){
        return mActivityComponent;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
