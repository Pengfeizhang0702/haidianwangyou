package jni.text.zhzl.com.netizensservices.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding2.view.RxView;

import jni.text.zhzl.com.netizensservices.R;
import jni.text.zhzl.com.netizensservices.mvp.ViewFinder;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class Topbar extends LinearLayout {

    private ViewFinder finder;
    private String lefttext;
    private String title;


    public Topbar(Context context) {
        super(context);
        init(context, null);
    }


    public Topbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public Topbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        int compatPadingTop = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            compatPadingTop = getStatusBarHeight();
        }

        LayoutInflater.from(context).inflate(R.layout.custom_topbar, this, true);
        finder = new ViewFinder(this);
        RxView.clicks(finder.find(R.id.topbar_back)).subscribe(o -> {
            ((Activity) (getContext())).finish();
        });
        ViewGroup.LayoutParams lp = finder.find(R.id.item_head).getLayoutParams();
        lp.height = compatPadingTop;


        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
            lefttext = ta.getString(R.styleable.Topbar_left_text);
            title = ta.getString(R.styleable.Topbar_title);
//
//            rightText = ta.getString(R.styleable.Topbar_right_text);
//            rightIcon = ta.getDrawable(R.styleable.Topbar_right_icon);
//            leftVis = ta.getBoolean(R.styleable.Topbar_left_vis, true);
//            bgColor = ta.getColor(R.styleable.Topbar_bg_color, getResources().getColor(R.color.color_ffffff));
            ta.recycle();
        }

        setlefttext(lefttext);
        setTitle(title);
    }


    /**
     * 设置左侧文字
     *
     * @param title
     */
    public void setlefttext(String title) {
        finder.textView(R.id.topbar_left_text).setText(title);
    }



    /**
     * 设置
     *
     * @param title
     */
    private void setTitle(String title) {
        finder.textView(R.id.topbar_title).setText(title);
    }


    /**
     * 设置左侧返回图片不可见
     */
    public void setLeftiv() {

        finder.find(R.id.topbar_back).setVisibility(GONE);
    }


    public int getStatusBarHeight() {
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
