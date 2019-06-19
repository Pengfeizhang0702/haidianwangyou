package jni.text.zhzl.com.netizensservices.home.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.bean.HomeOneBean;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class HomeCityAdapter extends BaseQuickAdapter<HomeOneBean, BaseViewHolder> {
    public HomeCityAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeOneBean item) {

        helper.setText(R.id.item_home_tv,item.getTitle());

    }
}