package jni.text.zhzl.com.netizensservices.mine.setting;

import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPActivity;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class FeedBackPresenter extends ActPresenter<FeedBackPresenter.FeedBackUI> implements BGASortableNinePhotoLayout.Delegate {
    private static final int RC_PHOTO_PREVIEW = 2;
    private static final int RC_CHOOSE_PHOTO = 1;
    public interface FeedBackUI extends GEMUI{
        BGASortableNinePhotoLayout getphotolayout();

        List<String> getimglist();

        EditText getcontent();

    }

    @Override
    public void onUIReady(MVPActivity activity, FeedBackUI ui) {
        super.onUIReady(activity, ui);
        getUI().getphotolayout().setMaxItemCount(4);
        getUI().getphotolayout().setPlusEnable(true);
        getUI().getphotolayout().setDelegate(this);
    }





    @Override
    public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
        choicePhotoWrapper();
    }


    @Override
    public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        getUI().getphotolayout().removeItem(position);
    }

    @Override
    public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(getActivity())
                .previewPhotos(models) // 当前预览的图片路径集合
                .selectedPhotos(models) // 当前已选中的图片路径集合
                .maxChooseCount(getUI().getphotolayout().getMaxItemCount()) // 图片选择张数的最大值
                .currentPosition(position) // 当前预览图片的索引
                .isFromTakePhoto(false) // 是否是拍完照后跳转过来
                .build();
        getActivity().startActivityForResult(photoPickerPreviewIntent, RC_PHOTO_PREVIEW);
    }

    @Override
    public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
//        Toast.makeText(getActivity(), "排序发生变化", Toast.LENGTH_SHORT).show();
    }


    private void choicePhotoWrapper() {
        // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话就没有拍照功能
        File takePhotoDir = new File(Environment.getExternalStorageDirectory(), "haidianwangyou");

        Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(getActivity())
                .cameraFileDir(takePhotoDir) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                .maxChooseCount(getUI().getphotolayout().getMaxItemCount() - getUI().getphotolayout().getItemCount()) // 图片选择张数的最大值
                .selectedPhotos(null) // 当前已选中的图片路径集合
                .pauseOnScroll(false) // 滚动列表时是否暂停加载图片
                .build();
        getActivity().startActivityForResult(photoPickerIntent, RC_CHOOSE_PHOTO);

    }









}
