package jni.text.zhzl.com.netizensservices.mvp;



/**
 * MVP - View interface
 * <p>
 * Created by zpf on 2017/7/22.
 */

public interface GEMUI {

    boolean isAlive();

    /**
     * whether is resumed or visible to user
     *
     * @return
     */
    boolean isActive();


    /**
     * Return activity_details_rc_top resource for activity or fragment
     *
     * @return
     */
    int getContentLayout();

    /**
     * Provide a viewfinder to simplify find a View in Res
     *
     * @return
     */
    ViewFinder finder();

    /**
     * 展示加载动画
     */
    void showProgress();

    /**
     * 关闭加载动画
     */
    void dismissProgress();


    void showAlertinfo(String status, String content);




}
