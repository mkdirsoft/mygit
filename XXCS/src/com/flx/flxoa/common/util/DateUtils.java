package com.flx.flxoa.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 类名称：DateUtils.java
 * 类描述：
 * 创建时间：2018-3-19, 下午1:31:27
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
public class DateUtils {
	/** 
	 * 获取精确到秒的时间戳 
	 * @param date 
	 * @return 
	 */  
	public static int getSecondTimestamp(Date date){  
		if (null == date) {  
			return 0;  
		}  
		String timestamp = String.valueOf(date.getTime()/1000);  
		return Integer.valueOf(timestamp);  
	} 
	/**
	 * 将时间戳转化成时间（String）
	 * @param t
	 * @return
	 * @throws ParseException
	 */
	public static String timestampToDate(int t){
		//时间戳转化为Sting
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Long time=new Long(t)*1000; 
		String date = format.format(time); 
		return date;
	}
	/**
	 * 将时间戳直接转换成 yyyy-MM-dd 格式
	 * @param t
	 * @return
	 */
	public static String timestampDate(int t){
		//时间戳转化为Sting
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Long time=new Long(t)*1000; 
		String date = format.format(time); 
		return date;
	}
	/**
	 * 将时间戳直接转换成 HH:mm:ss 格式
	 * @param t
	 * @return
	 */
	public static String timestampTime(int t){
		//时间戳转化为Sting
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss"); 
		Long time=new Long(t)*1000; 
		String date = format.format(time); 
		return date;
	}
	/**
	 * 将时间戳转化成时间（String）
	 * @param t
	 * @return
	 * @throws ParseException
	 */
	public static String timestampToDate(int t,String simpleFormat){
		//时间戳转化为Sting
		SimpleDateFormat format = new SimpleDateFormat(simpleFormat); 
		Long time=new Long(t)*1000; 
		String date = format.format(time);
		if("1970-01-01".equals(date)){
			date = "";
		}
		return date;
	}
	/**
	 * 获取本年的第一天
	 * @param year
	 * @return
	 */
	public static Date getCurrYearFirst(){
		Calendar currCal=Calendar.getInstance();  
		int currentYear = currCal.get(Calendar.YEAR);        
		currCal.clear();
		currCal.set(Calendar.YEAR, currentYear);
		Date currYearFirst = currCal.getTime();
		return currYearFirst;
	}
	/**
	 * 获取当天开始时间
	 * @return
	 */
	public static Date getStartTime() {  
		Calendar todayStart = Calendar.getInstance();  
		todayStart.set(Calendar.HOUR_OF_DAY,0);
		todayStart.set(Calendar.MINUTE,0);
		todayStart.set(Calendar.SECOND,0);
		todayStart.set(Calendar.MILLISECOND,0);  
		return todayStart.getTime();  
	} 
	/**
	 * 获取当前时间
	 */
	public static Date getCurrentDay(Date date) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);  
		calendar.add(Calendar.DAY_OF_MONTH, 0);  
		date = calendar.getTime();  
		return date;  
	}  
	/**
	 * 获取下一天。(未用到此方法)
	 * @param d
	 * @return
	 */
	public static Date getNextDay(Date d) {
		if (d == null) return null;
		Calendar cld = Calendar.getInstance();
		cld.setTime(d);
		cld.add(Calendar.DAY_OF_MONTH, 1);
		return cld.getTime();
	}
	/**
	 * 凌晨时间戳
	 * @return
	 */
	public static int getMorningTimestamp(){
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0); 
		String timestamp = String.valueOf(calendar.getTime().getTime()/1000);  
		return Integer.valueOf(timestamp); 
	}
	/**
	 * 获取当天结束时间
	 * @return
	 */
	public static Date getEndTime() {  
		Calendar todayEnd = Calendar.getInstance();  
		todayEnd.set(Calendar.HOUR_OF_DAY,0);
		todayEnd.getTime();
		todayEnd.set(Calendar.HOUR,23);
		todayEnd.set(Calendar.MINUTE,59);
		todayEnd.set(Calendar.SECOND,59);
		todayEnd.set(Calendar.MILLISECOND,999);
		return todayEnd.getTime();  
	}
	/**
	 * 获取昨天开始时间时间戳
	 * @return
	 */
	public static int getPreStartTime() {  
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0); 
		String timestamp = String.valueOf(calendar.getTime().getTime()/1000);  
		return Integer.valueOf(timestamp); 
	}  
	/**
	 * 获取昨天结束时间时间戳
	 * @return
	 */
	public static int getPreEndTime() {  
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.getTime();
		calendar.set(Calendar.HOUR,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND,999);  
		String timestamp = String.valueOf(calendar.getTime().getTime()/1000);  
		return Integer.valueOf(timestamp); 
	}
	/**
	 * 获取本月开始时间的时间戳
	 * @param format
	 * @return
	 */
	public static int getMonthStart(){
		Calendar calendar = Calendar.getInstance();  
		calendar.add(Calendar.MONTH, 0);  
		calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天  
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		//将毫秒至0  
		calendar.set(Calendar.MILLISECOND, 0); 
		String timestamp = String.valueOf(calendar.getTime().getTime()/1000);
		// 获取本月第一天的时间戳  
		return Integer.valueOf(timestamp);
	}
	/**
	 * 获取本年的开始时间的时间戳
	*/
	public static int getYearStart(){
		Calendar calendar = Calendar.getInstance();  
		calendar.add(Calendar.YEAR, 0);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天  
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		//将毫秒至0  
		calendar.set(Calendar.MILLISECOND, 0); 
		String timestamp = String.valueOf(calendar.getTime().getTime()/1000);
		// 获取本年第一天的时间戳  
		return Integer.valueOf(timestamp);
	}
	/**
	 * 字符串日期按指定格式转时间戳
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static int dateToTimestamp(String dateStr, String format){
		int timestamp=0;
		try {
			timestamp=getSecondTimestamp(parse(dateStr, format));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}
	
	/**
	 * 字符串日期转时间戳
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static int dateToTimestamp(String dateStr){
		if(!CommonUtils.isEmpty(dateStr)){
			int timestamp=0;
			try {
				timestamp=getSecondTimestamp(parse(dateStr, "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return timestamp;
		}else{
			return 0;
		}
	}

	/**
	 * 字符串日期（日期到时分秒）转时间戳
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static int dateToTimestamp2(String dateStr){
		int timestamp=0;
		try {
			timestamp=getSecondTimestamp(parse(dateStr, "yyyy-MM-dd HH:mm"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	public static String getNowString(String format) {
		return format(new Date(), format);
	}

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}
	public static String format2(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String format(Date date, String format) {
		if (date == null) return "";
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(date);
	}

	public static Date parse(String dateStr) throws ParseException {
		return parse(dateStr, "yyyy-MM-dd");
	}
	public static Date parse2(String dateStr) throws ParseException {
		return parse(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date parse(String dateStr, String format) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.parse(dateStr);
	}
	
	/** 
     * 根据开始时间和结束时间返回时间段内的时间集合 
     *  
     * @param beginDate 
     * @param endDate 
     * @return List 
     */  
    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {  
        List<Date> lDate = new ArrayList<Date>();  
        lDate.add(beginDate);// 把开始时间加入集合  
        Calendar cal = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间  
        cal.setTime(beginDate);  
        boolean bContinue = true;  
        while (bContinue) {  
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
            cal.add(Calendar.DAY_OF_MONTH, 1);  
            // 测试此日期是否在指定日期之后  
            if (endDate.after(cal.getTime())) {  
                lDate.add(cal.getTime());  
            } else {  
                break;  
            }  
        }  
        lDate.add(endDate);// 把结束时间加入集合  
        return lDate;
    }
    /**
	 * 获取当天一个月前的时间戳
	 * @param format
	 * @return
	 */
	public static int getCouMonthStart(){
		Calendar calendar = Calendar.getInstance();  
		calendar.add(Calendar.MONTH, -1);  
		//calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天  
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		//将毫秒至0  
		calendar.set(Calendar.MILLISECOND, 0); 
		String timestamp = String.valueOf(calendar.getTime().getTime()/1000);
		// 获取本月第一天的时间戳  
		return Integer.valueOf(timestamp);
	}
	/**
	 * 获取当天一个周前的时间戳
	 * @param format
	 * @return
	 */
	public static int getCouWeekStart(){
		Calendar calendar = Calendar.getInstance();  
		calendar.add(Calendar.MONTH, 0);  
		//calendar.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天  
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		//将毫秒至0  
		calendar.set(Calendar.MILLISECOND, 0); 
		String timestamp = String.valueOf(calendar.getTime().getTime()/1000);
		// 获取本月第一天的时间戳  
		return Integer.valueOf(timestamp);
	}
	public static String getWeekOfDate(Date date) {      
	    String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};        
	    Calendar calendar = Calendar.getInstance();      
	    if(date != null){        
	         calendar.setTime(date);      
	    }        
	    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
	    if (w < 0){        
	        w = 0;      
	    }      
	    return weekOfDays[w];    
	}
	/*public static void main(String[] args){
	    //今天是2015-10-19 星期一
	    String weekOfDate = null; //参数为null时表示获取当前日期是星期几
	    weekOfDate = getWeekOfDate(null);
	    System.out.println(weekOfDate);
	    //输出 星期一
	 
	    Date date = new Date();
	    date.setDate(18); //指定日期也可以
	    weekOfDate = getWeekOfDate(date);
	    System.out.println(weekOfDate);
	    //输出 星期日
	 }*/
}

