package com.migu.reconciliation.utils;

public class IntegerUtil {
	/**
	 * 返回四舍五入的整形
	 * @param val1
	 * @param val2
	 * @return
	 * @throws Exception
	 */
	public static Integer getIntegerValue(int val1, double val2) throws Exception {
		if(val1 == 0) {
			return 0;
		} else {
			return Integer.parseInt("" + Math.round(val1 * val2));
		}
	}
	
	public static Integer getIntegerValue(double val1, double val2) throws Exception {
		if(val1 == 0) {
			return 0;
		} else {
			return Integer.parseInt("" + Math.round(val1 * val2));
		}
	}
}
