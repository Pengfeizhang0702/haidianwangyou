package jni.text.zhzl.com.netizensservices;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.baidu.mapapi.SDKInitializer;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class MyApplication extends MultiDexApplication {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(com.baidu.mapapi.CoordType.BD09LL);

    }

    public static MyApplication getInstance() {
        // 这里不用判断instance是否为空
        return instance;
    }
}
