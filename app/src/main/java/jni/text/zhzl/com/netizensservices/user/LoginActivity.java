package jni.text.zhzl.com.netizensservices.user;

import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter.LoginUI, LoginPresenter> implements LoginPresenter.LoginUI {


    @Override
    protected LoginPresenter.LoginUI createUI() {
        return this;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @SuppressWarnings("all")
    @Override
    protected void initViews() {

        RxView.clicks(getUI().getLoginview()).throttleFirst(500, TimeUnit.MICROSECONDS).subscribe(o -> {

            getPresenter().Login();

        });

        RxView.clicks(getUI().getRigsterview()).throttleFirst(500, TimeUnit.MICROSECONDS).subscribe(o -> {
            getPresenter().Register();
        });


    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public EditText getEduserview() {
        return getUI().finder().find(R.id.login_user);

    }

    @Override
    public EditText getEdpwdview() {
        return getUI().finder().find(R.id.login_pwd);

    }

    @Override
    public TextView getLoginview() {
        return getUI().finder().find(R.id.login_btn);

    }

    @Override
    public TextView getRigsterview() {
        return getUI().finder().find(R.id.login_register);

    }
}
