package jni.text.zhzl.com.netizensservices.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.baidu.mapapi.map.MapView;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.common.presenter.ChoicePositionPresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

/**
 * 全局需要更改地址的页面
 */
public class ChoicePositionActivity extends BaseActivity<ChoicePositionPresenter.ChoicePositionUI, ChoicePositionPresenter> implements ChoicePositionPresenter.ChoicePositionUI {


    @Override
    protected ChoicePositionPresenter.ChoicePositionUI createUI() {
        return this;
    }

    @Override
    protected ChoicePositionPresenter createPresenter() {
        return new ChoicePositionPresenter();
    }

    @Override
    protected void initViews() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_choice_position;
    }

    @Override
    public MapView getmapview() {
        return getUI().finder().find(R.id.mapview);
    }

    @Override
    public RecyclerView getRecyclerview() {
        return getUI().finder().find(R.id.recyclerview);
    }
}
