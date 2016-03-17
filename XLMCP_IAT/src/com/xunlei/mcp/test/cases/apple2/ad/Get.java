package com.xunlei.mcp.test.cases.apple2.ad;

import static org.junit.Assert.*;

import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Get extends BaseCase {
	String sessionId = String.valueOf(new Date().getTime());

	@Test(summary = "获取视频推荐广告（首次进入）", expectedResults = "返回结果格式正确，广告位置5", index = 1)
	public void testAdGet1() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "4");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "shortVideo");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "firstLoad");
		g_user.setHttpParam("ext_page", "1");
		g_user.setHttpParam("ext_appVersion", "1.7.0");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertEquals("recId错误", 0001, result.getInt("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_001_1", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		// 验证广告位置
		assertTrue("广告位置错误", paramsObject.getInt("position") == 5);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("id错误", itemObject.getLong("id") != 0);
			assertNotNull("imgUrls错误", itemObject.get("imgUrls"));
			assertTrue("summary错误", !itemObject.getString("summary").isEmpty());
			assertTrue("landingPageUrl错误",
					!itemObject.getString("landingPageUrl").isEmpty());
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("targetType错误", itemObject.getInt("targetType") > 0);
			assertTrue("缺少source字段", itemObject.containsKey("source"));
			assertEquals("tagId错误", "1.23.a.1", itemObject.getString("tagId"));
			assertEquals("template错误", "2.6", itemObject.getString("template"));
			assertTrue("sequence错误", itemObject.getInt("sequence") >= 0);
		}
	}

	@Test(summary = "获取视频推荐广告（下拉刷新）", expectedResults = "返回结果格式正确，广告位置5-8", index = 2)
	public void testAdGet2() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "4");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "shortVideo");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "refresh");
		g_user.setHttpParam("ext_page", "1");
		g_user.setHttpParam("ext_appVersion", "1.7.0");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertEquals("recId错误", 0001, result.getInt("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_001_1", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", 5 <= position && position <= 8);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("id错误", itemObject.getLong("id") != 0);
			assertNotNull("imgUrls错误", itemObject.get("imgUrls"));
			assertTrue("summary错误", !itemObject.getString("summary").isEmpty());
			assertTrue("landingPageUrl错误",
					!itemObject.getString("landingPageUrl").isEmpty());
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("targetType错误", itemObject.getInt("targetType") > 0);
			assertTrue("缺少source字段", itemObject.containsKey("source"));
			assertEquals("tagId错误", "1.23.a.1", itemObject.getString("tagId"));
			assertEquals("template错误", "2.6", itemObject.getString("template"));
			assertTrue("sequence错误", itemObject.getInt("sequence") >= 0);
		}
	}

	@Test(summary = "获取视频推荐广告（加载更多）", expectedResults = "返回结果格式正确，广告位置9-10", index = 3)
	public void testAdGet3() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "4");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "shortVideo");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "loadMore");
		g_user.setHttpParam("ext_page", "2");
		g_user.setHttpParam("ext_appVersion", "1.0");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertEquals("recId错误", 0001, result.getInt("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_001_1", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", 9 <= position && position <= 10);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("id错误", itemObject.getLong("id") != 0);
			assertNotNull("imgUrls错误", itemObject.get("imgUrls"));
			assertTrue("summary错误", !itemObject.getString("summary").isEmpty());
			assertTrue("landingPageUrl错误",
					!itemObject.getString("landingPageUrl").isEmpty());
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("targetType错误", itemObject.getInt("targetType") > 0);
			assertTrue("缺少source字段", itemObject.containsKey("source"));
			assertEquals("tagId错误", "1.23.a.1", itemObject.getString("tagId"));
			assertEquals("template错误", "2.6", itemObject.getString("template"));
			assertTrue("sequence错误", itemObject.getInt("sequence") >= 0);
		}
	}

	@Test(summary = "获取表情宫格广告（首次进入）", expectedResults = "返回结果格式正确，广告位置2", index = 4)
	public void testAdGet4() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "5");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "emoji");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "firstLoad");
		g_user.setHttpParam("ext_page", "1");
		g_user.setHttpParam("ext_appVersion", "1.7.1");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertTrue("缺少recId字段", result.containsKey("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_000_6", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		assertTrue("title为空", !paramsObject.getString("title").isEmpty());
		assertTrue("shareUser为空", !paramsObject.getString("shareUser")
				.isEmpty());
		assertTrue("des为空", !paramsObject.getString("des").isEmpty());
		assertTrue("缺少ts字段", paramsObject.containsKey("ts"));
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", position == 2);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("title错误", !itemObject.getString("title").isEmpty());
			assertTrue("缺少des字段", itemObject.containsKey("des"));
			assertTrue("缺少bgImage字段", itemObject.containsKey("bgImage"));
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("appId错误", itemObject.getInt("appId") != 0);
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("categoryName错误", !itemObject.getString("categoryName")
					.isEmpty());
			assertTrue("apkSize错误", itemObject.getLong("apkSize") != 0);
			assertTrue("adType错误", itemObject.getLong("adType") >= 0);
			assertTrue("adId错误", itemObject.getInt("adId") != 0);
			assertTrue("缺少md5字段", itemObject.containsKey("md5"));
			assertTrue("缺少extData字段", itemObject.containsKey("extData"));
		}
	}

	@Test(summary = "获取表情宫格广告（下拉刷新）", expectedResults = "返回结果格式正确，广告位置2-5", index = 5)
	public void testAdGet5() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "5");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "emoji");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "refresh");
		g_user.setHttpParam("ext_page", "1");
		g_user.setHttpParam("ext_appVersion", "1.7.1");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertTrue("缺少recId字段", result.containsKey("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_000_6", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		assertTrue("title为空", !paramsObject.getString("title").isEmpty());
		assertTrue("shareUser为空", !paramsObject.getString("shareUser")
				.isEmpty());
		assertTrue("des为空", !paramsObject.getString("des").isEmpty());
		assertTrue("缺少ts字段", paramsObject.containsKey("ts"));
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", 2 <= position && position <= 5);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("title错误", !itemObject.getString("title").isEmpty());
			assertTrue("缺少des字段", itemObject.containsKey("des"));
			assertTrue("缺少bgImage字段", itemObject.containsKey("bgImage"));
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("appId错误", itemObject.getInt("appId") != 0);
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("categoryName错误", !itemObject.getString("categoryName")
					.isEmpty());
			assertTrue("apkSize错误", itemObject.getLong("apkSize") != 0);
			assertTrue("adType错误", itemObject.getLong("adType") >= 0);
			assertTrue("adId错误", itemObject.getInt("adId") != 0);
			assertTrue("缺少md5字段", itemObject.containsKey("md5"));
			assertTrue("缺少extData字段", itemObject.containsKey("extData"));
		}
	}

	@Test(summary = "获取表情宫格广告（加载更多）", expectedResults = "返回结果格式正确，广告位置8-10", index = 6)
	public void testAdGet6() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "5");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "emoji");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "loadMore");
		g_user.setHttpParam("ext_page", "2");
		g_user.setHttpParam("ext_appVersion", "1.7.1");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertTrue("缺少recId字段", result.containsKey("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_000_6", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		assertTrue("title为空", !paramsObject.getString("title").isEmpty());
		assertTrue("shareUser为空", !paramsObject.getString("shareUser")
				.isEmpty());
		assertTrue("des为空", !paramsObject.getString("des").isEmpty());
		assertTrue("缺少ts字段", paramsObject.containsKey("ts"));
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", 8 <= position && position <= 10);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("title错误", !itemObject.getString("title").isEmpty());
			assertTrue("缺少des字段", itemObject.containsKey("des"));
			assertTrue("缺少bgImage字段", itemObject.containsKey("bgImage"));
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("appId错误", itemObject.getInt("appId") != 0);
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("categoryName错误", !itemObject.getString("categoryName")
					.isEmpty());
			assertTrue("apkSize错误", itemObject.getLong("apkSize") != 0);
			assertTrue("adType错误", itemObject.getLong("adType") >= 0);
			assertTrue("adId错误", itemObject.getInt("adId") != 0);
			assertTrue("缺少md5字段", itemObject.containsKey("md5"));
			assertTrue("缺少extData字段", itemObject.containsKey("extData"));
		}
	}

	@Test(summary = "获取表情组插入的单个广告", expectedResults = "返回结果格式正确", index = 7)
	public void testAdGet7() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "6");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "emoji");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "firstLoad");
		g_user.setHttpParam("ext_page", "1");
		g_user.setHttpParam("ext_appVersion", "1.7.1");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertEquals("s_ab错误", "default_000_1", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", position == 2);
		int pos = paramsObject.getInt("pos");
		assertTrue("广告位置错误", pos == 100);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("title错误", !itemObject.getString("title").isEmpty());
			assertTrue("缺少des字段", itemObject.containsKey("des"));
			assertTrue("缺少bgImage字段", itemObject.containsKey("bgImage"));
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("appId错误", itemObject.getInt("appId") != 0);
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("categoryName错误", !itemObject.getString("categoryName")
					.isEmpty());
			assertTrue("apkSize错误", itemObject.getLong("apkSize") != 0);
			assertTrue("adType错误", itemObject.getLong("adType") >= 0);
			assertTrue("adId错误", itemObject.getInt("adId") != 0);
			assertTrue("缺少md5字段", itemObject.containsKey("md5"));
			assertTrue("缺少extData字段", itemObject.containsKey("extData"));
		}
	}
	
	@Test(summary = "获取信息流大图广告", expectedResults = "返回结果格式正确", index = 8)
	public void testAdGet8() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "7");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "emoji");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "firstLoad");
		g_user.setHttpParam("ext_page", "1");
		g_user.setHttpParam("ext_appVersion", "1.7.1");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertTrue("缺少recId字段", result.containsKey("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_000_1", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", position == 2);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("id错误", itemObject.getLong("id") != 0);
			assertNotNull("imgUrls错误", itemObject.get("imgUrls"));
			assertTrue("ex错误", !itemObject.getString("ex").isEmpty());
			assertTrue("summary错误", !itemObject.getString("summary").isEmpty());
			assertTrue("landingPageUrl错误",
					!itemObject.getString("landingPageUrl").isEmpty());
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("targetType错误", itemObject.getInt("targetType") > 0);
			assertTrue("缺少source字段", itemObject.containsKey("source"));
			assertEquals("tagId错误", "1.23.b.1", itemObject.getString("tagId"));
			assertEquals("template错误", "2.6", itemObject.getString("template"));
			assertTrue("sequence错误", itemObject.getInt("sequence") >= 0);
			assertTrue("allDownloadNum错误", itemObject.getInt("allDownloadNum") >= 0);
		}
	}
	
	@Test(summary = "获取信息流小图广告", expectedResults = "返回结果格式正确", index = 9)
	public void testAdGet9() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "8");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "emoji");
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("ext_loadType", "firstLoad");
		g_user.setHttpParam("ext_page", "1");
		g_user.setHttpParam("ext_appVersion", "1.7.1");
		g_user.setHttpParam("ext_platform", "android");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertTrue("缺少recId字段", result.containsKey("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		assertEquals("s_ab错误", "default_000_1", result.getString("s_ab"));
		JSONObject paramsObject = result.getJSONObject("params");
		// 验证广告位置
		int position = paramsObject.getInt("position");
		assertTrue("广告位置错误", position == 2);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("actionUrl错误", !itemObject.getString("actionUrl")
					.isEmpty());
			assertTrue("allDownloadNum错误", itemObject.getInt("allDownloadNum") >= 0);
			assertTrue("ex错误", !itemObject.getString("ex").isEmpty());
			assertTrue("iconUrl错误",
					!itemObject.getString("iconUrl").isEmpty());
			assertTrue("id错误", itemObject.getLong("id") != 0);
			assertTrue("landingPageUrl错误",
					!itemObject.getString("landingPageUrl").isEmpty());	
			assertTrue("packageName错误", !itemObject.getString("packageName")
					.isEmpty());
			assertTrue("sequence错误", itemObject.getInt("sequence") >= 0);
			assertTrue("缺少source字段", itemObject.containsKey("source"));
			assertTrue("summary错误", !itemObject.getString("summary").isEmpty());
			assertEquals("tagId错误", "1.23.b.1", itemObject.getString("tagId"));
			assertTrue("targetType错误", itemObject.getInt("targetType") > 0);
			assertEquals("template错误", "2.4", itemObject.getString("template"));
			assertTrue("title错误", !itemObject.getString("title").isEmpty());
			assertNotNull("imgUrls错误", itemObject.get("imgUrls"));
			assertTrue("缺少extData字段", itemObject.containsKey("extData"));
		}
	}
}
