package jni.text.zhzl.com.netizensservices.utils;

import android.widget.Toast;


import jni.text.zhzl.com.netizensservices.MyApplication;

public class ToastUtil {


    public static void toastLong(int msgRes) {
        //toastLong(GEMApplication.Companion.get_instane().getString(msgRes));
        showToast(msgRes);
    }

    public static void toastLong(String msg) {
        //  Toast.makeText(GEMApplication.Companion.get_instane(), msg, Toast.LENGTH_SHORT).show();
        showToastMsg(msg);
    }

    public static Toast mToast = null;

    public static void showToast(int msgRes) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), MyApplication.getInstance().getString(msgRes), Toast.LENGTH_SHORT);
        } else {
            mToast.setText(MyApplication.getInstance().getString(msgRes));
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showToastMsg(String msgRes) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), msgRes, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msgRes);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 关闭Toast
     */
    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }


    /**
     * 自定义Toast
     */
    public void costomtoast() {
        if (mToast == null) {
            mToast = new Toast(MyApplication.getInstance());
        }


    }


}

