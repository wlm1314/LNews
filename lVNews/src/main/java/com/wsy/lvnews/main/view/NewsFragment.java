package com.wsy.lvnews.main.view;

import android.os.Bundle;

import com.wsy.lvnews.R;
import com.wsy.lvnews.base.view.BaseFragment;
import com.wsy.lvnews.databinding.FragmentMainBinding;
import com.wsy.lvnews.main.di.NewsModule;
import com.wsy.lvnews.main.viewmodel.NewsViewModel;

import javax.inject.Inject;

/**
 * 王少岩 在 2017/3/2 创建了它
 */

public class NewsFragment extends BaseFragment<FragmentMainBinding> {

    private boolean isVisible, isPrepared;

    @Inject
    NewsViewModel mViewModel;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = getUserVisibleHint();
        if (isVisibleToUser)
            lazyLoadData();

    }

    public static NewsFragment newsInstance(String title) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        ((MainActivity) getActivity()).getMainComponent().newsComponent(new NewsModule(this)).inject(this);
        mBinding.setViewModel(mViewModel);
        isPrepared = true;
        lazyLoadData();
    }

    private void lazyLoadData() {
        if (!isVisible || !isPrepared)
            return;
        mViewModel.getData();
    }
}
