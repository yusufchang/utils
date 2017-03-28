package com.migu.reconciliation.utils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientUtil extends BaseClient{

	private static PoolingHttpClientConnectionManager cm;
	
	static{
		cm = new PoolingHttpClientConnectionManager();
		//Increase max total connection to 200  
		cm.setMaxTotal(200);//总共保持200个连接(对于多个通过该http访问的网站)
		//Increase default max connection per route to 20  
		cm.setDefaultMaxPerRoute(20); //每个网站的默认连接最多20个
		//Increase max connections for localhost:80 to 50
		//连接池里面可以保持长连接到"http://open.wo.com.cn/"地址的最大数是50个,如果你请求"http://open.wo.com.cn/"这个地址的量很大，
		//把50个HTTP连接都占完了，那新的请求过来就需要等到其他使用连接池里面到这个地址的HTTP连接释放了才行
		//HttpHost wo = new HttpHost("http://open.wo.com.cn/", 80);
		//cm.setMaxPerRoute(new HttpRoute(wo), 80);
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
	public static String doPost(String url, String json, String platID, String platPwd,String encode) throws Exception {
		CloseableHttpClient httpclient = bulidHttpClient();
		return doPost(httpclient, url, json, platID, platPwd, encode);
	}

	/**
	 * 发送单个HTTP请求
	 * 
	 * @param url  请求地址
	 * @param json 请求数据JSON格式
	 * @throws Exception
	 */
	public static String doPost(String url, String json, String encode) throws Exception {
		CloseableHttpClient httpclient = bulidHttpClient();
		return doPost(httpclient, url, json, encode);
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
	public static String doPost(String url, Map<String, String> params,String encode) throws Exception {
		CloseableHttpClient httpclient = bulidHttpClient();
		return doPost(httpclient,url, params, encode);
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
	public static String doPostByXml(String url, String xmlContent, String encode) throws Exception {
		CloseableHttpClient httpclient = bulidHttpClient();
		return doPostByXml(httpclient,url, xmlContent, encode);
	}

	/**
	 * 发送Get请求
	 * 
	 * @param url  请求地址
	 * @param json 请求数据JSON格式
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url,String encode) throws Exception {
		CloseableHttpClient httpclient = bulidHttpClient();
		return doGet(httpclient,url, encode);
	}

	
	/**
	 * 发送Get请求
	 * 
	 * @param url  请求地址
	 * @param json 请求数据JSON格式
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url,String platID, String platPwd,String encode) throws Exception {
		CloseableHttpClient httpclient = bulidHttpClient();
		return doGet(httpclient, url, platID, platPwd, encode);
	}
	
	/**
	 * 获取HttpClient对象
	 * @param cm
	 * @return
	 */
	private static CloseableHttpClient bulidHttpClient(){
		cm.closeExpiredConnections(); //清除过期链接
		cm.closeIdleConnections(30, TimeUnit.SECONDS); //一段时间内不活动的连接
		
		CloseableHttpClient httpClient = HttpClients.custom()  
		        .setConnectionManager(cm)
		        .setDefaultRequestConfig(requestConfig)
		        .build();
		
		return httpClient;
	}
	
	/**
	 * 连接回收策略
	 * @author Jvi
	 *
	 */
	/*public static class IdleConnectionEvictor extends Thread {
        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;

        public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        connMgr.closeExpiredConnections(); //过期链接
                        connMgr.closeIdleConnections(5, TimeUnit.SECONDS); //一段时间内不活动的连接
                    }
                }
            } catch (Exception ex) {
                // terminate
            	//ex.printStackTrace();
            }
        }

        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }

    }*/
}
