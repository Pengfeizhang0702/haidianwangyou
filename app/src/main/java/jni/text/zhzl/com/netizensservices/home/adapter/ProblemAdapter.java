package jni.text.zhzl.com.netizensservices.home.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.bean.Problem;
import jni.text.zhzl.com.netizensservices.utils.DebugLog;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class ProblemAdapter extends BaseQuickAdapter<Problem, BaseViewHolder> {
    public ProblemAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Problem item) {

        helper.getView(R.id.user_img).setVisibility(View.GONE);
        helper.getView(R.id.item_user_content_wenzi).setVisibility(View.GONE);
        helper.getView(R.id.user_content_img).setVisibility(View.GONE);
        helper.getView(R.id.item_user_voice_tv).setVisibility(View.GONE);


        helper.getView(R.id.stem_user_img).setVisibility(View.GONE);
        helper.getView(R.id.item_user_content).setVisibility(View.GONE);
        helper.getView(R.id.item_user_content_img).setVisibility(View.GONE);


        helper.addOnClickListener(R.id.item_user_voice_tv);
        helper.addOnClickListener(R.id.user_content_img);





        int usertype = item.getUsertype();

        if (usertype == 0) {
            helper.getView(R.id.user_img).setVisibility(View.VISIBLE);
            Glide.with(mContext).load(item.getUserimg()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.user_img));
            //用户
            //判断内容类型
            int contenttype = item.getContenttype();
            if (contenttype == 0) {
//  文字
                helper.getView(R.id.item_user_content_wenzi).setVisibility(View.VISIBLE);
                helper.setText(R.id.item_user_content_wenzi, item.getContenstr());
            } else if (contenttype == 1) {
                //图片
                helper.getView(R.id.user_content_img).setVisibility(View.VISIBLE);
                Glide.with(mContext).load(item.getContentimg()).into((ImageView) helper.getView(R.id.user_content_img));
            } else if (contenttype == 2) {
                //语音
                DebugLog.d("==================zhix asasasasasa" + item.getTime());

                helper.getView(R.id.item_user_voice_tv).setVisibility(View.VISIBLE);
                helper.setText(R.id.item_user_voice_tv, item.getTime() + "''");


            } else if (contenttype == 3) {
                //图片
                helper.getView(R.id.user_content_img).setVisibility(View.VISIBLE);
                Glide.with(mContext).load(item.getContentimg()).into((ImageView) helper.getView(R.id.user_content_img));
            }


        } else {


            //展示系统头像
            helper.getView(R.id.stem_user_img).setVisibility(View.VISIBLE);
            Glide.with(mContext).load(item.getUserimg()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.stem_user_img));
//            系统
            //判断内容类型
            int contenttype = item.getContenttype();

            if (contenttype == 0) {
                helper.getView(R.id.item_user_content).setVisibility(View.VISIBLE);
                helper.setText(R.id.item_user_content, item.getContenstr());
            } else {


            }


        }


    }
}
