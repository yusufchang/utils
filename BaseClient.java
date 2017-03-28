package com.migu.reconciliation.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public abstract class BaseClient {

	public final static String UTF8 = "UTF-8";
	public final static String GBK = "GBK";
	public final static int TIME_OUT = 10000;  //超时时间设置 默认10秒
	public static RequestConfig requestConfig;
	
	static{
		//设置超时时间
		requestConfig = RequestConfig.custom()
				.setSocketTimeout(TIME_OUT)
				.setConnectTimeout(TIME_OUT)
				.build();
	}
	
	/**
	 * 获取返回数据
	 * 
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public static String getContent(HttpResponse response,String encode) {
		HttpEntity entity = response.getEntity();
		byte[] bytes;
		String content = null;
		try {
			bytes = EntityUtils.toByteArray(entity);
			content = new String(bytes, encode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	public static List<NameValuePair> setParams(Map<String, String> map) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (null != map) {
			Iterator<String> iter = map.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				String value = map.get(key);
				nvps.add(new BasicNameValuePair(key, value));
			}
		}
		return nvps;
	}

	
	public static String toUrl(String url,Map<String, String> params){
		Set<String> keys = params.keySet();
		StringBuffer buffer = new StringBuffer(url);
		if(null!=keys && !keys.isEmpty()){
			boolean flag = true;
			for (String val : keys) {
				if(flag){
					buffer.append("?");
					flag = false;
				}else{
					buffer.append("&");
				}
				buffer.append(val).append("=").append(params.get(val));
			}
		}
		return buffer.toString();
	}
	
	
	/**
	 * 发送POST请求
	 * @param url 请求地址
	 * @param json 请求数据JSON格式
	 * @param platID
	 * @param platPwd
	 * @return
	 * @throws Exception
	 */
	public static String doPost(CloseableHttpClient httpclient,String url, String json, String platID, String platPwd,String encode) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json;charset="+encode+"");
		httpPost.setHeader("Authorization", "platformID=\""+platID+"\",password=\""+platPwd+"\"");

		StringEntity entity = new StringEntity(json, encode);
		httpPost.setEntity(entity);
		
		//IdleConnectionEvictor connEvictor = new IdleConnectionEvictor(cm);
        //connEvictor.start();
        
		CloseableHttpResponse response = httpclient.execute(httpPost);
		String content = null;
		try {
			//HttpEntity entity2 = response.getEntity();
			content = getContent(response,encode);
			//EntityUtils.consume(entity2);
		} finally {
			response.close();
		}
        
		//Thread.sleep(20000);
        //connEvictor.shutdown();
        //connEvictor.join();
        return content;
	}
	
	/**
	 * 发送单个HTTP请求
	 * 
	 * @param url  请求地址
	 * @param json 请求数据JSON格式
	 * @throws Exception
	 */
	public static String doPost(CloseableHttpClient httpclient,String url, String json, String encode) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json;charset="+encode+"");

		StringEntity entity = new StringEntity(json,encode);
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpclient.execute(httpPost);
		String content = null;
		try {
			//HttpEntity entity2 = response.getEntity();
			content = getContent(response,encode);
			//EntityUtils.consume(entity2);
		} finally {
			response.close();
		}
		return content;
	}
	
	/**
	 * 发送单个HTTP请求
	 * 
	 * @param url  请求地址
	 * @param json 请求数据JSON格式
	 * @throws Exception
	 */
	public static String doPostByXml(CloseableHttpClient httpclient,String url, String json, String encode) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		//httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "text/xml;charset="+encode+"");

		StringEntity entity = new StringEntity(json,encode);
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpclient.execute(httpPost);
		String content = null;
		try {
			//HttpEntity entity2 = response.getEntity();
			content = getContent(response,encode);
			//EntityUtils.consume(entity2);
		} finally {
			response.close();
		}
		return content;
	}
	
	/**
	 * 发送单个HTTP请求
	 * 
	 * @param url
	 *            请求地址
	 * @param json
	 *            请求数据JSON格式
	 * @throws Exception
	 */
	public static String doPost(CloseableHttpClient httpclient,String url, Map<String, String> params,String encode) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvp = setParams(params);
		httpPost.setEntity(new UrlEncodedFormEntity(nvp, encode));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		String content = null;
		try {
			//HttpEntity entity2 = response.getEntity();
			content = getContent(response,encode);
			//EntityUtils.consume(entity2);
		} finally {
			response.close();
		}
		return content;
	}
	
	
	/**
	 * 发送Get请求
	 * 
	 * @param url  请求地址
	 * @param json 请求数据JSON格式
	 * @return
	 * @throws Exception
	 */
	public static String doGet(CloseableHttpClient httpclient,String url,String encode) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json;charset="+encode+"");
		
		CloseableHttpResponse response = httpclient.execute(httpGet);
		String content = null;

		try {
			//HttpEntity entity = response.getEntity();
			content = getContent(response,encode);
			//EntityUtils.consume(entity);
		} finally {
			response.close();
		}
		return content;
	}
	
	
	public static String doGet(CloseableHttpClient httpclient,String url, Map<String, String> queries,String encode) throws IOException {
		String url2 = toUrl(url, queries);
		HttpGet httpGet = new HttpGet(url2);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json;charset="+encode+"");
		
		CloseableHttpResponse response = httpclient.execute(httpGet);
		String content = null;

		try {
			//HttpEntity entity = response.getEntity();
			content = getContent(response,encode);
			//EntityUtils.consume(entity);
		} finally {
			response.close();
		}
		return content;
	}
	
	
	/**
	 * 发送Get请求
	 * 
	 * @param url  请求地址
	 * @param json 请求数据JSON格式
	 * @return
	 * @throws Exception
	 */
	public static String doGet(CloseableHttpClient httpclient,String url,String platID, String platPwd,String encode) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json;charset="+encode+"");
		httpGet.setHeader("Authorization", "platformID=\""+platID+"\",password=\""+platPwd+"\"");
		
		CloseableHttpResponse response = httpclient.execute(httpGet);
		String content = null;

		try {
			//HttpEntity entity = response.getEntity();
			content = getContent(response,encode);
			//EntityUtils.consume(entity);
		} finally {
			response.close();
		}
		return content;
	}
	
}
