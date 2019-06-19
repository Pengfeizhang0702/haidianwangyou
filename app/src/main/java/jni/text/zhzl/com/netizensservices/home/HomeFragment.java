package jni.text.zhzl.com.netizensservices.home;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.home.presenter.HomePresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseFragment;
import jni.text.zhzl.com.netizensservices.view.Topbar;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class HomeFragment extends BaseFragment<HomePresenter.HomeUI, HomePresenter> implements HomePresenter.HomeUI {


    @Override
    protected void initViews() {
        Topbar topbar = getUI().finder().find(R.id.topbar);
        topbar.setLeftiv();

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected HomePresenter.HomeUI createUI() {
        return this;
    }
//
    @Override
    public ViewPager getvp() {
        return getUI().finder().find(R.id.viewpage);
    }

    @Override
    public TabLayout getHometab() {
        return getUI().finder().find(R.id.home_tab);
    }
}
