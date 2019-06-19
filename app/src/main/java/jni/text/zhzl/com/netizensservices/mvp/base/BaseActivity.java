package jni.text.zhzl.com.netizensservices.mvp.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;


import java.util.List;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPActivity;
import jni.text.zhzl.com.netizensservices.mvp.ViewFinder;

//import com.bugtags.library.Bugtags;


/**
 * Activity的base基类
 *
 * @param <V>
 * @param <P>
 */

public abstract class BaseActivity<V extends GEMUI, P extends ActPresenter<V>> extends MVPActivity<V, P> implements GEMUI {
    private ViewFinder finder;


    @Override
    public void hideStatus() {
        if (finder == null) {
            //此处做判空处理
            finder = new ViewFinder(this);
        }
        if (finder.find(R.id.item_head) != null) {
            finder.find(R.id.item_head).setVisibility(View.GONE);
        }
    }


    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = res.getConfiguration();
        config.fontScale = 1;
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }


    @Override
    public ViewFinder finder() {
        if (finder == null) {


            finder = new ViewFinder(this);
        }
        return finder;
    }

    @Override
    public void showProgress() {
//        if (dialog == null) {
//
//            dialog = new ShapeLoadingDialog.Builder(this)
//                    .loadText("加载中...")
//                    .build();
//            dialog.setCanceledOnTouchOutside(false);
////            dialog.setCancelable(false);
//        }
//        dialog.show();
    }

    @Override
    public void dismissProgress() {
//        if (dialog != null) {
//            dialog.dismiss();
//        }
//        dialog = null;
    }


    /**
     * 展示提示信息   sttus 空 默认显示   1 展示拨打电话
     */
    @Override
    public void showAlertinfo(String status, String content) {
//        if (alertDialogView == null) {
//            alertDialogView = new AlertDialogView(this);
//
//        }
//
//        if (status.equals(Constant.SIX)) {
//            //展示拨打电话
//            alertDialogView.alertPhoneInfo("", content);
//
//
//        } else if (status.equals(Constant.ONE)) {
//
//            alertDialogView.alertHitInfo(status, content);
//
//        } else {
//            alertDialogView.alertHitInfo(status, content);
//
//        }


    }


    //    @Override
//    public Resources getResources() {
//        Resources resources = super.getResources();
//        Configuration configuration = resources.getConfiguration();
//        configuration.fontScale = 1.5f;
//        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
//
//        return resources;
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        if(TextUtils.isEmpty(AuthController.SingleTon.getInstance().getAuth())) {
//            AuthController.SingleTon.getInstance().getAuthInfoN(this);
//        }
//        if (!BuildConfig.DEBUG){
//            MobclickAgent.onResume(this);
//        }else{
//            Bugtags.onResume(this);
//        }
//        Bugtags.onResume(this);

    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        getPresenter().onActivityResult(requestCode, resultCode, data);
//        FragmentManager fm = getSupportFragmentManager();
//
//        Fragment frag = fm.findFragmentByTag(RedPacketFragment.class.getName());
//        if (frag == null) {
//        } else {
//            handleResult(frag, requestCode, resultCode, data);
//        }
//        return;
//    }

    /**
     * 递归调用，对所有子Fragement生效
     *
     * @param frag
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode & 0xffff, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (!BuildConfig.DEBUG){
//            MobclickAgent.onPause(this);
//        }else{
//            Bugtags.onPause(this);
//        }
//        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //注：回调 3
//        Bugtags.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
    }

    /**
     * 请求权限
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

//        switch (requestCode) {
//            case Constant.REQ_CODE_PERMISSION: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED&&permissions[0].equals(Manifest.permission.CAMERA)) {
//                    EventBus.getDefault().post(new ScanEvent());
//                }
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED&&permissions[0].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    EventBus.getDefault().post(new MassiteEvent());
//                }
//                return;
//            }
//        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ToastUtil.cancelToast();
//        PopupController.SingleTon.getInstance().wipe();
//        DialogController.SingleTon.getInstance().wipe();
    }

}
