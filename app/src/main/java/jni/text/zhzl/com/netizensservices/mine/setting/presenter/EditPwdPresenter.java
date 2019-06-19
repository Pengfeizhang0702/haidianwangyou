package jni.text.zhzl.com.netizensservices.mine.setting.presenter;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.utils.ToastUtil;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class EditPwdPresenter extends ActPresenter<EditPwdPresenter.EditPwdUI> {


    public interface EditPwdUI extends GEMUI {

        EditText getphoneView();

        EditText getCodeview();

        EditText getNewView();

        TextView getSendcodeview();

        TextView getSubmitView();


    }


    public void SendCode() {


        String phone = getUI().getphoneView().getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showToastMsg("手机号不能为空");
            return;
        }


        CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                yanFlag = true;
                getUI().getSendcodeview().setText("(" + millisUntilFinished / 1000 + "秒)重新获取");
            }

            @Override
            public void onFinish() {
//                yanFlag = false;
                getUI().getSendcodeview().setText("获取验证码");
            }
        }.start();
    }


    public void EditPWd() {


        String phone = getUI().getphoneView().getText().toString().trim();

        String code = getUI().getCodeview().getText().toString().trim();
        String newpwd = getUI().getNewView().getText().toString().trim();

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(code) || TextUtils.isEmpty(newpwd)) {
            ToastUtil.showToastMsg("输入不能为空");
            return;

        }


    }


}
