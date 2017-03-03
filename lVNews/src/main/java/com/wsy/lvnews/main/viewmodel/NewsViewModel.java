package com.wsy.lvnews.main.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.binding.command.ReplyCommand;
import com.wsy.lvnews.BR;
import com.wsy.lvnews.R;
import com.wsy.lvnews.main.view.NewsFragment;
import com.wsy.lvnews.net.entity.HttpResult;
import com.wsy.lvnews.net.http.HttpParams;
import com.wsy.lvnews.net.http.HttpRequest;
import com.wsy.lvnews.net.http.RequestApi;
import com.wsy.lvnews.net.subscribers.ProgressSubscriber;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * 王少岩 在 2017/3/1 创建了它
 */

public class NewsViewModel {
    private NewsFragment mNewsFragment;
    private RequestApi mRequestApi;
    private int paageNo = 1;

    public final ObservableField<Boolean> isEmpty = new ObservableField<>();
    public final ObservableField<String> emptyText = new ObservableField<>();

    public final ObservableList<HttpResult.NewsBean> newsViewModel = new ObservableArrayList<>();
    public final ItemView itemView = ItemView.of(BR.data, R.layout.adatper_news_item);

    public final ObservableField<Boolean> refresh = new ObservableField<>();
    public ReplyCommand refreshCommand = new ReplyCommand(()->{
        paageNo = 1;
        refresh.set(true);
        getData();
    });

    public ReplyCommand loadMoreCommand = new ReplyCommand<Integer>(integer -> {
        paageNo++;
        getData();
    });

    public NewsViewModel(NewsFragment fragment, RequestApi requestApi) {
        mNewsFragment = fragment;
        mRequestApi = requestApi;
        isEmpty.set(true);
        refresh.set(false);
        emptyText.set("正在玩命加载中......");
    }

    public void getData() {
        String title = mNewsFragment.getArguments().getString("title");
        switch (title) {
            case "社会":
                mRequestApi.getSocialNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "国内":
                mRequestApi.getGuoNeiNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "国际":
                mRequestApi.getWorldNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "娱乐":
                mRequestApi.getHuaBianNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "体育":
                mRequestApi.getTiYuNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "NBA":
                mRequestApi.getNBANews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "足球":
                mRequestApi.getFootBallNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "科技":
                mRequestApi.getKejiNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
            case "创新":
                mRequestApi.getStartUpNews(HttpParams.getNews(paageNo + ""))
                        .compose(HttpRequest.applySchedulers())
                        .subscribe(new ProgressSubscriber<HttpResult>(mNewsFragment.getActivity()) {
                            @Override
                            public void onNext(HttpResult httpResult) {
                                if (paageNo == 1)
                                    newsViewModel.clear();
                                newsViewModel.addAll(httpResult.getData());
                                isEmpty.set(false);
                                refresh.set(false);
                            }
                        });
                break;
        }
    }
}
