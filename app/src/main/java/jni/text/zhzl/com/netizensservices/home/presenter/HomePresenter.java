package jni.text.zhzl.com.netizensservices.home.presenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.Constants;
import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.bean.HomeOneBean;
import jni.text.zhzl.com.netizensservices.home.ProblemListActivity;
import jni.text.zhzl.com.netizensservices.home.adapter.HomeCityAdapter;
import jni.text.zhzl.com.netizensservices.home.adapter.HomePageAdapter;
import jni.text.zhzl.com.netizensservices.mvp.FragmentPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPActivity;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class HomePresenter extends FragmentPresenter<HomePresenter.HomeUI> {

    public interface HomeUI extends GEMUI {

        ViewPager getvp();
        TabLayout getHometab();

    }


    private List<View> views = new ArrayList<>();
    private List<String> titlelist = new ArrayList<>();

    private RecyclerView recyclerView;


    @Override
    public void onUIReady(MVPActivity activity, HomeUI ui) {
        super.onUIReady(activity, ui);


    }

    @Override
    public void onResume() {
        super.onResume();
        titlelist.clear();
        views.clear();
        initView();

    }

    private void initView() {

        View city_goven = LayoutInflater.from(getActivity()).inflate(R.layout.vp_view_one, null);
        View society = LayoutInflater.from(getActivity()).inflate(R.layout.vp_view_two, null);
        recyclerView = city_goven.findViewById(R.id.home_view_one_rv);
        initHomeOneData();
        views.add(city_goven);
        views.add(society);
        titlelist.add("城市治理");
        titlelist.add("社会治安");
        getUI().getvp().setAdapter(new HomePageAdapter(titlelist, views));
        getUI().getHometab().setupWithViewPager(getUI().getvp());
    }

    private void initHomeOneData() {

        List<HomeOneBean> list = new ArrayList<>();
        list.add(new HomeOneBean("乱停乱放", R.mipmap.camera, 1));
        list.add(new HomeOneBean("污染环境", R.mipmap.camera, 1));
        list.add(new HomeOneBean("占道经营", R.mipmap.camera, 1));
        list.add(new HomeOneBean("乱贴乱发", R.mipmap.camera, 1));
        list.add(new HomeOneBean("污水排放", R.mipmap.camera, 1));
        list.add(new HomeOneBean("噪音扰民", R.mipmap.camera, 1));
        list.add(new HomeOneBean("设施损坏", R.mipmap.camera, 1));
        list.add(new HomeOneBean("其他", R.mipmap.camera, 1));


        HomeCityAdapter adapter = new HomeCityAdapter(R.layout.item_home, list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String title = list.get(position).getTitle();

                Intent intent = new Intent(getActivity(), ProblemListActivity.class);
                intent.putExtra(Constants.TITLT, title);
                getActivity().startActivity(intent);


            }
        });


    }


}
