package jni.text.zhzl.com.netizensservices.mine.presenter;

import android.content.Intent;
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
public class RealNamePresenter extends ActPresenter<RealNamePresenter.RealNameUI> {

    public interface RealNameUI extends GEMUI {
        TextView getRealView();

        EditText getNameView();

        EditText getCodeView();

    }


    public void RealName() {

        String name = getUI().getNameView().getText().toString().trim();
        String code = getUI().getCodeView().getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(code)) {
            ToastUtil.showToastMsg("姓名和身份证号码不能为空");
            return;
        }


    }

}
