package com.wsy.lvnews.main.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.app.Fragment;
import android.view.animation.OvershootInterpolator;

import com.wsy.lvnews.R;
import com.wsy.lvnews.base.view.BaseActivity;
import com.wsy.lvnews.common.viewmodel.AppBar;
import com.wsy.lvnews.common.viewpager.MyFragmentPagerAdapter;
import com.wsy.lvnews.databinding.ActivityMainBinding;
import com.wsy.lvnews.main.di.DaggerMainComponent;
import com.wsy.lvnews.main.di.MainComponent;
import com.wsy.lvnews.main.di.MainModule;
import com.wsy.lvnews.utils.NavBarUtils;
import com.wsy.lvnews.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * 王少岩 在 2017/2/28 创建了它
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final int ANIM_DURATION_TOOLBAR = 300;
    private static final int ANIM_DURATION_FAB = 1000;
    private static final int ANIM_DURATION_CONTENT = 300;
    @Inject
    AppBar mAppBar;
    MainComponent mMainComponent;
    List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mMainComponent = DaggerMainComponent.builder().activityComponent(getActivityComponent()).appComponent(getAppComponent()).mainModule(new MainModule(mBinding)).build();
        mMainComponent.inject(this);
        mBinding.setAppbar(mAppBar);
        List<String> list = new ArrayList<>();
        list.add("社会");
        list.add("国内");
        list.add("国际");
        list.add("娱乐");
        list.add("体育");
        list.add("NBA");
        list.add("足球");
        list.add("科技");
        list.add("创新");
        Observable.from(list).subscribe(s -> mFragments.add(NewsFragment.newsInstance(s)));
        mBinding.viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), list, mFragments));
        NavBarUtils.setTabs(this, mBinding.magicIndicator, list, mBinding.viewPager);
        startIntroAnimation();

        mBinding.navView.setNavigationItemSelectedListener(item -> {
            return true;
        });
    }

    private void startIntroAnimation() {
        mBinding.fab.setTranslationY(2 * getResources().getDimensionPixelOffset(R.dimen.dimen_50));
        int actionbarSize = Utils.dpToPx(56);
        mBinding.layoutAppbar.toolbar.setTranslationY(-actionbarSize);
        mBinding.layoutFragment.setTranslationY(Utils.getScreenHeight(this));
        mBinding.layoutAppbar.toolbar.animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        startContentAnimation();
                    }
                });
    }

    private void startContentAnimation() {
        mBinding.fab.animate()
                .translationY(0)
                .setInterpolator(new OvershootInterpolator(1.f))
                .setStartDelay(300)
                .setDuration(ANIM_DURATION_FAB)
                .start();
        mBinding.layoutFragment.animate()
                .translationY(0)
                .setStartDelay(300)
                .setDuration(ANIM_DURATION_CONTENT)
                .start();
    }

    public MainComponent getMainComponent() {
        return mMainComponent;
    }
}
