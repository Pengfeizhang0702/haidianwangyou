package jni.text.zhzl.com.netizensservices.mine.presenter;

import android.content.Intent;
import android.widget.TextView;

import jni.text.zhzl.com.netizensservices.mine.RealNameActivity;
import jni.text.zhzl.com.netizensservices.mine.setting.SettingActivity;
import jni.text.zhzl.com.netizensservices.mvp.FragmentPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPActivity;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class MinePresenter extends FragmentPresenter<MinePresenter.MineUI> {
    public interface MineUI extends GEMUI {
        TextView getRealView();

        TextView getSettingView();
    }

    @Override
    public void onUIReady(MVPActivity activity, MineUI ui) {
        super.onUIReady(activity, ui);
    }


    /**
     * 实名认证
     */
    public void RealName() {

        Intent intent = new Intent(getActivity(), RealNameActivity.class);
        getActivity().startActivity(intent);

    }

    public void Setting() {
        Intent intent = new Intent(getActivity(), SettingActivity.class);
        getActivity().startActivity(intent);


    }

}
