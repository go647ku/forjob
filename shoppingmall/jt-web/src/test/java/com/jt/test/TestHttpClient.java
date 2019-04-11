package com.jt.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.jt.common.service.HttpClientService;
import com.sun.tools.doclint.Entity;

import sun.net.www.http.HttpClient;

public class TestHttpClient {
	/**
	 * 1 定义jar包
	 * 2定义请求路径
	 * 3获取工具api对象
	 * 4定义请求方式get/post
	 * 5发起请求，获取响应结果
	 * 6对请求状态码进行判断 200则表示请求成功
	 * 7获取最终返回数据，进行业务处理
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Test
	public void testGet() throws ClientProtocolException, IOException {
		String url="www.tmooc.cn";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse response = client.execute(get);
		if(response.getStatusLine().getStatusCode()==200) {
			//表示请求成功
			String result=EntityUtils.toString(response.getEntity());
			System.out.println(result);
		}
	}
	//通过工具api可以直接获取远程返回值
	@Test
	public void testHttpClient() {
		String url="http://manage.jt.com/web/findItem/562379";
		HttpClientService httpClient = new HttpClientService();
		String result=httpClient.doGet(url);
		
	}
}
