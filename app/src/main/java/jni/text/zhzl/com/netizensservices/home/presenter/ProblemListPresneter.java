package jni.text.zhzl.com.netizensservices.home.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jni.text.zhzl.com.netizensservices.MyApplication;
import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.bean.Problem;
import jni.text.zhzl.com.netizensservices.home.VideoplayActivity;
import jni.text.zhzl.com.netizensservices.home.adapter.ProblemAdapter;
import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPActivity;
import jni.text.zhzl.com.netizensservices.utils.DebugLog;
import jni.text.zhzl.com.netizensservices.utils.SoftKeyboardUtils;
import jni.text.zhzl.com.netizensservices.utils.ToastUtil;
import jni.text.zhzl.com.netizensservices.utils.glide.GifSizeFilter;
import jni.text.zhzl.com.netizensservices.utils.glide.Glide4Engine;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class ProblemListPresneter extends ActPresenter<ProblemListPresneter.ProblemListUI> {
    private static final int REQUEST_CODE_CHOOSE = 23;

    MediaPlayer mp;


    public interface ProblemListUI extends GEMUI {
        ImageView getAddMoreView();

        RecyclerView getProblemRv();


        ImageView getaddmoreview();

        EditText geteditview();

        ImageView getcameraview();

        ImageView getPhotoView();


        TextView getsendtextView();


        List<Problem> getdatelist();


        TextView getTvVoice();


        RelativeLayout getrl();


    }


    List<Problem> list = new ArrayList<>();
    //列表界面得adapter
    ProblemAdapter adapter;


    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();


    @Override
    public void onUIReady(MVPActivity activity, ProblemListUI ui) {
        super.onUIReady(activity, ui);
        initDate();
        initedlistener();


        initLocation();


    }

    /**
     * 初始化定位信息
     */
    private void initLocation() {
        DebugLog.d("============定位开始");
        mLocationClient = new LocationClient(MyApplication.getInstance());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);

        LocationClientOption option = new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//可选，设置定位模式，默认高精度
//LocationMode.Hight_Accuracy：高精度；
//LocationMode. Battery_Saving：低功耗；
//LocationMode. Device_Sensors：仅使用设备；

        option.setIsNeedLocationPoiList(true);
//可选，是否需要周边POI信息，默认为不需要，即参数为false
//如果开发者需要获得周边POI信息，此处必须为true


        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true

        option.setCoorType("bd09ll");
//可选，设置返回经纬度坐标类型，默认GCJ02
//GCJ02：国测局坐标；
//BD09ll：百度经纬度坐标；
//BD09：百度墨卡托坐标；
//海外地区定位，无需设置坐标类型，统一返回WGS84类型坐标

        option.setScanSpan(1000);
//可选，设置发起定位请求的间隔，int类型，单位ms
//如果设置为0，则代表单次定位，即仅定位一次，默认为0
//如果设置非0，需设置1000ms以上才有效

        option.setOpenGps(true);
//可选，设置是否使用gps，默认false
//使用高精度和仅用设备两种定位模式的，参数必须设置为true

        option.setLocationNotify(true);
//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);
//可选，定位SDK内部是一个service，并放到了独立进程。
//设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)

        option.SetIgnoreCacheException(false);
//可选，设置是否收集Crash信息，默认收集，即参数为false

        option.setWifiCacheTimeOut(5 * 60 * 1000);
//可选，V7.2版本新增能力
//如果设置了该接口，首次启动定位时，会先判断当前Wi-Fi是否超出有效期，若超出有效期，会先重新扫描Wi-Fi，然后定位

        option.setEnableSimulateGps(false);
//可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false

        mLocationClient.setLocOption(option);
        mLocationClient.start();
//mLocationClient为第二步初始化过的LocationClient对象
//需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
//更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明


    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f
            DebugLog.d("===============" + latitude + "===========" + longitude);

            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准

            int errorCode = location.getLocType();
            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息

            DebugLog.d("================" + city + "==========" + district + "=======" + street);

            getUI().finder().textView(R.id.problem_address).setText("当前位置:" + city + district + street);


            String locationDescribe = location.getLocationDescribe();
            DebugLog.d("==============" + locationDescribe);


            List<Poi> poiList = location.getPoiList();

            for (Poi bean : poiList) {

                String name = bean.getName();
                DebugLog.d("=============周边" + name);

            }
            mLocationClient.stop();

        }
    }


    private void initedlistener() {
        getUI().finder().editText(R.id.problem_edit).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    getUI().getAddMoreView().setVisibility(View.INVISIBLE);
                    getUI().getsendtextView().setVisibility(View.VISIBLE);

                } else {
                    getUI().getAddMoreView().setVisibility(View.VISIBLE);
                    getUI().getsendtextView().setVisibility(View.GONE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    String img = "http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg";


    @SuppressWarnings("all")
    private void initDate() {


        list.add(new
                Problem("", 1, img, 0, 0, "欢迎来到海淀网友平台,您可以对" +
                "城市治理提出您得建议,也可以发现城市治理中存在得问题，同时可以举报违法违纪线索，" +
                "共建文明海淀，欢迎你得到来", "", ""));

//        list.add(new Problem(1, 0, img, "欢迎来到海淀网友平台,您可以对城市治理提出您得建议,也可以发现城市治理中存在得问题，同时可以举报违法违纪线索，共建文明海淀，欢迎你得到来", null));


//        list.add(new Problem(0, 1, img, "", img));
//        list.add(new Problem(0, 0, img, "看我发的垃圾桶照片图片", null));
//
//
//        list.add(new Problem(1, 0, img, "我们已经收到您提交的信息,感谢您的幸苦", null));
//
//
//        list.add(new Problem(0, 0, img, "你们真是太棒了,", null));
//        list.add(new Problem(0, 1, img, "", img));
//
//
//        list.add(new Problem(1, 0, img, "服务窗口即将关闭", null));


//


        adapter = new ProblemAdapter(R.layout.item_problem, list);
        getUI().getProblemRv().setLayoutManager(new LinearLayoutManager(getActivity()));
        getUI().getProblemRv().setAdapter(adapter);
        getUI().getProblemRv().scrollToPosition(list.size() - 1);


        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.item_user_voice_tv:
                        ToastUtil.showToastMsg("语音开始播放");
                        mp = new MediaPlayer();

                        try {

                            if (mp.isPlaying()) {
                                mp.stop();
                                ToastUtil.showToastMsg("暂停播放===============");
                            } else {
                                String filepath = list.get(position).getFilepath();
                                mp.setDataSource(filepath);
                                mp.prepare();
                                mp.start();
                            }


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;

                    case R.id.user_content_img:

                        int contenttype = list.get(position).getContenttype();
                        if (contenttype == 1) {


                        } else {

//                            视频
                            Intent intent = new Intent(getActivity(), VideoplayActivity.class);
                            intent.putExtra("useCache", false);
                            intent.putExtra("path", list.get(position).getFilepath());

                            getActivity().startActivity(intent);


                        }

                        break;


                }

            }
        });


//        mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//            @Override
//            public boolean onError(MediaPlayer mp, int what, int extra) {
//                ToastUtil.showToastMsg("文件已经过期销毁");
//
//                return false;
//            }
//        });
//        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//
//                DebugLog.d("=================播放完成");
//            }
//        });

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 弹出popwindow
     */
    public void ShowMorePopWindow() {

        if (SoftKeyboardUtils.isSoftShowing(getActivity())) {
            SoftKeyboardUtils.hideSoftKeyboard(getActivity());
        }

        int visibility = getUI().finder().find(R.id.more_view).getVisibility();
        if (visibility == View.VISIBLE) {
            getUI().finder().find(R.id.more_view).setVisibility(View.GONE);
        } else {
            getUI().finder().find(R.id.more_view).setVisibility(View.VISIBLE);
        }


    }


    /**
     * 发送文字
     */
    public void Sendtext() {

        String trim = getUI().geteditview().getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            ToastUtil.showToastMsg("发送的内容不能为空哦");
            return;
        }

        adapter.addData(new Problem("", 0, img, 0, 0, trim, "", ""));


        getUI().geteditview().setText("");
        getUI().getAddMoreView().setVisibility(View.VISIBLE);
        getUI().getsendtextView().setVisibility(View.GONE);
        getUI().getProblemRv().scrollToPosition(list.size() - 1);

    }


    /**
     * 图库选择照片
     */
    public void SelectImg() {

        Matisse.from(getActivity())
                .choose(MimeType.ofImage(), false)
                .theme(R.style.Matisse_Dracula)
                .countable(true)
//                .capture(true)
//                .captureStrategy(
//                        new CaptureStrategy(true, "com.zhjy.cultural.services.fileprovider"))
                .maxSelectable(5)
                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(
                        getActivity().getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.85f)
                // for glide-V3
//               .imageEngine(new GlideEngine())
                // for glide-V4
                .imageEngine(new Glide4Engine())
                .originalEnable(true)
                .maxOriginalSize(10)
                .forResult(REQUEST_CODE_CHOOSE);
    }


    public void setNewDate() {
        List<Problem> getdatelist = getUI().getdatelist();

        adapter.addData(getdatelist);
        getUI().getProblemRv().scrollToPosition(list.size() - 1);
    }


}
