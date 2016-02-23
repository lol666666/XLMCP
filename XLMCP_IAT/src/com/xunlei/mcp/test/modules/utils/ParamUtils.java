package com.xunlei.mcp.test.modules.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 处理接口调用参数
 * 
 * @author peiyu
 * 
 */
public class ParamUtils {

	/**
	 * 参数序列化
	 * 
	 * @param map
	 * @return
	 */
	public static String map2Str(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key);
			sb.append("=");
			try {
				sb.append(URLEncoder.encode(map.get(key), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sb.append("&");
		}
		if (!map.isEmpty())
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * 将url和接口名拼成请求地址
	 * 
	 * @param sUrl
	 * @param apiName
	 * @return
	 */
	public static String GetPostUrl(String sUrl, String apiName) {
		if (!sUrl.endsWith("/")) {
			sUrl += "/";
		}
		String urlEnd = apiName.replace('.', '/');
		String resultString = sUrl + urlEnd;
		return resultString;
	}
}
