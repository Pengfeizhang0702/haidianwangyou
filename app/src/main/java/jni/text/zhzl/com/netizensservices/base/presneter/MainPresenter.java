package jni.text.zhzl.com.netizensservices.base.presneter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.home.HomeFragment;
import jni.text.zhzl.com.netizensservices.mine.MineFragment;
import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPActivity;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class MainPresenter extends ActPresenter<MainPresenter.MainUI> {

    public  interface  MainUI extends GEMUI{
        RadioGroup gettablayout();

    }



    private int checkedId = 0;


    @Override
    public void onUIReady(MVPActivity activity, MainUI ui) {
        super.onUIReady(activity, ui);

        getUI().gettablayout().setOnCheckedChangeListener(
                (group, checkedId) -> {
                    if (checkedId == this.checkedId) {
                        return;
                    }
                    this.checkedId = checkedId;
                    getUI().gettablayout().setVisibility(View.VISIBLE);
                    switch (checkedId) {
                        //首页
                        case R.id.main_home_tab:
                            showFragment(HomeFragment.class, null);
                            break;
                        //场馆
                        case R.id.main_venue_tab:
                            showFragment(HomeFragment.class, null);
                            break;
                        //动态
                        case R.id.main_dynamic_tab:
//                            showFragment(NewsInformationFragment.class, null);
                            showFragment(HomeFragment.class, null);
                            break;
                        //我的
                        case R.id.main_mine_tab:
//                            showFragment(SettingFragment.class, null);
                            showFragment(MineFragment.class, null);
                            break;
                        default:
                            break;
                    }
                });
        getUI().gettablayout().check(R.id.main_home_tab);

    }


    /**
     * Fragement的显示与隐藏
     *
     * @param clazz
     * @param bundle
     */
    public void showFragment(Class clazz, Bundle bundle) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (manager.getFragments() != null) {
            for (Fragment frg : manager.getFragments()) {
                if (frg != null) {
                    transaction.hide(frg);
                }
            }
        }

        Fragment target = getActivity().instanceFragment(clazz.getName(), bundle, clazz.getName());
        if (!target.isAdded())
            transaction.add(R.id.main_container, target, clazz.getName());

        transaction.show(target).commitAllowingStateLoss();
    }









}
