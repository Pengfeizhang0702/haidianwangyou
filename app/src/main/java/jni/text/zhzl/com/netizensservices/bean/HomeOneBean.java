package jni.text.zhzl.com.netizensservices.bean;

import java.io.Serializable;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class HomeOneBean implements Serializable {


    private String title;
    private int img;
    private int type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public HomeOneBean(String title, int img, int type) {
        this.title = title;
        this.img = img;
        this.type = type;
    }
}
