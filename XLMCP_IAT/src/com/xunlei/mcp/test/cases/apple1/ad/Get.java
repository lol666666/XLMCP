package com.xunlei.mcp.test.cases.apple1.ad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Ignore;
import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Get extends BaseCase{
	String sessionId = String.valueOf(new Date().getTime());
	
	@Test(summary = "获取通知栏推荐app(应用商店)类型广告", expectedResults = "返回结果格式正确", index = 1)
	public void testAdGetApp() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "2");
		g_user.setHttpParam("mainName", "mainName的值");
		g_user.setHttpParam("recType", "app");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.download");
		g_user.setHttpParam("ip", "10.235.228.64");
		g_user.setHttpParam("version", "1");
		g_user.setHttpParam("latitude ", "90");
		g_user.setHttpParam("longitude", "100");
		g_user.setHttpParam("serviceProvider", "cn");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		
		assertNotNull("返回结果为空",result);
		try {
			System.out.println("返回结果decode后 ：" + URLDecoder.decode(result.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] resultKeys = {"result", "s_ab", "params", "items"};
		containKeys(resultKeys, result); //遍历result所有key结构
		JSONArray itemsArray = result.getJSONArray("items");
		JSONObject itemObject = itemsArray.getJSONObject(0);
		String[] itemKeys = {"type", "iconUrl", "title", "des", "actionTitle", "actionUrl", "buttonActionUrl", "extData"};
		containKeys(itemKeys, itemObject); //遍历items所有key结构
		assertTrue("title值为空", !itemObject.getString("title").isEmpty());
		assertTrue("actionTitle值为空", !itemObject.getString("actionTitle").isEmpty());
		assertTrue("actionUrl值为空", !itemObject.getString("actionUrl").isEmpty());
		assertTrue("buttonActionUrl值为空", !itemObject.getString("buttonActionUrl").isEmpty());
	}
	
	@Test(summary = "获取通知栏推荐own(自身来源)的类型广告", expectedResults = "返回格式正确", index = 2)
	public void testAdGetOwn() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "2");
		g_user.setHttpParam("mainName", "mainName的值");
		g_user.setHttpParam("recType", "own");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.download");
		g_user.setHttpParam("ip", "10.235.228.64");
		g_user.setHttpParam("version", "1");
		g_user.setHttpParam("latitude ", "90");
		g_user.setHttpParam("longitude", "100");
		g_user.setHttpParam("serviceProvider", "cn");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		
		assertNotNull("返回结果为空",result);
		try {
			System.out.println("返回结果decode后 ：" + URLDecoder.decode(result.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] resultKeys = {"result", "s_ab", "params", "items"};
		containKeys(resultKeys, result); //遍历result所有key结构
		JSONArray itemsArray = result.getJSONArray("items");
		JSONObject itemObject = itemsArray.getJSONObject(0);
		String[] itemKeys = {"type", "iconUrl", "title", "des", "actionTitle", "actionUrl", "buttonActionUrl", "extData"};
		containKeys(itemKeys, itemObject); //遍历items所有key结构
		assertTrue("title值为空", !itemObject.getString("title").isEmpty());
		assertTrue("actionTitle值为空", !itemObject.getString("actionTitle").isEmpty());
		assertTrue("actionUrl值为空", !itemObject.getString("actionUrl").isEmpty());
		assertTrue("buttonActionUrl值为空", !itemObject.getString("buttonActionUrl").isEmpty());
	}
	
	@Test(summary = "获取通知栏推荐video(小米视频)的类型广告", expectedResults = "返回格式正确", index = 3)
	public void testAdGetVideo() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "2");
		g_user.setHttpParam("mainName", "mainName的值");
		g_user.setHttpParam("recType", "video");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.download");
		g_user.setHttpParam("ip", "10.235.228.64");
		g_user.setHttpParam("version", "1");
		g_user.setHttpParam("latitude ", "90");
		g_user.setHttpParam("longitude", "100");
		g_user.setHttpParam("serviceProvider", "cn");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		
		assertNotNull("返回结果为空",result);
		try {
			System.out.println("返回结果decode后 ：" + URLDecoder.decode(result.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] resultKeys = {"result", "s_ab", "params", "items"};
		containKeys(resultKeys, result); //遍历result所有key结构
		JSONArray itemsArray = result.getJSONArray("items");
		JSONObject itemObject = itemsArray.getJSONObject(0);
		String[] itemKeys = {"type", "iconUrl", "title", "des", "actionTitle", "actionUrl", "buttonActionUrl", "extData"};
		containKeys(itemKeys, itemObject); //遍历items所有key结构
		assertTrue("title值为空", !itemObject.getString("title").isEmpty());
		assertTrue("actionTitle值为空", !itemObject.getString("actionTitle").isEmpty());
		assertTrue("actionUrl值为空", !itemObject.getString("actionUrl").isEmpty());
		assertTrue("buttonActionUrl值为空", !itemObject.getString("buttonActionUrl").isEmpty());
	}
	
	
	@Test(summary = "获取通知栏推荐other(其它)的类型广告", expectedResults = "返回格式正确", index = 4)
	public void testAdGetOther() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "2");
		g_user.setHttpParam("mainName", "mainName的值");
		g_user.setHttpParam("recType", "other");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.download");
		g_user.setHttpParam("ip", "10.235.228.64");
		g_user.setHttpParam("version", "1");
		g_user.setHttpParam("latitude ", "90");
		g_user.setHttpParam("longitude", "100");
		g_user.setHttpParam("serviceProvider", "cn");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		
		assertNotNull("返回结果为空",result);
		try {
			System.out.println("返回结果decode后 ：" + URLDecoder.decode(result.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] resultKeys = {"result", "s_ab", "params", "items"};
		containKeys(resultKeys, result); //遍历result所有key结构
		JSONArray itemsArray = result.getJSONArray("items");
		JSONObject itemObject = itemsArray.getJSONObject(0);
		String[] itemKeys = {"type", "iconUrl", "title", "des", "actionTitle", "actionUrl", "buttonActionUrl", "extData"};
		containKeys(itemKeys, itemObject); //遍历items所有key结构
		assertTrue("title值为空", !itemObject.getString("title").isEmpty());
		assertTrue("actionTitle值为空", !itemObject.getString("actionTitle").isEmpty());
		assertTrue("actionUrl值为空", !itemObject.getString("actionUrl").isEmpty());
		assertTrue("buttonActionUrl值为空", !itemObject.getString("buttonActionUrl").isEmpty());
	}
	
	
	@Test(summary = "获取通知栏推荐game(小米游戏)的类型广告", expectedResults = "返回格式正确", index = 5)
	public void testAdGetGame() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "2");
		g_user.setHttpParam("mainName", "mainName的值");
		g_user.setHttpParam("recType", "game");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.download");
		g_user.setHttpParam("ip", "10.235.228.64");
		g_user.setHttpParam("version", "1");
		g_user.setHttpParam("latitude ", "90");
		g_user.setHttpParam("longitude", "100");
		g_user.setHttpParam("serviceProvider", "cn");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		
		assertNotNull("返回结果为空",result);
		try {
			System.out.println("返回结果decode后 ：" + URLDecoder.decode(result.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] resultKeys = {"result", "s_ab", "params", "items"};
		containKeys(resultKeys, result); //遍历result所有key结构
		JSONArray itemsArray = result.getJSONArray("items");
		JSONObject itemObject = itemsArray.getJSONObject(0);
		String[] itemKeys = {"type", "iconUrl", "title", "des", "actionTitle", "actionUrl", "buttonActionUrl", "extData"};
		containKeys(itemKeys, itemObject); //遍历items所有key结构
		assertTrue("title值为空", !itemObject.getString("title").isEmpty());
		assertTrue("actionTitle值为空", !itemObject.getString("actionTitle").isEmpty());
		assertTrue("actionUrl值为空", !itemObject.getString("actionUrl").isEmpty());
		assertTrue("buttonActionUrl值为空", !itemObject.getString("buttonActionUrl").isEmpty());
	}
	
	@Test(summary = "获取通知栏推荐music(小米音乐)的类型广告", expectedResults = "返回格式正确", index = 6)
	public void testAdGetMusic() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "2");
		g_user.setHttpParam("mainName", "mainName的值");
		g_user.setHttpParam("recType", "music");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.download");
		g_user.setHttpParam("ip", "10.235.228.64");
		g_user.setHttpParam("version", "1");
		g_user.setHttpParam("latitude ", "90");
		g_user.setHttpParam("longitude", "100");
		g_user.setHttpParam("serviceProvider", "cn");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		
		assertNotNull("返回结果为空",result);
		try {
			System.out.println("返回结果decode后 ：" + URLDecoder.decode(result.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] resultKeys = {"result", "s_ab", "params", "items"};
		containKeys(resultKeys, result); //遍历result所有key结构
		JSONArray itemsArray = result.getJSONArray("items");
		JSONObject itemObject = itemsArray.getJSONObject(0);
		String[] itemKeys = {"type", "iconUrl", "title", "des", "actionTitle", "actionUrl", "buttonActionUrl", "extData"};
		containKeys(itemKeys, itemObject); //遍历items所有key结构
		assertTrue("title值为空", !itemObject.getString("title").isEmpty());
		assertTrue("actionTitle值为空", !itemObject.getString("actionTitle").isEmpty());
		assertTrue("actionUrl值为空", !itemObject.getString("actionUrl").isEmpty());
		assertTrue("buttonActionUrl值为空", !itemObject.getString("buttonActionUrl").isEmpty());
	}
	
	private void containKeys(String[] keys, JSONObject json) {
		for(String key : keys) {
			assertTrue("缺少" + key +  "字段", json.containsKey(key));
		}
	}
	
	
	@Ignore ("先不用这个")
	@Test(summary = "获取下载详情页app类型推荐广告", expectedResults = "返回结果格式正确", index = 2)
	public void testAdGet2() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "3");
		g_user.setHttpParam("mainName", "com.android.providers.downloads");
		g_user.setHttpParam("recType", "app");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.providers.downloads");
		g_user.setHttpParam("ip", "106.39.75.131");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertTrue("s_ab内容为空", result.getString("s_ab").length() > 0);
		assertTrue("缺少params字段", result.containsKey("params"));
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("id错误", itemObject.getInt("id") != 0);
			assertTrue("packageName错误", itemObject.getString("packageName")
					.length() > 0);
			assertTrue("title错误", itemObject.getString("title")
					.length() > 0);
			assertTrue("actionUrl错误", itemObject.getString("actionUrl")
					.length() > 0);
			assertTrue("appRatingScore错误", itemObject.getInt("appRatingScore") != 0);
			assertTrue("appId错误", itemObject.getInt("appId") != 0);
			assertTrue("iconUrl错误", itemObject.getString("iconUrl")
					.length() > 0);
			assertTrue("缺少categoryName字段", itemObject.containsKey("categoryName"));
			assertTrue("缺少apkSize字段", itemObject.containsKey("apkSize"));
			assertTrue("缺少price字段", itemObject.containsKey("price"));
			assertTrue("AD id错误", itemObject.getInt("adId") != 0);
			assertTrue("AD Channel错误", itemObject.getInt("adChannel") != 0);
			assertTrue("缺少md5字段", itemObject.containsKey("md5"));
			assertTrue("缺少extData字段", itemObject.containsKey("extData"));
		}
	}
}
