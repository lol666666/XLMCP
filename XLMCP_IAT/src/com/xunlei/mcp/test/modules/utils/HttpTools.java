package com.xunlei.mcp.test.modules.utils;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 通过http请求调用接口
 * 
 * @author peiyu
 * 
 */
public class HttpTools {
	/**
	 * GET请求
	 * 
	 * @param sUrl
	 *            ，请求的地址
	 * @param data
	 *            ，请求的参数序列
	 * @return 返回JSON串形式的结果
	 */
	static public JSONObject httpGetRequest(String sUrl, String data) {
		JSONObject resultJsonObject = null;
		System.out.println("请求地址：" + sUrl);
		String request = sUrl + "?" + data;
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(request);
		get.setHeader("content-type", "text/plain;charset=utf-8");
		try {
			HttpResponse response = client.execute(get);
			String resultString = EntityUtils.toString(response.getEntity());
			resultJsonObject = JSONObject.fromObject(resultString);
			if (resultJsonObject == null) {
				fail("response error, body is null...");
			}
			System.out.println("返回结果：" + resultJsonObject);
			get.releaseConnection();
			client.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultJsonObject;
	}

	/**
	 * http POST请求
	 * 
	 * @param url
	 *            ，请求的地址
	 * @param map
	 *            ，请求的参数Map
	 * @return 返回JSON串形式的结果
	 */
	public static JSONObject httpPostRequest(String url, Map<String, String> map) {
		JSONObject resultJsonObject = null;
		System.out.println("http请求地址：" + url);
		CloseableHttpClient client = HttpClientBuilder.create().build();
		try {
			HttpPost post = new HttpPost(url);
			Set<String> keySet = map.keySet();
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			for (String s : keySet) {
				if (!"".equals(map.get(s))) {
					NameValuePair param = new BasicNameValuePair(s, map.get(s));
					params.add(param);
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,
					"UTF-8");
			entity.setContentType("application/x-www-form-urlencoded; charset=utf-8");
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			String resultString = EntityUtils.toString(response.getEntity());
			resultJsonObject = JSONObject.fromObject(resultString);
			if (resultJsonObject == null) {
				fail("response error, body is null...");
			}
			System.out.println("返回结果：" + resultJsonObject);
			post.releaseConnection();
			client.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultJsonObject;
	}

	/**
	 * https POST请求
	 * 
	 * @param url
	 *            ，请求的地址
	 * @param map
	 *            ，请求的参数Map
	 * @return 返回JSON串形式的结果
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static JSONObject httpsPostRequest(String url,
			Map<String, String> map) throws Exception {
		JSONObject resultJsonObject = null;
		System.out.println("https请求地址：" + url);
		HttpClient client = null;
		try {
			client = new SSLClient();
			HttpPost post = new HttpPost(url);
			Set<String> keySet = map.keySet();
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			for (String s : keySet) {
				if (!"".equals(map.get(s))) {
					NameValuePair param = new BasicNameValuePair(s, map.get(s));
					params.add(param);
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,
					"UTF-8");
			entity.setContentType("application/x-www-form-urlencoded; charset=utf-8");
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			String resultString = EntityUtils.toString(response.getEntity(),
					"UTF-8");
			resultJsonObject = JSONObject.fromObject(resultString);
			if (resultJsonObject == null) {
				fail("response error, body is null...");
			}
			System.out.println("返回结果：" + resultJsonObject);
			post.releaseConnection();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultJsonObject;
	}

	/**
	 * http上传Multipart方式文件
	 * 
	 * @param sUrl
	 *            ，请求的地址
	 * @param filePath
	 *            ，上传的文件路径
	 * @param params
	 *            ，请求的参数
	 * @return 返回JSON串形式的结果
	 */
	static public JSONObject UploadHttpFile(String sUrl,
			Map<String, String> params, String filePath) {
		JSONObject resultJsonObject = null;
		File file = new File(filePath);
		CloseableHttpClient cilent = HttpClients.createDefault();
		try {
			HttpPost post = new HttpPost(sUrl);
			FileBody bin = new FileBody(file);

			MultipartEntityBuilder multiEntityBuilder = MultipartEntityBuilder
					.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			multiEntityBuilder.addPart("file", bin);

			Iterator<Entry<String, String>> it = params.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> entry = it.next();
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				StringBody part = new StringBody(value,
						ContentType.MULTIPART_FORM_DATA);
				multiEntityBuilder.addPart(key, part);

			}

			HttpEntity reqEntity = multiEntityBuilder.build();

			post.setEntity(reqEntity);

			CloseableHttpResponse response = cilent.execute(post);

			String resultString = EntityUtils.toString(response.getEntity());
			resultJsonObject = JSONObject.fromObject(resultString);
			if (resultJsonObject == null) {
				fail("response error, body is null...");
			}
			System.out.println("返回结果：" + resultJsonObject);
			response.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultJsonObject;
	}
	
	/**
	 * http上传Multipart方式文件
	 * 
	 * @param sUrl
	 *            ，请求的地址
	 * @param filePath
	 *            ，上传的文件路径
	 * @param params
	 *            ，请求的参数
	 * @return 返回JSON串形式的结果
	 */
	@SuppressWarnings("resource")
	static public JSONObject UploadHttpsFile(String sUrl,
			Map<String, String> params, String filePath) {
		JSONObject resultJsonObject = null;
		File file = new File(filePath);
		System.out.println("https请求地址：" + sUrl);
		HttpClient client = null;
		try {
			client = new SSLClient();
			HttpPost post = new HttpPost(sUrl);
			FileBody bin = new FileBody(file);

			MultipartEntityBuilder multiEntityBuilder = MultipartEntityBuilder
					.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			multiEntityBuilder.addPart("file", bin);

			Iterator<Entry<String, String>> it = params.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> entry = it.next();
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				StringBody part = new StringBody(value,
						ContentType.MULTIPART_FORM_DATA);
				multiEntityBuilder.addPart(key, part);

			}

			HttpEntity reqEntity = multiEntityBuilder.build();
			post.setEntity(reqEntity);

			HttpResponse response = client.execute(post);

			String resultString = EntityUtils.toString(response.getEntity());
			resultJsonObject = JSONObject.fromObject(resultString);
			if (resultJsonObject == null) {
				fail("response error, body is null...");
			}
			System.out.println("返回结果：" + resultJsonObject);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultJsonObject;
	}
}
