package jni.text.zhzl.com.netizensservices.mine.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;

public class FeedBackActivity extends BaseActivity<FeedBackPresenter.FeedBackUI, FeedBackPresenter> implements FeedBackPresenter.FeedBackUI {


    private List<String> list = new ArrayList<>();
    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;



    @Override
    protected FeedBackPresenter.FeedBackUI createUI() {
        return this;
    }

    @Override
    protected FeedBackPresenter createPresenter() {
        return new FeedBackPresenter();
    }

    @Override
    protected void initViews() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_feed_back;
    }



    @Override
    public BGASortableNinePhotoLayout getphotolayout() {
        return getUI().finder().find(R.id.snpl_moment_add_photos);

    }

    @Override
    public List<String> getimglist() {
        return list;
    }

    @Override
    public EditText getcontent() {
        return getUI().finder().find(R.id.feedback_ed);
    }









    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RC_CHOOSE_PHOTO) {
            list = BGAPhotoPickerActivity.getSelectedPhotos(data);
            getUI().getphotolayout().addMoreData(BGAPhotoPickerActivity.getSelectedPhotos(data));
        } else if (requestCode == RC_PHOTO_PREVIEW) {
            getUI().getphotolayout().setData(BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));
        }
    }




}
