package com.wsy.lvnews.splash.view;

import com.wsy.lvnews.R;
import com.wsy.lvnews.base.view.BaseActivity;
import com.wsy.lvnews.databinding.ActivitySplashBinding;
import com.wsy.lvnews.splash.di.DaggerSplashComponent;
import com.wsy.lvnews.splash.viewmodel.SplashViewModel;

import javax.inject.Inject;

/**
 * 王少岩 在 2017/2/24 创建了它
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {
    @Inject
    SplashViewModel mViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        DaggerSplashComponent.builder().activityComponent(getActivityComponent()).build().inject(this);
        mBinding.setViewModel(mViewModel);
    }
}
