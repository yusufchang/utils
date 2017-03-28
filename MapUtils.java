package com.migu.reconciliation.utils;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapUtils {
	public static class MapKeyComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}
	
	/**
	 * 按map中key的ascii对map进行排序
	 * @param map
	 * @return
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}
	
	public static String map2String(Map<String, String> map) {
		if(map == null || map.isEmpty()) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		Iterator<String> keyIter = map.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			sb.append(key).append("=").append(map.get(key)).append("&");
		}
		
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	
	public static String map2XmlString(Map<String, String> map) {
		if(map == null || map.isEmpty()) {
			return null;
		}
		StringBuffer sb = new StringBuffer().append("<xml>");
		Iterator<String> keyIter = map.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			//sb.append(key).append("=").append(map.get(key)).append("&");
			sb.append("<").append(key).append(">").append(map.get(key)).append("</").append(key).append(">");
		}
		
		return sb.append("</xml>").toString();
	}
}
