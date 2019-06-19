package jni.text.zhzl.com.netizensservices.common.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jni.text.zhzl.com.netizensservices.R;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class AddressAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AddressAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.address, item);

    }
}