package jni.text.zhzl.com.netizensservices.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mine.presenter.RealNamePresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

public class RealNameActivity extends BaseActivity<RealNamePresenter.RealNameUI, RealNamePresenter> implements RealNamePresenter.RealNameUI {


    @Override
    protected RealNamePresenter.RealNameUI createUI() {
        return this;
    }

    @Override
    protected RealNamePresenter createPresenter() {
        return new RealNamePresenter();
    }

    @Override
    protected void initViews() {

        RxView.clicks(getRealView()).throttleFirst(500, TimeUnit.MICROSECONDS).subscribe(o -> {
            getPresenter().RealName();

        });

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_real_name;
    }

    @Override
    public TextView getRealView() {
        return getUI().finder().find(R.id.real_name_submit);
    }

    @Override
    public EditText getNameView() {
        return getUI().finder().find(R.id.real_name_name);
    }

    @Override
    public EditText getCodeView() {
        return getUI().finder().find(R.id.real_name_code);

    }
}
