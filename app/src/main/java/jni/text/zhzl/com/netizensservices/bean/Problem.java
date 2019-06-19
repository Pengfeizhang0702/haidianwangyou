package jni.text.zhzl.com.netizensservices.bean;

/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class Problem {


    /**
     * 用户id
     */
    private String userid;


    /**
     * 用户标识  0 用户   1系统
     */
    private int usertype;


    /**
     * 用户头像
     */
    private String userimg;


    /**
     * 内容类型  0 文字 1 图片  2  语音 3 小视频
     */

    private int contenttype;

    /**
     * 视频   语音  时间长短
     */
    private int time;


    /**
     * 内容文字
     */
    private String contenstr;

    /**
     * 内容图片
     */
    private String contentimg;


    /**
     * 内容为 视频 语音     返回为播放地址
     */
    private String filepath;

    public Problem(String userid, int usertype, String userimg, int contenttype, int time, String contenstr, String contentimg, String filepath) {
        this.userid = userid;
        this.usertype = usertype;
        this.userimg = userimg;
        this.contenttype = contenttype;
        this.time = time;
        this.contenstr = contenstr;
        this.contentimg = contentimg;
        this.filepath = filepath;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getContenttype() {
        return contenttype;
    }

    public void setContenttype(int contenttype) {
        this.contenttype = contenttype;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getContenstr() {
        return contenstr;
    }

    public void setContenstr(String contenstr) {
        this.contenstr = contenstr;
    }

    public String getContentimg() {
        return contentimg;
    }

    public void setContentimg(String contentimg) {
        this.contentimg = contentimg;
    }
}
