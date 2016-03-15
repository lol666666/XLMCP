package com.xunlei.mcp.test.cases.apple2.syncAppDir;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Get extends BaseCase {
	@Test(summary = "获取云控App目录", expectedResults = "返回结果格式正确", index = 1)
	public void testDirGet() {
		g_user.setHttpParam("platform", "android");
		g_user.setHttpParam("channel", "inner");
		g_user.setHttpParam("opVer", "0");
		JSONObject result = g_user.postJsonResp(Constant.SYNCAPPDIR_GET);
		assertNotNull("返回结果为空", result);
		JSONObject resultObject = result.getJSONObject("result");
		JSONArray appsArray = resultObject.getJSONArray("apps");
		for (int i = 0; i < appsArray.size(); i++) {
			JSONObject appsObject = appsArray.getJSONObject(i);
			assertTrue("appId错误", appsObject.getInt("appId") >= 0);
			assertTrue("缺少packageName参数", appsObject.containsKey("packageName"));
			assertTrue("缺少appName参数", appsObject.containsKey("appName"));
			assertTrue("缺少enAppName参数", appsObject.containsKey("enAppName"));
			assertTrue("缺少twAppName参数", appsObject.containsKey("twAppName"));
			assertTrue("缺少appTag参数", appsObject.containsKey("appTag"));
			assertTrue("appIcon错误", !appsObject.getString("appIcon").isEmpty());
			assertTrue("groupName错误", !appsObject.getString("groupName")
					.isEmpty());
		}
		JSONArray appDirsArray = resultObject.getJSONArray("appDirs");
		for (int i = 0; i < appDirsArray.size(); i++) {
			JSONObject appDirsObject = appDirsArray.getJSONObject(i);
			assertTrue("appId错误", appDirsObject.getInt("appId") >= 0);
			assertTrue("dirId错误", appDirsObject.getInt("dirId") >= 0);
			assertTrue("dirName错误", !appDirsObject.getString("dirName")
					.isEmpty());
			assertTrue("dirType错误", appDirsObject.getInt("dirType") >= 0);
			assertTrue("缺少subDirFlag参数",
					appDirsObject.containsKey("subDirFlag"));
			assertTrue("缺少subDirName参数",
					appDirsObject.containsKey("subDirName"));
			assertTrue("缺少directName参数",
					appDirsObject.containsKey("directName"));
			assertTrue("缺少newDirectName参数",
					appDirsObject.containsKey("newDirectName"));
			assertTrue("缺少enDirectName参数",
					appDirsObject.containsKey("enDirectName"));
			assertTrue("缺少twDirectName参数",
					appDirsObject.containsKey("twDirectName"));
			assertTrue("缺少appDirTag参数", appDirsObject.containsKey("appDirTag"));
			assertTrue(
					"state错误",
					appDirsObject.getString("state").equals("enable")
							|| appDirsObject.getString("state").equals(
									"disable"));
			assertTrue("notification错误", appDirsObject
					.getString("notification").equals("enable")
					|| appDirsObject.getString("notification")
							.equals("disable"));
		}
		assertTrue("maxOpver错误", !resultObject.getString("maxOpver").isEmpty());
	}
}
