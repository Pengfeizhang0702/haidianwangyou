package jni.text.zhzl.com.netizensservices.base;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.base.presneter.MainPresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;
import jni.text.zhzl.com.netizensservices.utils.ToastUtil;

public class MainActivity extends BaseActivity<MainPresenter.MainUI, MainPresenter> implements MainPresenter.MainUI {
    // 标识是否退出
    private static boolean isExit = false;
    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };


    @Override
    protected MainPresenter.MainUI createUI() {
        return this;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initViews() {

    }


    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        exit();
    }


    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtil.toastLong("再按一次退出海淀网友app");
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            System.exit(0);
        }
    }

    @Override
    public RadioGroup gettablayout() {
        return getUI().finder().find(R.id.main_tab);
    }
}
