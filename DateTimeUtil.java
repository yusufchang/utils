package com.migu.reconciliation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * @author Fred.Chung
 * 2014/10/14
 */
public final class DateTimeUtil {
	
	public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
	public static final String yyyyMMddHHmmss2 = "yyyyMMddHHmmss";
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String yyyyMMdd2 = "yyyyMMdd";
	public static final String yyyyMM = "yyyyMM";
	public static final String yyyyMM2 = "yyyy-MM";
	public static final String HHMMSS = "HHmmss";

	private DateTimeUtil() {
	}
	
	public static final String getFormatTime(String formatStr){
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(new GregorianCalendar().getTime());
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static Date StringToDate(String strDate,String pattern){
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDaysBetween(Date date1, Date date2) {
		Calendar d1 = Calendar.getInstance();
		d1.setTime(date1);
		Calendar d2 = Calendar.getInstance();
		d2.setTime(date2);
		if (d1.after(d2)) {
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);

			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}
	public static int compareDate(String date1, String date2,SimpleDateFormat sdf) throws ParseException {
		return compareDate(sdf.parse(date1),sdf.parse(date2));
	}

	public static int compareDate(Date date1, Date date2) {
		if (null == date1) {
			if (null == date2) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (null == date2) {
				return -1;
			} else {
				return date1.compareTo(date2);
			}
		}
	}

	public static Date getCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		return calendar.getTime();
	}

	public static Date getCurrentDate() {
		Calendar calendar = new GregorianCalendar();
		Date time = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String s = format.format(time);
		try {
			return format.parse(s);
		} catch (Exception e) {
			return null;
		}
	}

	public static int getCurrentYear() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.MONTH) + 1;
	}

	public static String getWeekOfDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		switch (week) {
		case 1:
			return "星期日";
		case 2:
			return "星期一";
		case 3:
			return "星期二";
		case 4:
			return "星期三";
		case 5:
			return "星期四";
		case 6:
			return "星期五";
		case 7:
			return "星期六";
		default:
			break;
		}
		return "Unknown";
	}

	public static String formatTime(Date date, String pattern) {
		if(date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public static Date toTime(String time, String pattern) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(time);
	}

	public static Date getFirstDayOfCurrentWeek() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.getActualMinimum(Calendar.DAY_OF_WEEK);
		calendar.set(Calendar.DAY_OF_WEEK, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	public static Date getFirstDayOfCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	public static Date getFirstDayOfCurrentSeason() {
        Calendar cDay = Calendar.getInstance();     
        cDay.setTime(new Date());  
        int curMonth = cDay.get(Calendar.MONTH);  
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH){    
            cDay.set(Calendar.MONTH, Calendar.JANUARY);  
        }
        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE){    
            cDay.set(Calendar.MONTH, Calendar.APRIL);  
        }  
        if (curMonth >= Calendar.JULY && curMonth <= Calendar.SEPTEMBER) {    
            cDay.set(Calendar.MONTH, Calendar.JULY);  
        }  
        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {    
            cDay.set(Calendar.MONTH, Calendar.OCTOBER);  
        }  
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMinimum(Calendar.DAY_OF_MONTH));  
        return cDay.getTime();     
	}
	public static Date getLastDayOfCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getFirstDayOfDate(String date) throws Exception {
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		String nowDate = year+"-"+month+"-"+1;
		return toTime(nowDate, "yyyy-MM-dd");
	}
	
	public static Date getLastDayOfDate(String date) throws Exception {
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		int maxDate = cal.getActualMaximum(Calendar.DATE);
		String nowDate = year+"-"+month+"-"+maxDate;
		return toTime(nowDate, "yyyy-MM-dd");
	}
	
	/**
	 * 获得上月指定日期
	 * @param date
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static Date getLastMonthDay(String date, int day) throws Exception {
		Date firstDayOfMonth = getFirstDayOfDate(date);
		Date lastDayOfMonth = addDays(firstDayOfMonth, -1);
		String lastDayOfMonthStr = formatTime(lastDayOfMonth, yyyyMMdd);
		
		String[] dates = lastDayOfMonthStr.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		//int day = Integer.parseInt(dates[2]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		//int maxDate = cal.getActualMaximum(Calendar.DATE);
		String nowDate = year+"-"+month+"-"+day;
		return toTime(nowDate, "yyyy-MM-dd");
	}
	
	/**
	 * 获得指定月指定日期
	 * @param date
	 * @param diffMonthNum
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static Date getSpecifyMonthDay(String date, int diffMonthNum, int day) throws Exception {
		//Date firstDayOfMonth = 
		Date lastDayOfMonth = null;
		String lastDayOfMonthStr = date;
		int diffMonthNums = diffMonthNum;
		if(diffMonthNums == 0) {
			lastDayOfMonth = getFirstDayOfDate(lastDayOfMonthStr);
		} else {
			if(diffMonthNum < 0) {
				for(; diffMonthNums < 0; diffMonthNums++) {
					lastDayOfMonth = getFirstDayOfDate(lastDayOfMonthStr);
					lastDayOfMonth = addDays(lastDayOfMonth, -1);
					lastDayOfMonthStr = formatTime(lastDayOfMonth, yyyyMMdd);
				}
			} else {
				for(; diffMonthNums > 0; diffMonthNums--) {
					lastDayOfMonth = getLastDayOfDate(lastDayOfMonthStr);
					lastDayOfMonth = addDays(lastDayOfMonth, 1);
					lastDayOfMonthStr = formatTime(lastDayOfMonth, yyyyMMdd);
				}
			}
			
			
		}
		//String lastDayOfMonthStr = formatTime(lastDayOfMonth, yyyyMMdd);
		
		String[] dates = lastDayOfMonthStr.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		//int day = Integer.parseInt(dates[2]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		//int maxDate = cal.getActualMaximum(Calendar.DATE);
		String nowDate = year+"-"+month+"-"+day;
		return toTime(nowDate, "yyyy-MM-dd");
	}
	
	/**
	 * 获取指定日期的所属月份的最后一天
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getLastDayOfDate(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();
		if(date == null) {
			cal.setTime(new Date());
		} else {
			cal.setTime(date);
		}
		
		
		int maxDate = cal.getActualMaximum(Calendar.DATE);
		String nowDate = cal.get(cal.YEAR)+"-"+(cal.get(cal.MONTH)+1)+"-"+maxDate;
		return toTime(nowDate, "yyyy-MM-dd");
	}
	
	/**
	 * 获取指定2个日期相差的月份数
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception 
	 */
	public static int getDiffMonthsOfTwoDate(Date beginDate, Date endDate) throws Exception {
		int result = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(beginDate);
        c2.setTime(endDate);
        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        //return result == 0 ? 1 : Math.abs(result);
		return Math.abs(result+1);
	}
	
	 /**获取指定日期的星期信息
	 * @author Nany
	 * 2015年2月2日下午2:40:02
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date){  
        String[] weeks = {"周日","周一","周二","周三","周四","周五","周六"};  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;  
        if(week_index<0){  
            week_index = 0;  
        }   
        return weeks[week_index];  
    }
	
	/**
	 * 返回标准格式的日期字符串。格式:yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public static String getStandardTimeFormat(String str) {
		if(StringUtil.isEmpty(str)) {
			return null;
		}
		String year = null;
		String month = null;
		String day = null;
		//System.out.println(str);
		if(str.indexOf("月") > 0) {
			String[] datetimeSplit = str.replaceAll("月 -", "月-").split(" ");
			if(datetimeSplit.length == 1) {//04-11月-15
				System.out.println("datetimeSplit=" + datetimeSplit[0]);
				String[] dateSplit = datetimeSplit[0].split("-");
				year  = "20" + dateSplit[2].trim();
				month = StringUtil.fixStr(Integer.parseInt(dateSplit[1].replaceAll("月", "").trim()), 2);
				day   = dateSplit[0].trim();
				return (year + "-" + month + "-" + day);
			} else if(datetimeSplit.length == 3) {//04-11月-15 09.52.17.000000 上午
				String time = null;
				String[] dateSplit = datetimeSplit[0].split("-");
				year  = "20" + dateSplit[2].trim();
				month = StringUtil.fixStr(Integer.parseInt(dateSplit[1].replaceAll("月", "").trim()), 2);
				day   = dateSplit[0].trim();
				
				String[] timeSplit = datetimeSplit[1].split("\\.");
				if("下午".equals(datetimeSplit[2])) {
					time = " " + (Integer.parseInt(timeSplit[0].trim()) + 12) + ":" + timeSplit[1].trim() + ":" + timeSplit[2].trim();
				} else if("上午".equals(datetimeSplit[2])) {
					time = " " + timeSplit[0].trim() + ":" + timeSplit[1].trim() + ":" + timeSplit[2].trim();
				}
				return (year + "-" + month + "-" + day + time);
			}
		}
		return str;
	}
	
	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static int DateToInt(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String year = "" + calendar.get(Calendar.YEAR);
		String month = (calendar.get(Calendar.MONTH)+1) >= 10 ?  "" + (calendar.get(Calendar.MONTH)+1): "0" + (calendar.get(Calendar.MONTH)+1);
		String day = calendar.get(Calendar.DATE) >= 10 ? "" + calendar.get(Calendar.DATE) : "0" + calendar.get(Calendar.DATE); 
		return  Integer.parseInt(year + month + day);
	}
	
	public static String getTime(String str) {
		if(str.length() == 14) {//20160615140936
			return str.substring(0, 4) + "-" + str.substring(4, 6) + "-"  + str.substring(6, 8) + " " + str.substring(8, 10) + ":" + str.substring(10, 12) + ":" + str.substring(12, 14);
		}
		
		return null;
	}
	
	/**
	 * 获取指定日期的下月月份
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static String getNextMonth(String str, String format) throws Exception {
		if(str == null) {
			return null;
		}
		String result = null;
		if(str.length() == 6) {//201608
			result = str.substring(0, 4) + "-" + str.substring(4) + "-01";
			//result = formatTime(addDays(getLastDayOfDate(result), 1), yyyyMMdd2).substring(0, 6);
		} else if(str.length() == 7) {//2016-08
			result = str + "-01";
			//result = formatTime(addDays(getLastDayOfDate(result), 1), yyyyMMdd).substring(0, 7);
		} else if(str.length() == 8){//20160812
			result = str.substring(0, 4) + "-" + str.substring(4,6) + "-" + str.substring(6);
			//result = formatTime(addDays(getLastDayOfDate(result), 1), yyyyMMdd2).substring(0, 6);
		} else if(str.length() == 10 && str.charAt(4) == '-' && str.charAt(7) == '-'){//2016-08-12
			result = str;
		} else {
			return null;
		}
		
		if(yyyyMMdd2.toLowerCase().equals(format.toLowerCase())) {
			return formatTime(addDays(getLastDayOfDate(result), 1), yyyyMMdd2).substring(0, 6);
		} else if(yyyyMMdd.toLowerCase().equals(format.toLowerCase())) {
			return formatTime(addDays(getLastDayOfDate(result), 1), yyyyMMdd).substring(0, 7);
		}
		return null;
	}
	
	/**
	 * 获取指定日期（月份）的最后一天
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String getLastDayOfMonth(String str, String format) throws Exception {
		if(str == null) {
			return null;
		}
		String result = null;
		if(str.length() == 6) {//201608
			result = str.substring(0, 4) + "-" + str.substring(4) + "-01";
		} else if(str.length() == 7) {//2016-08
			result = str + "-01";
		} else if(str.length() == 8){//20160812
			result = str.substring(0, 4) + "-" + str.substring(4,6) + "-" + str.substring(6);
		} else if(str.length() == 10 && str.charAt(4) == '-' && str.charAt(7) == '-'){//2016-08-12
			result = str;
		} else {
			return null;
		}
		
		if(yyyyMMdd2.toLowerCase().equals(format.toLowerCase())) {
			return formatTime(getLastDayOfDate(result), yyyyMMdd2);
		} else if(yyyyMMdd.toLowerCase().equals(format.toLowerCase())) {
			return formatTime(getLastDayOfDate(result), yyyyMMdd);
		}
		return null;
	}
	
	public static Date addDateTime(String str, int num, String type) throws Exception {
		if(StringUtil.isEmpty(str)) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		if(str.length() == 14) {
			cal.setTime(StringToDate(str, yyyyMMddHHmmss2));
		} else if(str.length() == 19) {
			cal.setTime(StringToDate(str, yyyyMMddHHmmss));
		}
        
        if("HOUR".equals(type)) {
        	cal.add(Calendar.HOUR_OF_DAY, num);
        }
        return cal.getTime();
        //return formatTime(cal.getTime(), yyyyMMddHHmmss);
	}
	
	
	public static void main(String[] args) throws Exception {
		/*String start = "2016-01-16";
		String end = "2016-12-15";
		int v = DateTimeUtil.getDiffMonthsOfTwoDate(DateTimeUtil.toTime(start, DateTimeUtil.yyyyMMdd), DateTimeUtil.toTime(end, DateTimeUtil.yyyyMMdd));
		System.out.println(v);*/
		
		//System.out.println(getStandardTimeFormat("04-4月 -16 10.51.06.501000 下午") + "==");
		//System.out.println(getStandardTimeFormat("04-11月-15") + "==");
		
		//System.out.println(getLastMonthDay("2016-04-10", 25));
		//System.out.println(getSpecifyMonthDay("2016-04-10", 1, 25));
		
		//System.out.println(DateTimeUtil.addDays(DateTimeUtil.getFirstDayOfCurrentMonth(), -1));
		
		/*Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		System.out.println(DateToInt(cal.getTime()));*/
		//System.out.println(getTime("20160615140936"));
		//System.out.println(getNextMonth("2016-08","yyyy-mm-dd"));
		//System.out.println(getLastDayOfMonth("2016-08","yyyymmdd"));
		System.out.println(addDateTime("2016-08-31 16:08:30", 8, "HOUR"));
	}
}
