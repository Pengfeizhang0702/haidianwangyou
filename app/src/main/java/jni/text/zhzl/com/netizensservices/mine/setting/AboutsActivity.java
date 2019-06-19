package jni.text.zhzl.com.netizensservices.mine.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mine.setting.presenter.AboutsPresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

public class AboutsActivity extends BaseActivity<AboutsPresenter.AboutsUI, AboutsPresenter> implements AboutsPresenter.AboutsUI {


    @Override
    protected AboutsPresenter.AboutsUI createUI() {
        return this;
    }

    @Override
    protected AboutsPresenter createPresenter() {
        return new AboutsPresenter();
    }

    @Override
    protected void initViews() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_abouts;
    }
}
