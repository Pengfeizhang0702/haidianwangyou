package jni.text.zhzl.com.netizensservices.common.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.cloud.CloudListener;
import com.baidu.mapapi.cloud.CloudManager;
import com.baidu.mapapi.cloud.CloudRgcInfo;
import com.baidu.mapapi.cloud.CloudRgcResult;
import com.baidu.mapapi.cloud.CloudSearchResult;
import com.baidu.mapapi.cloud.DetailSearchResult;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorInfo;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

import java.util.ArrayList;
import java.util.List;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.common.adapter.AddressAdapter;
import jni.text.zhzl.com.netizensservices.mvp.ActPresenter;
import jni.text.zhzl.com.netizensservices.mvp.GEMUI;
import jni.text.zhzl.com.netizensservices.mvp.MVPActivity;
import jni.text.zhzl.com.netizensservices.utils.DebugLog;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class ChoicePositionPresenter extends ActPresenter<ChoicePositionPresenter.ChoicePositionUI> {
    public interface ChoicePositionUI extends GEMUI {
        MapView getmapview();

        RecyclerView getRecyclerview();


    }

    @Override
    public void onUIReady(MVPActivity activity, ChoicePositionUI ui) {
        super.onUIReady(activity, ui);

        initLoaction();
        initAdapter();


    }

    private List<String> list = new ArrayList<>();
    private AddressAdapter addressAdapter;


    private void initAdapter() {
        addressAdapter = new AddressAdapter(R.layout.item_address, list);
        getUI().getRecyclerview().setLayoutManager(new LinearLayoutManager(getActivity()));
        getUI().getRecyclerview().setAdapter(addressAdapter);


        mPoiSearch = PoiSearch.newInstance();


    }

    private BaiduMap map;
    LocationClient mLocationClient;

    private void initLoaction() {

        map = getUI().getmapview().getMap();
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.zoom(19.0f);
        map.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        map.setMyLocationEnabled(true);


        //定位初始化
        mLocationClient = new LocationClient(getActivity());

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

        option.setIsNeedLocationPoiList(true);
//可选，是否需要周边POI信息，默认为不需要，即参数为false
//如果开发者需要获得周边POI信息，此处必须为true

        mLocationClient.setLocOption(option);
//mLocationClient为第二步初始化过的LocationClient对象
//需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
//更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明

//设置locationClientOption
        mLocationClient.setLocOption(option);


//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        list.clear();

        map.setMyLocationConfiguration(new MyLocationConfiguration(LocationMode.FOLLOWING, false, null, 0, 0));


//开启地图定位图层
        mLocationClient.start();

        map.setOnMapStatusChangeListener(listener);


    }

    PoiSearch mPoiSearch;

    OnGetPoiSearchResultListener mPoiSearchlistener = new OnGetPoiSearchResultListener() {
        @Override
        public void onGetPoiResult(PoiResult poiResult) {
            List<PoiInfo> allPoi = poiResult.getAllPoi();

            if (allPoi == null) {

                DebugLog.d("===========检索为空");
                return;
            }


            for (PoiInfo info : allPoi) {
                String name = info.getName();
                DebugLog.d("=================" + name);
            }

        }

        @Override
        public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
            DebugLog.d("========asasasasasasasa============噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦============");

        }

        @Override
        public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
            List<PoiIndoorInfo> poiIndoorInfos = poiIndoorResult.getmArrayPoiInfo();

            String name = poiIndoorInfos.get(0).name;
            DebugLog.d("========asasasasasasasa========================" + name);


        }

        //废弃
        @Override
        public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

        }
    };


    BaiduMap.OnMapStatusChangeListener listener = new BaiduMap.OnMapStatusChangeListener() {
        /**
         * 手势操作地图，设置地图状态等操作导致地图状态开始改变。
         *
         * @param status 地图状态改变开始时的地图状态
         */
        @Override
        public void onMapStatusChangeStart(MapStatus status) {

        }

        /**
         * 手势操作地图，设置地图状态等操作导致地图状态开始改变。
         *
         * @param status 地图状态改变开始时的地图状态
         *
         * @param reason 地图状态改变的原因
         */

        //用户手势触发导致的地图状态改变,比如双击、拖拽、滑动底图
        //int REASON_GESTURE = 1;
        //SDK导致的地图状态改变, 比如点击缩放控件、指南针图标
        //int REASON_API_ANIMATION = 2;
        //开发者调用,导致的地图状态改变
        //int REASON_DEVELOPER_ANIMATION = 3;
        @Override
        public void onMapStatusChangeStart(MapStatus status, int reason) {

        }

        /**
         * 地图状态变化中
         *
         * @param status 当前地图状态
         */
        @Override
        public void onMapStatusChange(MapStatus status) {

        }

        /**
         * 地图状态改变结束
         *
         * @param status 地图状态改变结束后的地图状态
         */
        @Override
        public void onMapStatusChangeFinish(MapStatus status) {

            LatLng target = status.target;
            latitude = target.latitude;
            longitude = target.longitude;

            setAnimation();
            DebugLog.d("====================poikaishi"+latitude+"============="+longitude);

            mPoiSearch.setOnGetPoiSearchResultListener(mPoiSearchlistener);
            mPoiSearch.searchNearby(new PoiNearbySearchOption()
                    .location(new LatLng(latitude, longitude))
                    .radius(1000)
                    .keyword("学校")
                    .pageNum(10));




        }
    };
//设置地图状态监听


    /**
     * 中心点
     */
    private double latitude, longitude;


    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || getUI().getmapview() == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            map.setMyLocationData(locData);

            latitude = location.getLatitude();
            longitude = location.getLongitude();


            List<String> strlist = new ArrayList<>();
            strlist.clear();

            List<Poi> poiList = location.getPoiList();

            for (Poi bean : poiList) {
                String name = bean.getName();
                strlist.add(name);
            }
            addressAdapter.addData(strlist);
            mLocationClient.stop();




        }

    }


    /**
     * 设置弹出动画
     */
    public void setAnimation() {

        Animation translateAnimation = new TranslateAnimation(0, 0, 0, -150);
        translateAnimation.setDuration(300);
        getUI().finder().imageView(R.id.point).startAnimation(translateAnimation);
    }


}
