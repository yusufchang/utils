package com.migu.reconciliation.utils;

import java.io.IOException;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	/**
	 * 从Map对象转换到Json字符串
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public static String map2Json(Map<String,Object> map) throws Exception {
		if(map == null || map.size() == 0) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
        String jsonstr = mapper.writeValueAsString(map);
        return jsonstr;
	}
	
	/**
	 * 从Json字符串转换到对象
	 * @param jsonStr
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static <T> Object Json2Obj(String jsonStr, Class<T> obj) throws Exception {
		if (StringUtils.isEmpty(jsonStr)) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		T clas = mapper.readValue(jsonStr, obj);
		
		return clas;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
