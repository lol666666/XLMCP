package com.xunlei.mcp.test.cases.apple2.ad;

import static org.junit.Assert.*;

import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class ADGet extends BaseCase {
	String sessionId = String.valueOf(new Date().getTime());

	@Test(summary = "获取视频推荐广告", expectedResults = "返回结果格式正确", index = 1)
	public void testAdGet1() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "1");
		g_user.setHttpParam("mainName", "packageName");
		g_user.setHttpParam("recType", "shortVideo");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.fileexplorer");
		g_user.setHttpParam("ip", "106.39.75.131");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
	}

	@Test(summary = "获取下载详情页app类型推荐广告", expectedResults = "返回结果格式正确", index = 1)
	public void testAdGet2() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "3");
		g_user.setHttpParam("mainName", "packageName");
		g_user.setHttpParam("recType", "app");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.fileexplorer");
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
