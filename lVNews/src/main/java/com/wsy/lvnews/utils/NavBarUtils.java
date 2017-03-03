package com.wsy.lvnews.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import com.magicindicator.MagicIndicator;
import com.magicindicator.ViewPagerHelper;
import com.magicindicator.buildins.circlenavigator.ScaleCircleNavigator;
import com.magicindicator.buildins.commonnavigator.CommonNavigator;
import com.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import com.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import com.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import com.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import com.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import com.wsy.lvnews.R;

import java.util.List;


/**
 * Created by 王少岩 on 2016/12/6.
 */

public class NavBarUtils {

    //tab导航栏
    public static void setTabs(Context context, MagicIndicator indicator, final List<String> tabTitles, final ViewPager viewPager, int resId) {
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(false);  // 自适应模式
        commonNavigator.setSkimOver(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return tabTitles == null ? 0 : tabTitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(context.getResources().getColor(R.color.text_normal));
                colorTransitionPagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(resId));
                colorTransitionPagerTitleView.setSelectedColor(context.getResources().getColor(R.color.blue_primary_dark));
                colorTransitionPagerTitleView.setText(tabTitles.get(index));
                colorTransitionPagerTitleView.setOnClickListener(view -> viewPager.setCurrentItem(index));
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setColors(context.getResources().getColor(R.color.blue_primary_dark));
                return indicator;
            }
        });
        indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(indicator, viewPager);
    }

    public static void setTabs(Context context, MagicIndicator indicator, final List<String> tabTitles, final ViewPager viewPager) {
        setTabs(context, indicator, tabTitles, viewPager, R.dimen.text_size_14);
    }

    public static void setCircleIndicator(Context context, MagicIndicator indicator, int count, ViewPager viewPager) {
        ScaleCircleNavigator circleNavigator = new ScaleCircleNavigator(context);
        circleNavigator.setCircleCount(count);
        circleNavigator.setNormalCircleColor(context.getResources().getColor(R.color.white));
        circleNavigator.setSelectedCircleColor(context.getResources().getColor(R.color.blue_primary));
        circleNavigator.setMaxRadius(10);
        circleNavigator.setMinRadius(8);
        circleNavigator.setCircleClickListener(index -> viewPager.setCurrentItem(index));
        indicator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(indicator, viewPager);

    }
}
