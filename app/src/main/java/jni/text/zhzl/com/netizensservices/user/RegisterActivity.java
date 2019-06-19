package jni.text.zhzl.com.netizensservices.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

public class RegisterActivity extends BaseActivity<RegisterPresenter.RegisterUI, RegisterPresenter> implements RegisterPresenter.RegisterUI {


    @Override
    protected RegisterPresenter.RegisterUI createUI() {
        return this;
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initViews() {


        RxView.clicks(getSendview()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().SendCode();

                });

        RxView.clicks(getUI().getRegisterview()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {

                       getPresenter().Register();

                });


    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_register;
    }

    @Override
    public EditText getphoneview() {
        return getUI().finder().find(R.id.register_phone);
    }

    @Override
    public TextView getSendview() {
        return getUI().finder().find(R.id.register_send_code);
    }

    @Override
    public EditText getCodeview() {
        return getUI().finder().find(R.id.register_code);
    }

    @Override
    public TextView getRegisterview() {
        return getUI().finder().find(R.id.register_register);
    }
}
