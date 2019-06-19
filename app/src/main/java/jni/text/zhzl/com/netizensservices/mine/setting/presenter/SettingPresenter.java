package jni.text.zhzl.com.netizensservices.mine.setting.presenter;

import android.content.Intent;
import android.widget.TextView;

import org.w3c.dom.Text;

import jni.text.zhzl.com.netizensservices.mine.setting.AboutsActivity;
import jni.text.zhzl.com.netizensservices.mine.setting.EditPwdActivity;
import jni.text.zhzl.com.netizensservices.mine.setting.FeedBackActivity;
import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.utils.ToastUtil;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class SettingPresenter extends ActPresenter<SettingPresenter.SettingUI> {
    public interface SettingUI extends GEMUI {

        TextView getedotpwdview();

        TextView getFeedbackview();

        TextView getClearView();

        TextView getAboutsView();

    }


    /**
     * 修改密码
     */
    public void setEditpwd() {

        Intent intent = new Intent(getActivity(), EditPwdActivity.class);
        getActivity().startActivity(intent);


    }

    /**
     * 意见反馈
     */
    public void setFeedback() {
        Intent intent = new Intent(getActivity(), FeedBackActivity.class);
        getActivity().startActivity(intent);

    }

    /**
     * 清除缓存
     */
    public void setClear() {

        ToastUtil.showToastMsg("清除缓存成功");

    }

    /**
     * 关于我们
     */
    public void setAbouts() {
        Intent intent = new Intent(getActivity(), AboutsActivity.class);
        getActivity().startActivity(intent);
    }

}
