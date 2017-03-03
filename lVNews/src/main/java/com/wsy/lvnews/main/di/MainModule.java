package com.wsy.lvnews.main.di;

import android.support.v4.view.GravityCompat;

import com.binding.command.ReplyCommand;
import com.wsy.lvnews.R;
import com.wsy.lvnews.base.di.ActivityScope;
import com.wsy.lvnews.common.viewmodel.AppBar;
import com.wsy.lvnews.databinding.ActivityMainBinding;

import dagger.Module;
import dagger.Provides;

/**
 * 王少岩 在 2017/3/1 创建了它
 */
@Module
public class MainModule {
    private ActivityMainBinding mBinding;

    public MainModule(ActivityMainBinding binding) {
        mBinding = binding;
    }

    @Provides
    @ActivityScope
    public AppBar provideAppbar() {
        return new AppBar("新闻精选", R.mipmap.icon_left, new ReplyCommand(() -> mBinding.drawerLayout.openDrawer(GravityCompat.START)));
    }
}
