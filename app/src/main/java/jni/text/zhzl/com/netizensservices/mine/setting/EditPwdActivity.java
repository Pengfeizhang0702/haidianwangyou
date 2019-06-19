package jni.text.zhzl.com.netizensservices.mine.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mine.setting.presenter.EditPwdPresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

public class EditPwdActivity extends BaseActivity<EditPwdPresenter.EditPwdUI, EditPwdPresenter> implements EditPwdPresenter.EditPwdUI {


    @Override
    protected EditPwdPresenter.EditPwdUI createUI() {
        return this;
    }

    @Override
    protected EditPwdPresenter createPresenter() {
        return new EditPwdPresenter();
    }

    @SuppressWarnings("all")
    @Override
    protected void initViews() {
        RxView.clicks(getSendcodeview()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().SendCode();
                });

        RxView.clicks(getSubmitView()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().SendCode();
                });
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_edit_pwd;
    }

    @Override
    public EditText getphoneView() {
        return getUI().finder().find(R.id.edit_pwd_phone);
    }

    @Override
    public EditText getCodeview() {
        return getUI().finder().find(R.id.edit_pwd_code);

    }

    @Override
    public EditText getNewView() {
        return getUI().finder().find(R.id.edit_pwd_new);

    }

    @Override
    public TextView getSendcodeview() {
        return getUI().finder().find(R.id.edit_pwd_send_code);

    }

    @Override
    public TextView getSubmitView() {
        return getUI().finder().find(R.id.edit_pwd_submit);

    }
}
