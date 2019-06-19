package jni.text.zhzl.com.netizensservices.mvp.base;

import android.os.Bundle;

import jni.text.zhzl.com.netizensservices.mvp.FragmentPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPFragment;
import jni.text.zhzl.com.netizensservices.mvp.ViewFinder;


/**
 * Created by zpf on 2017/7/22.
 */

/**
 * Fragment的base基类
 *
 * @param <V>
 * @param <P>
 */
public abstract class BaseFragment<V extends GEMUI, P extends FragmentPresenter<V>> extends MVPFragment<V, P>
        implements GEMUI {
    private ViewFinder finder;
    private P presenter;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        finder = new ViewFinder(getActivity());
        initViews();
        presenter = createPresenter();
        presenter.onActivityCreated(savedInstanceState);
    }


    protected abstract void initViews();

    @Override
    public ViewFinder finder() {
        return finder;
    }

    @Override
    public void showProgress() {

//
//        if (dialog == null) {
//
//            dialog = new ShapeLoadingDialog.Builder(getActivity())
//                    .loadText("加载中...")
//                    .build();
//            dialog.setCanceledOnTouchOutside(false);
////            dialog.setCancelable(false);
//
//        }
//        dialog.show();
//        if (getActivity() instanceof BaseActivity)
//            ((BaseActivity) getActivity()).showProgress(title, content);
    }

    @Override
    public void dismissProgress() {
//        if (dialog != null) {
//            dialog.dismiss();
//        }
//        dialog = null;
//        if (getActivity() instanceof BaseActivity)
//            ((BaseActivity) getActivity()).dismissProgress();
    }


    /**
     * 展示提示信息
     */
    @Override
    public void showAlertinfo(String status, String content) {
//        if (alertDialogView == null) {
//            alertDialogView = new AlertDialogView(getActivity());
//        }
//        alertDialogView.alertHitInfo(status, content);


    }


}