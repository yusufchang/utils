package com.migu.reconciliation.utils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class ClientProperty {

//	private static Properties ftpProperty = null;
//	
//	public static final String FTPCONFIG 	= "ftp";
//
//	public static String getProperty(String bundleName, String key) {		
//		String value = null;
//		if(bundleName.equals(FTPCONFIG)){
//			if (ftpProperty == null) {
//				ftpProperty = getPropObjFromBundle(bundleName);
//			}
//			value = ftpProperty.getProperty(key);
//		}
//		return value;
//	}
	
	
	private static Properties ftpProperty = null;
	public static final String FTPCONFIG 	= "ftp";
	public static final String CONFIG 	= "config";

	public static String getProperty(String bundleName, String key) {		
		String value = null;
		if(bundleName.equals(FTPCONFIG) || bundleName.equals(CONFIG)){
			if (ftpProperty == null) {
				ftpProperty = getPropObjFromBundle(bundleName);
			}
			value = ftpProperty.getProperty(key);
		}
		return value;
	}

	private static Properties getPropObjFromBundle(String bundleName) {
		Properties objProp = new Properties();
		PropertyResourceBundle bundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle(bundleName);
		Enumeration<String> enm = bundle.getKeys();
		while (enm.hasMoreElements()) {
			String key = (String) enm.nextElement();
			String value = bundle.getString(key);
			objProp.setProperty(key, value);
		}
		return objProp;
	}
}
