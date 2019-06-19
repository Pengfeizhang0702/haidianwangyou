package jni.text.zhzl.com.netizensservices.utils;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/**
 * creat： zpf
 * mobile： 969038020@qq.com
 */
public class TimeUtils {


    /**
     * @author jankey
     */

        public static long getCurrTime() {
            return Calendar.getInstance().getTimeInMillis();
        }

        public static String getFomatDate() {
            String str = null;
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSSS");
            Date curDate = new Date(System.currentTimeMillis());
            str = formatter.format(curDate);
            return str;
        }

        public static String stampToDateMin(long time) {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            String date = format.format(time);
            return date;
        }

        public static String stampToDate(long time) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = format.format(time);
            return date;
        }


        public static String stampToDate(String s) {
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long lt = new Long(s);
            Date date = new Date(lt * 1000);
            //Date date = new Date(lt);
            res = simpleDateFormat.format(date);
            return res;
        }

        public static String stampToDates(String s) {
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            long lt = new Long(s);
            Date date = new Date(lt * 1000);
            //Date date = new Date(lt);
            res = simpleDateFormat.format(date);
            return res;
        }

        public static String stampToDay(String s) {
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
            long lt = new Long(s);
            Date date = new Date(lt * 1000);
            //Date date = new Date(lt);
            res = simpleDateFormat.format(date);
            return res;
        }

        public static long dateToStampMin(String date) {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            Date time = null;
            try {
                time = format.parse(date);
            } catch (ParseException e) {
                System.out.println(e);
            }
            return time.getTime();
        }

        public static long dateToStamp(String date) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = null;
            try {
                time = format.parse(date);
            } catch (ParseException e) {
                System.out.println(e);
            }
            return time.getTime();
        }

        public static Date getNowDate() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            ParsePosition pos = new ParsePosition(8);
            Date currentTime_2 = formatter.parse(dateString, pos);
            return currentTime_2;
        }

        public static Date getNowDateSecond() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateString = formatter.format(currentTime);
            ParsePosition pos = new ParsePosition(8);
            Date currentTime_2 = formatter.parse(dateString, pos);
            return currentTime_2;
        }

        public static Date getNowDateMin() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            String dateString = formatter.format(currentTime);
            ParsePosition pos = new ParsePosition(8);
            Date currentTime_2 = formatter.parse(dateString, pos);
            return currentTime_2;
        }

        public static Date getNowDateShort() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(currentTime);
            ParsePosition pos = new ParsePosition(8);
            Date currentTime_2 = formatter.parse(dateString, pos);
            return currentTime_2;
        }

        public static String getStringDate() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            return dateString;
        }

        public static String getStringDateSecond() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateString = formatter.format(currentTime);
            return dateString;
        }

        public static String getStringDelay(String date) {
            return stampToDate(dateToStamp(date) + (1000 * 30));
        }

        public static String getStringDelay(String date, int time) {
            return stampToDate(dateToStamp(getStringDate()) + (1000 * time));
        }

        public static String getStringDateMin() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            String dateString = formatter.format(currentTime);
            return dateString;
        }

        public static String getStringDateShort() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(currentTime);
            return dateString;
        }

        public static String getTimeShort() {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date currentTime = new Date();
            String dateString = formatter.format(currentTime);
            return dateString;
        }

        public static Date strToDateLong(String strDate) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = formatter.parse(strDate, pos);
            return strtodate;
        }

        public static String dateToStrLong(Date dateDate) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(dateDate);
            return dateString;
        }

        public static String dateToStr(Date dateDate) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(dateDate);
            return dateString;
        }

        public static Date strToDate(String strDate) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = formatter.parse(strDate, pos);
            return strtodate;
        }

        public static Date strToTime(String strDate) {
            long lt = new Long(strDate);
            Date date = new Date(lt * 1000);
            return date;
        }

        public static String getCusFormat(Long dateStr, String format) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(strToDate(TimeUtils.stampToDate(dateStr)));
        }

        public static Date getNow() {
            Date currentTime = new Date();
            return currentTime;
        }

        public static Date getLastDate(long day) {
            Date date = new Date();
            long date_3_hm = date.getTime() - 3600000 * 34 * day;
            Date date_3_hm_date = new Date(date_3_hm);
            return date_3_hm_date;
        }

        public static String getStringToday() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
            String dateString = formatter.format(currentTime);
            return dateString;
        }

        public static String getHour() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            String dateString = formatter.format(currentTime);
            String hour;
            hour = dateString.substring(11, 13);
            return hour;
        }

        public static String getTime() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            String dateString = formatter.format(currentTime);
            String min;
            min = dateString.substring(14, 16);
            return min;
        }

        public static String getSecond() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            String dateString = formatter.format(currentTime);
            String min;
            min = dateString.substring(17, 19);
            return min;
        }

        public static String getMin() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss SSS");
            String dateString = formatter.format(currentTime);
            String min;
            min = dateString.substring(20, 23);
            return min;
        }

        public static String getUserDate(String sformat) {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(sformat);
            String dateString = formatter.format(currentTime);
            return dateString;
        }

        public static String getTwoHour(String st1, String st2) {
            String[] kk = null;
            String[] jj = null;
            kk = st1.split(":");
            jj = st2.split(":");
            if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
                return "0";
            else {
                double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
                        / 60;
                double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
                        / 60;
                if ((y - u) > 0)
                    return y - u + "";
                else
                    return "0";
            }
        }

        public static String getTwoDay(String sj1, String sj2) {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            long day = 0;
            try {
                Date date = myFormatter.parse(sj1);
                Date mydate = myFormatter.parse(sj2);
                day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
            } catch (Exception e) {
                return "";
            }
            return day + "";
        }

        public static String getPreTime(String sj1, String jj) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String mydate1 = "";
            try {
                Date date1 = format.parse(sj1);
                long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
                date1.setTime(Time * 1000);
                mydate1 = format.format(date1);
            } catch (Exception e) {
            }
            return mydate1;
        }

        public static String getNextDay(String nowdate, String delay) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String mdate = "";
                Date d = strToDate(nowdate);
                long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24
                        * 60 * 60;
                d.setTime(myTime * 1000);
                mdate = format.format(d);
                return mdate;
            } catch (Exception e) {
                return "";
            }
        }

        public static boolean isLeapYear(String ddate) {
            Date d = strToDate(ddate);
            GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
            gc.setTime(d);
            int year = gc.get(Calendar.YEAR);
            if ((year % 400) == 0)
                return true;
            else if ((year % 4) == 0) {
                if ((year % 100) == 0)
                    return false;
                else
                    return true;
            } else
                return false;
        }

        public static String getEDate(String str) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = formatter.parse(str, pos);
            String j = strtodate.toString();
            String[] k = j.split(" ");
            return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
        }

        public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
            String str = dat.substring(0, 8);
            String month = dat.substring(5, 7);
            int mon = Integer.parseInt(month);
            if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
                    || mon == 10 || mon == 12) {
                str += "31";
            } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
                str += "30";
            } else {
                if (isLeapYear(dat)) {
                    str += "29";
                } else {
                    str += "28";
                }
            }
            return str;
        }

        public static String getWeekFomrDay(String Day) {
            Date date = strToDate(Day);
            SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
            return dateFm.format(date);
        }

        public static String getSeqWeek() {
            Calendar c = Calendar.getInstance(Locale.CHINA);
            String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
            if (week.length() == 1)
                week = "0" + week;
            String year = Integer.toString(c.get(Calendar.YEAR));
            return year + week;
        }

        public static String getWeek(String sdate, String num) {
            Date dd = TimeUtils.strToDate(sdate);
            Calendar c = Calendar.getInstance();
            c.setTime(dd);
            if (num.equals("1"))
                c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            else if (num.equals("2"))
                c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            else if (num.equals("3"))
                c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            else if (num.equals("4"))
                c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            else if (num.equals("5"))
                c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            else if (num.equals("6"))
                c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            else if (num.equals("0"))
                c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        }


        public static String getWeek(String sdate) {
            Date date = TimeUtils.strToDate(sdate);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            return new SimpleDateFormat("EEEE").format(c.getTime());
        }

        public static String getWeekStr(String sdate) {
            String str = "";
            str = TimeUtils.getWeek(sdate);
            if ("1".equals(str)) {
                str = "sun";
            } else if ("2".equals(str)) {
                str = "Monday";
            } else if ("3".equals(str)) {
                str = "Tuesday";
            } else if ("4".equals(str)) {
                str = "Wednesday";
            } else if ("5".equals(str)) {
                str = "Thursday";
            } else if ("6".equals(str)) {
                str = "Friday";
            } else if ("7".equals(str)) {
                str = "Saturday";
            }
            return str;
        }

        public static String getWeekStrs(String sdate) {
            String str = "";
            str = TimeUtils.getWeek(sdate);
            if ("星期日".equals(str)) {
                str = "周日";
            } else if ("星期一".equals(str)) {
                str = "周一";
            } else if ("星期二".equals(str)) {
                str = "周二";
            } else if ("星期三".equals(str)) {
                str = "周三";
            } else if ("星期四".equals(str)) {
                str = "周四";
            } else if ("星期五".equals(str)) {
                str = "周五";
            } else if ("星期六".equals(str)) {
                str = "周六";
            }
            return str;
        }

        public static String getWeekInt(String sdate) {
            String str = "";
            str = TimeUtils.getWeek(sdate);
            if ("星期日".equals(str)) {
                str = "0";
            } else if ("星期一".equals(str)) {
                str = "1";
            } else if ("星期二".equals(str)) {
                str = "2";
            } else if ("星期三".equals(str)) {
                str = "3";
            } else if ("星期四".equals(str)) {
                str = "4";
            } else if ("星期五".equals(str)) {
                str = "5";
            } else if ("星期六".equals(str)) {
                str = "6";
            }
            return str;
        }

        public static long getDays(String date1, String date2) {
            if (date1 == null || date1.equals(""))
                return 0;
            if (date2 == null || date2.equals(""))
                return 0;
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            Date mydate = null;
            try {
                date = myFormatter.parse(date1);
                mydate = myFormatter.parse(date2);
            } catch (Exception e) {
            }
            long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
            return day;
        }

        public static String getNowMonth(String sdate) {
            sdate = sdate.substring(0, 8) + "01";
            Date date = TimeUtils.strToDate(sdate);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int u = c.get(Calendar.DAY_OF_WEEK);
            String newday = TimeUtils.getNextDay(sdate, (1 - u) + "");
            return newday;
        }

        public static String getNo(int k) {
            return getUserDate("yyyyMMddhhmmss") + getRandom(k);
        }

        public static String getRandom(int i) {
            Random jjj = new Random();
            if (i == 0)
                return "";
            String jj = "";
            for (int k = 0; k < i; k++) {
                jj = jj + jjj.nextInt(9);
            }
            return jj;
        }

        public static boolean RightDate(String date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            ;
            if (date == null)
                return false;
            if (date.length() > 10) {
                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }
            try {
                sdf.parse(date);
            } catch (ParseException pe) {
                return false;
            }
            return true;
        }

        public static String getNextMonthDay(String sdate, int m) {
            int year = Integer.parseInt(sdate.substring(0, 4));
            int month = Integer.parseInt(sdate.substring(5, 7));
            month = month + m;
            if (month < 0) {
                month = month + 12;
                year = year - 1;
            } else if (month > 12) {
                month = month - 12;
                year = year + 1;
            }
            String smonth = "";
            if (month < 10)
                smonth = "0" + month;
            else
                smonth = "" + month;
            return year + "-" + smonth + "-10";
        }

        public static List<Date> getAllTheDateOftheMonth() {
            List<Date> list = new ArrayList<Date>();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.DATE, 1);

            int month = cal.get(Calendar.MONTH);
            while (cal.get(Calendar.MONTH) == month) {
                list.add(cal.getTime());
                cal.add(Calendar.DATE, 1);
            }
            return list;
        }

        public static String getDate() {
            StringBuffer sb = new StringBuffer();
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            sb.append(year);
            int month = c.get(Calendar.MONTH);
            sb.append(month + 1);
            int day1 = c.get(Calendar.DAY_OF_MONTH);
            sb.append(day1);
            int day2 = c.get(Calendar.DAY_OF_WEEK);
            // sb.append(day2 );
            int day3 = c.get(Calendar.DAY_OF_WEEK_IN_MONTH);
            // sb.append(day3);
            int hour = c.get(Calendar.HOUR);
            sb.append(hour);
            int minute = c.get(Calendar.MINUTE);
            sb.append(minute);
            int second = c.get(Calendar.SECOND);
            sb.append(second);
            return sb.toString();
        }

        public static String getFormatDate(String dateStr, String format) {
            String str = null;
            Date date = null;
            SimpleDateFormat year = new SimpleDateFormat(format);
            try {
                date = year.parse(dateStr);
            } catch (ParseException e) {
                System.out.println(e);
            }
            if (format.equals("yyyy-MM-dd HH:mm:ss SSS")) {
                str = year.format(date);
            }
            if (format.equals("yyyy-MM-dd HH:mm:ss")) {
                str = year.format(date);
            }
            if (format.equals("yyyy-MM-dd HH:mm")) {
                str = year.format(date);
            }
            if (format.equals("yyyy-MM-dd HH")) {
                str = year.format(date);
            }
            if (format.equals("yyyy-MM-dd")) {
                str = year.format(date);
            }
            if (format.equals("yyyy-MM")) {
                str = year.format(date);
            }
            if (format.equals("yyyy")) {
                str = year.format(date);
            }
            if (format.equals("MM-dd HH:mm:ss SSS")) {
                str = year.format(date);
            }
            if (format.equals("MM-dd HH:mm:ss")) {
                str = year.format(date);
            }
            if (format.equals("MM-dd HH:mm")) {
                str = year.format(date);
            }
            if (format.equals("MM-dd HH")) {
                str = year.format(date);
            }
            if (format.equals("MM-dd")) {
                str = year.format(date);
            }
            if (format.equals("MM")) {
                str = year.format(date);
            }
            if (format.equals("dd HH:mm:ss SSS")) {
                str = year.format(date);
            }
            if (format.equals("dd HH:mm:ss")) {
                str = year.format(date);
            }
            if (format.equals("dd HH:mm")) {
                str = year.format(date);
            }
            if (format.equals("dd HH")) {
                str = year.format(date);
            }
            if (format.equals("dd")) {
                str = year.format(date);
            }
            if (format.equals("HH:mm:ss")) {
                str = year.format(date);
            }
            if (format.equals("HH:mm")) {
                str = year.format(date);
            }
            if (format.equals("HH")) {
                str = year.format(date);
            }
            if (format.equals("mm:ss")) {
                str = year.format(date);
            }
            if (format.equals("mm")) {
                str = year.format(date);
            }
            if (format.equals("ss")) {
                str = year.format(date);
            }
            return str;
        }

        public static int dateComp(String date1, String date2) {
            int flag = -1;
            DateFormat df = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            try {
                c1.setTime(df.parse(date1));
                c2.setTime(df.parse(date2));
            } catch (ParseException e) {
                System.err.println("the format errors");
                flag = -1;
            }
            int result = c1.compareTo(c2);
            if (result == 0)
                flag = 0;
            else if (result < 0)
                flag = 1;
            else
                flag = 2;
            return flag;
        }

        public static int dateCompEquase(String date1, String date2) {
            int flag = -1;
            DateFormat df = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            try {
                c1.setTime(df.parse(date1));
                c2.setTime(df.parse(date2));
            } catch (ParseException e) {
                System.err.println("the format errors");
                flag = -1;
            }
            int result = c1.compareTo(c2);
            if (result == 0)
                flag = 0;
            else if (result >= 0)
                flag = 2;
            else
                flag = 1;
            return flag;
        }

        public static int dateCompEquaseTime(String date1, String date2) {
            int flag = -1;
            DateFormat df = new SimpleDateFormat(
                    "HH:mm");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            try {
                c1.setTime(df.parse(date1));
                c2.setTime(df.parse(date2));
            } catch (ParseException e) {
                System.err.println("the format errors");
                flag = -1;
            }
            int result = c1.compareTo(c2);
            if (result == 0)
                flag = 0;
            else if (result >= 0)
                flag = 2;
            else
                flag = 1;
            return flag;
        }

        // 获得当前日期与本周日相差的天数
        private static int getMondayPlus() {
            Calendar cd = Calendar.getInstance();
            // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
            int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国 礼拜一作为第一天所以这里减1
            if (dayOfWeek == 1) {
                return 0;
            } else {
                return 1 - dayOfWeek;
            }
        }

        // 获得本周一的日期
        public static String getMondayOFWeek() {
            int mondayPlus = getMondayPlus();
            GregorianCalendar currentDate = new GregorianCalendar();
            currentDate.add(GregorianCalendar.DATE, mondayPlus);
            Date monday = currentDate.getTime();

            DateFormat df = DateFormat.getDateInstance();
            String preMonday = df.format(monday);
            return preMonday;
        }

        // 获得下周星期一的日期
        public static String getNextMonday() {
            int mondayPlus = getMondayPlus();
            GregorianCalendar currentDate = new GregorianCalendar();
            currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
            Date monday = currentDate.getTime();
            DateFormat df = DateFormat.getDateInstance();
            String preMonday = df.format(monday);
            return preMonday;
        }

        /**
         * 获取过去或者未来 任意天内的日期数组
         *
         * @param intervals intervals天内
         * @return 日期数组
         */
        public static ArrayList<String> getFetureDaysList(int intervals) {
            ArrayList<String> fetureDaysList = new ArrayList<>();
            for (int i = 0; i < intervals; i++) {
                fetureDaysList.add(getFetureDate(i));
            }
            return fetureDaysList;
        }

        /**
         * 获取过去第几天的日期
         *
         * @param past
         * @return
         */
        public static String getPastDate(int past) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String result = format.format(today);
            Log.e(null, result);
            return result;
        }

        /**
         * 获取未来 第 past 天的日期
         *
         * @param past
         * @return
         */
        public static String getFetureDate(int past) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past + 1);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("MM.dd");
            String result = format.format(today);
            Log.e(null, result);
            return result;
        }

        public static ArrayList<String> getFetureDaysLists(int intervals) {
            ArrayList<String> fetureDaysList = new ArrayList<>();
            for (int i = 0; i < intervals; i++) {
                fetureDaysList.add(getFetureDates(i));
            }
            return fetureDaysList;
        }

        public static String getFetureDates(int past) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past + 1);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            String result = format.format(today);
            Log.e(null, result);
            return result;
        }

        public static ArrayList<String> getFetureWeekList(int intervals) {
            ArrayList<String> fetureWeekList = new ArrayList<>();
            for (int i = 0; i < intervals; i++) {
                fetureWeekList.add(getFetureWeek(i));
            }
            return fetureWeekList;
        }

        public static String getFetureWeek(int past) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past + 1);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String resultDay = format.format(today);
            String resultWeek = getWeekStrs(resultDay);
            Log.e(null, resultWeek);
            return resultWeek;
        }

        public static ArrayList<String> getFetureWeekIntList(int intervals) {
            ArrayList<String> fetureWeekList = new ArrayList<>();
            for (int i = 0; i < intervals; i++) {
                fetureWeekList.add(getFetureWeekInt(i));
            }
            return fetureWeekList;
        }

        public static String getFetureWeekInt(int past) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past + 1);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String resultDay = format.format(today);
            String resultWeek = getWeekInt(resultDay);
            Log.e(null, resultWeek);
            return resultWeek;
        }

        public static int compareDate(String date1) {
            int result = 0;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date_two = df.format(new Date());
            try {
                Date date2 = df.parse(date_two);
                Date dt1 = df.parse(date1);


                if (dt1.getTime() > date2.getTime()) {
                    result = 1;
                } else if (dt1.getTime() < date2.getTime()) {
                    result = -1;
                } else {
                    result = 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                return result;
            }
        }


        /**
         * 到毫秒的时间戳转换为时间    1531985359 to  2018-07-19 15:29:19
         *
         * @param seconds
         * @param format
         * @return
         */
        public static String timeStamp2Date(String seconds, String format) {
            if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
                return "";
            }
            if (format == null || format.isEmpty()) {
                format = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date(Long.valueOf(seconds + "000")));
        }


        public static int compareDatetwo(String date1, long datetwo) {
            String datatime = timeStamp2Date(String.valueOf(datetwo), "");
            int result = 0;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dt1 = df.parse(date1);
                Date dt2 = df.parse(datatime);
                if (dt1.getTime() > dt2.getTime()) {
                    result = 1;
                } else if (dt1.getTime() < dt2.getTime()) {
                    result = -1;
                } else {
                    result = 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                return result;
            }
        }


        public static int compareYesterdayDate(String DATE1) {
            int result = 0;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Calendar mCalendar = Calendar.getInstance();
            mCalendar.add(Calendar.DATE, 1);
            Date DATE2 = mCalendar.getTime();
            try {
                Date dt1 = df.parse(DATE1);
                if (dt1.getTime() > DATE2.getTime()) {
                    result = 1;
                } else if (dt1.getTime() < DATE2.getTime()) {
                    result = -1;
                } else {
                    result = 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                return result;
            }
        }

        public static long getDifferentTime(String date) {
            long result = 0;
            Date nowDate = new Date(System.currentTimeMillis());
            DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date dateTime = dateTimeFormat.parse(date);
                result = dateTime.getTime() - nowDate.getTime();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                return result;
            }
        }

        /**
         * @param date    报名时间
         * @param datatwo 服务器时间
         * @return
         */
        public static long getDifferentTimetwo(String date, long datatwo, long usertime) {
            long result = 0;
            String date1 = timeStamp2Date(String.valueOf(datatwo), "");


//        Date nowDate = new Date(System.currentTimeMillis());
            DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date dateTime = dateTimeFormat.parse(date);
                Date dateTime1 = dateTimeFormat.parse(date1);
                result = dateTime.getTime() - dateTime1.getTime() - usertime;
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                return result;
            }
        }


        public static long getDiffTimeMinute(String date) {
            long result = 0;
            Date nowDate = new Date(System.currentTimeMillis());
            DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date dateTime = dateTimeFormat.parse(date);
                result = dateTime.getTime() - nowDate.getTime();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                return result;
            }
        }

        public static long getDiffTimeMinuteRoom(String date) {
            long result = 0;
            Date nowDate = new Date(System.currentTimeMillis());
            DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd H:mm");
            try {
                Date dateTime = dateTimeFormat.parse(date);
                result = dateTime.getTime() - nowDate.getTime();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                return result;
            }
        }

        public static  String getTime(Date date) {//可根据需要自行截取数据显示
            Log.d("getTime()", "choice date millis: " + date.getTime());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(date);
        }

    }
