package com.migu.reconciliation.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;


public class SSlClientUtil extends BaseClient {
	
	private static PoolingHttpClientConnectionManager connManager = null;
	
	static{  
		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
		ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
		registryBuilder.register("http", plainSF);
		//指定信任密钥存储对象和连接套接字工厂
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			//信任任何链接
			TrustStrategy anyTrustStrategy = new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					return true;
				}
			};
			SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
			LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			registryBuilder.register("https", sslSF);
		} catch (KeyStoreException e) {
			throw new RuntimeException(e);
		} catch (KeyManagementException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		Registry<ConnectionSocketFactory> registry = registryBuilder.build();
		connManager = new PoolingHttpClientConnectionManager(registry);
		
		//Increase max total connection to 200  
		connManager.setMaxTotal(200);//总共保持200个连接(对于多个通过该http访问的网站)
		//Increase default max connection per route to 20  
		connManager.setDefaultMaxPerRoute(20); //每个网站的默认连接最多20个
		//Increase max connections for localhost:80 to 50
		//连接池里面可以保持长连接到"http://open.wo.com.cn/"地址的最大数是50个,如果你请求"http://open.wo.com.cn/"这个地址的量很大，
		//把50个HTTP连接都占完了，那新的请求过来就需要等到其他使用连接池里面到这个地址的HTTP连接释放了才行
		//HttpHost wo = new HttpHost("http://open.wo.com.cn/", 80);
		//cm.setMaxPerRoute(new HttpRoute(wo), 80);
    }  
	
	
	/**
	 * 获取https连接
	 * @return
	 */
	private static CloseableHttpClient getHttpClient() {
		connManager.closeExpiredConnections(); //清除过期链接
		connManager.closeIdleConnections(30, TimeUnit.SECONDS); //一段时间内不活动的连接
		CloseableHttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connManager).build();
		return httpClient;
	}

	/**
	 * doGet
	 *
	 * @param url     请求的url
	 * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url, Map<String, String> queries,String encode) throws IOException {
		CloseableHttpClient httpClient = getHttpClient();
		return doGet(httpClient, url, queries, encode);
	}

	
	/**
	 * doGet
	 *
	 * @param url     请求的url
	 * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
	 * @return
	 * @throws Exception 
	 */
	public static String doGet(String url,String encode) throws Exception {
		CloseableHttpClient httpClient = getHttpClient();
		return doGet(httpClient, url, encode);
	}
	
	/** post
	 * @param url     请求的url
	 * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
	 * @param params  post form 提交的参数
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String url, Map<String, String> params,String encode) throws Exception {
		CloseableHttpClient httpClient = getHttpClient();
		return doPost(httpClient, url, params, encode);
	}
	
	public static void main(String[] args) throws Exception{
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		/*TreeMap<String, String> queries = new TreeMap<String, String>();
		queries.put("appid", "APPID");
		queries.put("secret", "SECRET");
		queries.put("code", "CODE");
		queries.put("grant_type", "authorization_code");*/
		String result = SSlClientUtil.doGet(url, BaseClient.UTF8);
		System.out.println(result);
	}
	
}
