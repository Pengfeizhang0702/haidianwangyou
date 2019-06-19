package jni.text.zhzl.com.netizensservices.user;

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
public class RegisterPresenter extends ActPresenter<RegisterPresenter.RegisterUI> {

    public interface RegisterUI extends GEMUI {

        EditText getphoneview();

        TextView getSendview();

        EditText getCodeview();

        TextView getRegisterview();


    }


    public void SendCode() {
        CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                yanFlag = true;
                getUI().getSendview().setText("(" + millisUntilFinished / 1000 + "秒)重新获取");
            }

            @Override
            public void onFinish() {
//                yanFlag = false;
                getUI().getSendview().setText("获取验证码");
            }
        }.start();
    }


    public void Register() {

        String phone = getUI().getphoneview().getText().toString().trim();
        String code = getUI().getCodeview().getText().toString().trim();

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(code)) {
            ToastUtil.showToastMsg("检查手机号和验证码");
            return;
        }


    }


}
