package jni.text.zhzl.com.netizensservices.mine;

import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mine.presenter.MinePresenter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseFragment;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class MineFragment extends BaseFragment<MinePresenter.MineUI, MinePresenter> implements MinePresenter.MineUI {


    @Override
    protected void initViews() {

        //实名认证
        RxView.clicks(getRealView()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().RealName();
                });
        //实名认证
        RxView.clicks(getSettingView()).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getPresenter().Setting();
                });

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    protected MinePresenter.MineUI createUI() {
        return this;
    }

    @Override
    public TextView getRealView() {
        return getUI().finder().find(R.id.mine_real_name);
    }

    @Override
    public TextView getSettingView() {
        return getUI().finder().find(R.id.mine_setting);
    }
}
