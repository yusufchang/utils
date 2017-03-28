package com.migu.reconciliation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateUtil {
	public static String getCurrentTime(){
		return new Date().getTime()+"";
	}
	public static Integer getSeconds(String time) throws Exception{
		long oldTime = stringConvetDate(time,"yyyy-MM-dd HH:mm:ss").getTime();
		long newTime = new Date().getTime();
		Integer seconds = (int) ((newTime-oldTime)/1000);
		return seconds;
		
	}
	public static Integer getSeconds(String time,String current) throws Exception{
		long oldTime = stringConvetDate(time,current).getTime();
		long newTime = new Date().getTime();
		Integer seconds = (int) ((newTime-oldTime)/1000);
		return seconds;
		
	}
	public static Integer getMilliseconds(String time,String current) throws Exception{
		long oldTime = stringConvetDate(time,current).getTime();
		long newTime = new Date().getTime();
		Integer seconds = (int) ((newTime-oldTime));
		return seconds;
		
	}
	public static Integer getSeconds(long oldTime) throws Exception{
		long newTime = new Date().getTime();
		if(oldTime > newTime){
			return -1;
		}
		Integer seconds = (int) ((newTime-oldTime)/1000);
		return seconds;
		
	}
	//得到当前的时间
		public static  String getCurrentDate() throws Exception{
			SimpleDateFormat formatDate =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = formatDate.format(new Date());	
			try {
			String  date = formatDate.format(formatDate.parse(str));
			   return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			} 
		}
		//得到当前的时间
		public static  String getCurrentDate(String current) {
			SimpleDateFormat formatDate =new SimpleDateFormat(current);
			String str = formatDate.format(new Date());	
			return str;
		}
		//字符串转化成日期
		public static Date stringConvetDate(String time,String current){
			SimpleDateFormat formatDate =new SimpleDateFormat(current);	
			Date date=null;
			try {
				if (time!=null) {
				date=formatDate.parse(time);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return date;
		}
		
		public static boolean isValidDate(String str) {
		      boolean convertSuccess=true;
		      // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		       try {
		    	  // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		          format.setLenient(false);
		          format.parse(str);
		       } catch (ParseException e) {
		           convertSuccess=false;
		       } 
		       return convertSuccess;
		}
		/**
		 * 对日期加减
		 * @param num 正数为加  负数为减
		 * @return
		 * @throws Exception
		 */
		public static String dayOfMouthCount(int num) throws Exception{
			String result="";
			String str=getCurrentDate();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date date = formatter.parse(str);
		    Calendar c = Calendar.getInstance();
		    c.setTime(date);
		    c.add(Calendar.DAY_OF_MONTH, num);
		    date = c.getTime();
		    result=formatter.format(date);
			return result;
		}
		/**
		 * 判定起止时间是否越界
		 * @param start 开始时间
		 * @param end  结束时间
		 * @param num  界限 单位：天
		 * @return
		 * @throws Exception
		 */
		public static boolean timeOutOfBond(String start,String end,int num) throws Exception{
			boolean result=false;
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date startDate= formatter.parse(start);
		    Date endDate= formatter.parse(end);
		    long time=endDate.getTime()-startDate.getTime();
		    long bond=num*1000*86400;
		    if (time>bond) {
				result=true;
			}
			return result;
		}
//		public static void main(String[] args) {
//			try {
//				System.out.println(timeOutOfBond("2016-06-11 10:00:00","2016-06-21 14:00:00",10));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
}
