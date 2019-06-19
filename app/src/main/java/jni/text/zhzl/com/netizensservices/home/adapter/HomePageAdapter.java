package jni.text.zhzl.com.netizensservices.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class HomePageAdapter extends PagerAdapter {


    private List<String> list;
    private List<View> views;

    public HomePageAdapter(List<String> list, List<View> views) {
        this.list = list;
        this.views = views;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(views.get(arg1));
        return views.get(arg1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
