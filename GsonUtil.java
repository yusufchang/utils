package com.migu.reconciliation.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("unchecked")
public class GsonUtil {

	/**
	 * json字符串转换为List对象
	 * @param json 需要转换的json字符串
	 * @param type = new TypeToken<List<Object>>(){};其中Object为需要转换的对象名称
	 * @return
	 */
	public static <T> T toList(String json,TypeToken<T> type) {
		Object obj = null;
		try {
			Gson gson = new Gson();
			obj = null;
			obj = gson.fromJson(json,type.getType());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return (T) obj;
	}
	
	/**
	 * json字符串转换为List<Map>对象
	 * @param json 需要转换的字符串
	 * @return
	 */
	public static List<Map<String, Object>> toMaps(String json) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(json,new TypeToken<List<Map<String, Object>>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	/**
	 * json字符串转换为指定对象
	 * @param json 需要转换的json字符串
	 * @param pojoCalss Object.class
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> pojoCalss) {
    	Object pojo = null;
    	try{
			pojo = new Gson().fromJson(json, pojoCalss);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
    	return (T) pojo;
	}
    
	/**
	 * 对象直接转换为json
	 * @param obj
	 * @return
	 */
    public static String toJson(Object obj){
    	String json = null;
    	try {
			json = new Gson().toJson(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	return json;
    }
    
    public static void main(String[] args) {
		/*String str = "[{'interfaceName':'5分钟页面访问日志信息','interfaceCode':'PUB-50111','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:00:00 AM','fileId':'14501736003133740198600281546754'},{'interfaceName':'5分钟页面访问日志信息','interfaceCode':'PUB-50111','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:05:00 AM','fileId':'14501952002532673391354427338408'},{'interfaceName':'5分钟页面访问日志信息','interfaceCode':'PUB-50111','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:10:00 AM','fileId':'14501952002531991718113348082059'},{'interfaceName':'5分钟页面访问日志信息','interfaceCode':'PUB-50111','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:15:00 AM','fileId':'14501952002530494150660347792590'},{'interfaceName':'5分钟页面访问日志信息','interfaceCode':'PUB-50111','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:20:00 AM','fileId':'14501952002535439467875229184766'},{'interfaceName':'5分钟页面访问日志信息','interfaceCode':'PUB-50111','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:25:00 AM','fileId':'14501952002531757515152309655535'},{'interfaceName':'客户端反馈信息','interfaceCode':'PUB-50103','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:30:00 AM','completeTime':'Dec 17, 2015 12:49:00 AM','fileId':'14501952000463017929976347075850'},{'interfaceName':'剧集和单集关系表','interfaceCode':'CMS-20112','systemName':'CMS','sysName':'CMS_联系人','sysMobile':'13651675001','deadline':'Dec 17, 2015 12:30:00 AM','completeTime':'Dec 17, 2015 5:02:00 AM','fileId':'14501952000453997523228186431854'},{'interfaceName':'www节目运营信息','interfaceCode':'POMS-10110','systemName':'POMS','sysName':'POMS_联系人','sysMobile':'13651675006','deadline':'Dec 17, 2015 12:30:00 AM','completeTime':'Dec 17, 2015 12:48:00 AM','fileId':'14501952000445623098579886196307'},{'interfaceName':'自建CDN用户使用日志','interfaceCode':'AAA-10118','systemName':'AAA','sysName':'AAA_联系人','sysMobile':'13651675000','deadline':'Dec 17, 2015 12:30:00 AM','completeTime':'Dec 17, 2015 12:43:00 AM','fileId':'14501952000483634005318159015529'}]";
		List<IntfFileStatusVo> list = JSONSupport.toList(str,new TypeToken<List<IntfFileStatusVo>>(){});
		for (IntfFileStatusVo vo : list) {
			System.out.println(vo.getInterfaceCode()+","+vo.getInterfaceName());
		}*/
		/*List<Map<String, Object>> list = JSONSupport.listKeyMaps(str);
		for (Map<String, Object> map : list) {
			System.out.println(map.get("interfaceCode"));
		}
		String str2 = "{'interfaceName':'5分钟页面访问日志信息','interfaceCode':'PUB-50111','systemName':'PUB','sysName':'PUB_联系人','sysMobile':'13651675007','deadline':'Dec 17, 2015 12:00:00 AM','fileId':'14501736003133740198600281546754'}";
		IntfFileStatusVo vo = JSONSupport.toObject(str2, IntfFileStatusVo.class);
		System.out.println(vo.getInterfaceName());*/
	}
}
