package jni.text.zhzl.com.netizensservices.user;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import jni.text.zhzl.com.netizensservices.base.MainActivity;
import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.utils.ToastUtil;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class LoginPresenter extends ActPresenter<LoginPresenter.LoginUI> {

    public interface LoginUI extends GEMUI {

        EditText getEduserview();

        EditText getEdpwdview();

        TextView getLoginview();

        TextView getRigsterview();

    }


    /**
     * 登录方法
     */
    public void Login() {
        String user = getUI().getEduserview().getText().toString().trim();
        String pwd = getUI().getEdpwdview().getText().toString().trim();
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd)) {
            ToastUtil.showToastMsg("用户名密码不能为空");
            return;
        }
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().startActivity(intent);
        getActivity().finish();
    }


    /**
     * 注册
     */
    public void Register() {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        getActivity().startActivity(intent);


    }


}
