package jni.text.zhzl.com.netizensservices.home;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding2.view.RxView;
import com.zhihu.matisse.Matisse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import jni.text.zhzl.com.netizensservices.Constants;
import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.bean.Problem;
import jni.text.zhzl.com.netizensservices.common.ChoicePositionActivity;
import jni.text.zhzl.com.netizensservices.home.presenter.ProblemListPresneter;
import jni.text.zhzl.com.netizensservices.mvp.base.BaseActivity;
import jni.text.zhzl.com.netizensservices.utils.AudioRecoderUtils;
import jni.text.zhzl.com.netizensservices.utils.DebugLog;
import jni.text.zhzl.com.netizensservices.utils.SoftKeyboardUtils;
import jni.text.zhzl.com.netizensservices.utils.TimeUtils;
import jni.text.zhzl.com.netizensservices.utils.ToastUtil;
import jni.text.zhzl.com.netizensservices.view.Topbar;

import static android.view.MotionEvent.ACTION_MOVE;

public class ProblemListActivity extends BaseActivity<ProblemListPresneter.ProblemListUI, ProblemListPresneter> implements ProblemListPresneter.ProblemListUI {


    private AudioRecoderUtils mAudioRecoderUtils;


    @Override
    protected ProblemListPresneter.ProblemListUI createUI() {
        return this;
    }

    @Override
    protected ProblemListPresneter createPresenter() {
        return new ProblemListPresneter();
    }

    @SuppressWarnings("all")
    @Override
    protected void initViews() {


        String title = getIntent().getStringExtra(Constants.TITLT);

        Topbar topbar = getUI().finder().find(R.id.topbar);
        topbar.setlefttext(title);


        //展示下面隐藏啊布局  展示图库选择和拍摄视频
        RxView.clicks(getUI().finder().find(R.id.add_more)).throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
                    getPresenter().ShowMorePopWindow();

                });


        //跳转地图选择位置页面
        RxView.clicks(getUI().finder().textView(R.id.problem_address)).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {

                    Intent intent = new Intent(this, ChoicePositionActivity.class);
                    startActivity(intent);


                });


        //语音图标
        RxView.clicks(getUI().finder().find(R.id.problem_voice)).throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
//                    ToastUtil.showToastMsg("暂不支持语音输入");

                    if (SoftKeyboardUtils.isSoftShowing(this)) {
                        SoftKeyboardUtils.hideSoftKeyboard(this);
                    }

                    int moreviewvis = getUI().finder().find(R.id.more_view).getVisibility();
                    if (moreviewvis == View.VISIBLE) {
                        getUI().finder().find(R.id.more_view).setVisibility(View.GONE);
                    }


                    int visibility = getUI().finder().find(R.id.problem_voice_tv).getVisibility();
                    if (visibility == View.VISIBLE) {

                        getUI().finder().imageView(R.id.problem_voice).setImageResource(R.mipmap.voice_icon);
                        getUI().finder().find(R.id.problem_voice_tv).setVisibility(View.GONE);
                        getUI().geteditview().setVisibility(View.VISIBLE);
                    } else {
                        getUI().finder().imageView(R.id.problem_voice).setImageResource(R.mipmap.voice_type);
                        getUI().geteditview().setVisibility(View.GONE);
                        getUI().finder().find(R.id.problem_voice_tv).setVisibility(View.VISIBLE);
                    }


                });


        final View view = View.inflate(ProblemListActivity.this, R.layout.layout_pop_voitce, null);
        final PopupWindow mPop = new PopupWindow(ProblemListActivity.this);
        mPop.setContentView(view);
        ImageView pop_iv = view.findViewById(R.id.pop_iv);
        mPop.setBackgroundDrawable(getResources().getDrawable(R.mipmap.bg));


        mAudioRecoderUtils = new AudioRecoderUtils();
        //录音回调
        mAudioRecoderUtils.setOnAudioStatusUpdateListener(new AudioRecoderUtils.OnAudioStatusUpdateListener() {
            //录音中....db为声音分贝，time为录音时长
            @Override
            public void onUpdate(double db, long time) {


                pop_iv.getDrawable().setLevel((int) (3000 + 6000 * db / 100));


                DebugLog.d("==声音的分贝===================" + time);
                //根据分贝值来设置录音时话筒图标的上下波动，下面有讲解
//                mImageView.getDrawable().setLevel((int) (3000 + 6000 * db / 100));
//                mTextView.setText(TimeUtils.long2String(time));
            }

            //录音结束，filePath为保存路径
            @Override
            public void onStop(String filePath, long time) {

                if ((int) (time / 1000) < 1) {
                    pop_iv.getDrawable().setLevel(50);
                    return;
                }
                datelist.clear();

                datelist.add(new Problem("", 0, img, 2, (int) (time / 1000), "", "", filePath));

                getPresenter().setNewDate();


//                DebugLog.d("=======================录音结束  语音为" + (int) (time / 1000));
//                Toast.makeText(ProblemListActivity.this, "录音保存在：" + filePath, Toast.LENGTH_SHORT).show();
//                mTextView.setText(TimeUtils.long2String(0));
            }
        });


        getUI().getTvVoice().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        getUI().getTvVoice().setText("松开 结束");
                        mAudioRecoderUtils.startRecord();
                        //弹出popwindow   展示语音动画效果
                        mPop.showAtLocation(getUI().getrl(), Gravity.CENTER, 0, 0);


                        break;
                    case MotionEvent.ACTION_UP:
                        mPop.dismiss();
                        mAudioRecoderUtils.stopRecord();  //结束录音（保存录音文件）


//      mAudioRecoderUtils.cancelRecord(); //取消录音（不保存录音文件）
                        getUI().getTvVoice().setText("按住 说话");
                        break;


                }


                return true;
            }
        });


        RxView.clicks(getUI().finder().find(R.id.problem_send)).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(o -> {

            getPresenter().Sendtext();

        });

        RxView.clicks(getUI().geteditview()).throttleFirst(500, TimeUnit.MICROSECONDS).subscribe(o -> {

            int visibility = getUI().finder().find(R.id.more_view).getVisibility();
            if (visibility == View.VISIBLE) {
                getUI().finder().find(R.id.more_view).setVisibility(View.GONE);
            }
        });

        RxView.clicks(getUI().getcameraview()).throttleFirst(500, TimeUnit.MICROSECONDS).subscribe(o -> {

            getUI().finder().find(R.id.more_view).setVisibility(View.GONE);
            getPermissions();


        });

        RxView.clicks(getUI().finder().find(R.id.problme_photo)).throttleFirst(500, TimeUnit.MICROSECONDS)
                .subscribe(o -> {
                    getUI().finder().find(R.id.more_view).setVisibility(View.GONE);

                    getPresenter().SelectImg();

                });


//        //怼recyclerview 得事件监听  当软键盘唤醒得时候 隐藏掉软键盘
        getUI().getProblemRv().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SoftKeyboardUtils.isSoftShowing(ProblemListActivity.this)) {
                    SoftKeyboardUtils.hideSoftKeyboard(ProblemListActivity.this);
                }

                return false;
            }
        });


    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_problem_list;
    }

    @Override
    public ImageView getAddMoreView() {
        return getUI().finder().find(R.id.add_more);
    }

    @Override
    public RecyclerView getProblemRv() {
        return getUI().finder().find(R.id.problem_rv);
    }

    @Override
    public ImageView getaddmoreview() {
        return getUI().finder().find(R.id.add_more);
    }

    @Override
    public EditText geteditview() {
        return getUI().finder().find(R.id.problem_edit);
    }

    @Override
    public ImageView getcameraview() {
        return getUI().finder().find(R.id.problme_camera);
    }

    @Override
    public ImageView getPhotoView() {
        return getUI().finder().find(R.id.problme_camera);
    }

    @Override
    public TextView getsendtextView() {
        return getUI().finder().find(R.id.problem_send);
    }


    private List<Problem> datelist = new ArrayList<>();

    @Override
    public List<Problem> getdatelist() {
        return datelist;
    }

    @Override
    public TextView getTvVoice() {
        return getUI().finder().find(R.id.problem_voice_tv);
    }

    @Override
    public RelativeLayout getrl() {
        return getUI().finder().find(R.id.rl);
    }

    String img = "http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg";

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        datelist.clear();
        if (requestCode == 23 && resultCode == RESULT_OK) {
            List<Uri> mSelected = Matisse.obtainResult(data);
            List<String> list = Matisse.obtainPathResult(data);
            for (int i = 0; i < list.size(); i++) {
                DebugLog.d("==========" + list.get(i));
                datelist.add(new Problem("", 0, img, 1, 0, "", list.get(i), ""));
            }


        } else if (resultCode == 101) {
            String path = data.getStringExtra("path");
            DebugLog.d("====图片返回路径=================" + path);
            datelist.add(new Problem("", 0, img, 1, 0, "", path, ""));
        } else if (resultCode == 102) {
            String path = data.getStringExtra("path");
            String video = data.getStringExtra("video");
            datelist.add(new Problem("", 0, img, 3, 0, "", path, video));


            DebugLog.d("====视频返回路径==================" + video + "=============图片=" + path);

        }

        getPresenter().setNewDate();

    }

    //权限申请自定义码
    private final int GET_PERMISSION_REQUEST = 100;


    /**
     * 获取权限
     */
    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager
                    .PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager
                            .PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager
                            .PERMISSION_GRANTED) {
                startActivityForResult(new Intent(this, CameraActivity.class), 100);
            } else {
                //不具有获取权限，需要进行权限申请
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA}, GET_PERMISSION_REQUEST);
            }
        } else {
            startActivityForResult(new Intent(this, CameraActivity.class), 100);
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_PERMISSION_REQUEST) {
            int size = 0;
            if (grantResults.length >= 1) {
                int writeResult = grantResults[0];
                //读写内存权限
                boolean writeGranted = writeResult == PackageManager.PERMISSION_GRANTED;//读写内存权限
                if (!writeGranted) {
                    size++;
                }
                //录音权限
                int recordPermissionResult = grantResults[1];
                boolean recordPermissionGranted = recordPermissionResult == PackageManager.PERMISSION_GRANTED;
                if (!recordPermissionGranted) {
                    size++;
                }
                //相机权限
                int cameraPermissionResult = grantResults[2];
                boolean cameraPermissionGranted = cameraPermissionResult == PackageManager.PERMISSION_GRANTED;
                if (!cameraPermissionGranted) {
                    size++;
                }
                if (size == 0) {
                    startActivityForResult(new Intent(this, CameraActivity.class), 100);
                } else {
                    Toast.makeText(this, "请到设置-权限管理中开启", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}
