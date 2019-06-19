package jni.text.zhzl.com.netizensservices.mine.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mine.setting.presenter.SettingPresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

public class SettingActivity extends BaseActivity<SettingPresenter.SettingUI, SettingPresenter> implements SettingPresenter.SettingUI {


    @Override
    protected SettingPresenter.SettingUI createUI() {
        return this;
    }

    @Override
    protected SettingPresenter createPresenter() {
        return new SettingPresenter();
    }

    @SuppressWarnings("all")
    @Override
    protected void initViews() {

        RxView.clicks(getedotpwdview()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().setEditpwd();

                });

        RxView.clicks(getFeedbackview()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().setFeedback();


                });
        RxView.clicks(getClearView()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {

                    getPresenter().setClear();

                });
        RxView.clicks(getAboutsView()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().setAbouts();


                });


    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public TextView getedotpwdview() {
        return getUI().finder().find(R.id.setting_edit_pwd);
    }

    @Override
    public TextView getFeedbackview() {
        return getUI().finder().find(R.id.setting_feedback);

    }

    @Override
    public TextView getClearView() {
        return getUI().finder().find(R.id.setting_clear);

    }

    @Override
    public TextView getAboutsView() {
        return getUI().finder().find(R.id.setting_abouts);

    }
}
