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
		g_user.setHttpParam("pid", "4");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "shortVideo");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.fileexplorer");
		g_user.setHttpParam("ip", "106.39.75.131");
		g_user.setHttpParam("version", "0");
		g_user.setHttpParam("ext_adsCount", "1");
		g_user.setHttpParam("ext_template", "2.5");
		g_user.setHttpParam("ext_appVersion", "1.0");
		g_user.setHttpParam("ext_platform", "android");
		g_user.setHttpParam("ext_tagId", "1.23.a.1");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
		assertEquals("广告请求失败", 0000, result.getInt("result"));
		assertTrue("缺少recId字段", result.containsKey("recId"));
		assertTrue("缺少ruleId字段", result.containsKey("ruleId"));
		JSONObject paramsObject = result.getJSONObject("params");
		assertTrue("广告位置错误", paramsObject.getInt("position") > 1);
		JSONArray itemArray = result.getJSONArray("items");
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject itemObject = itemArray.getJSONObject(i);
			assertTrue("id错误", itemObject.getInt("id") != 0);
			assertNotNull("imgUrls错误", itemObject.get("imgUrls"));
			assertTrue("ex错误", itemObject.getString("ex")
					.length() > 0);
			assertTrue("summary错误", itemObject.getString("summary")
					.length() > 0);
			assertTrue("landingPageUrl错误", itemObject.getString("landingPageUrl")
					.length() > 0);
			assertTrue("actionUrl错误", itemObject.getString("actionUrl")
					.length() > 0);
			assertTrue("packageName错误", itemObject.getString("packageName")
					.length() > 0);
			assertTrue("targetType错误", itemObject.getInt("targetType") > 0);
			assertTrue("缺少source字段", itemObject.containsKey("source"));
			assertEquals("tagId错误","1.23.a.1", itemObject.getString("tagId"));
			assertEquals("template错误","2.5", itemObject.getString("template"));
			assertTrue("sequence错误", itemObject.getInt("sequence") >= 0);
		}
	}
	
	@Test(summary = "获取表情推荐广告", expectedResults = "返回结果格式正确", index = 2)
	public void testAdGet2() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "4");
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("recType", "expression");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.fileexplorer");
		g_user.setHttpParam("ip", "106.39.75.131");
		g_user.setHttpParam("version", "0");
		g_user.setHttpParam("ext_adsCount", "1");
		g_user.setHttpParam("ext_template", "2.5");
		g_user.setHttpParam("ext_appVersion", "1.0");
		g_user.setHttpParam("ext_platform", "android");
		g_user.setHttpParam("ext_tagId", "1.23.a.1");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空", result);
	}
}
