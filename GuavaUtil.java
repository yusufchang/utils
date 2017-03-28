package com.migu.reconciliation.utils;

import com.google.common.base.CharMatcher;

public class GuavaUtil {

	
	/**
	 * 只保留数字字符
	 * @param str
	 * @return
	 */
	public static String getDigit(String str){
		String theDigits = CharMatcher.DIGIT.retainFrom(str);
		return theDigits;
	}
	
	/**
	 * 只保留字母和数字
	 * @param str
	 * @return
	 */
	public static String geLetterAndDigit(String str){
		String lowerAndDigit = CharMatcher.JAVA_DIGIT
				.or(CharMatcher.JAVA_LETTER)
				.retainFrom(str);
		return lowerAndDigit;
	}
	
	
	/**
	 * 移除所有空白字符
	 * @param str
	 * @return
	 */
	public static String trimAll(String str){
		String noControl = CharMatcher.WHITESPACE.removeFrom(str);
		return noControl;
	}
	
	
	public static void main(String[] args) {
		String theDigits = GuavaUtil.trimAll(" SSS   zh ang  we测好i211llosk ");
		System.out.println(theDigits);
	}

}
