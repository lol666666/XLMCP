package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class GetVideoDirs extends BaseCase {
	@Test(summary = "获取小视频目录", expectedResults = "返回结果格式正确", index = 1)
	public void testGetVideoDirs() {
		JSONObject result = g_user.postJsonResp(Constant.FILE_GETVIDEODIRS);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		assertEquals("配置项数量错误", 4, dataArray.size());
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("key错误", !dataObject.getString("key").isEmpty());
			assertTrue("value错误", !dataObject.getString("value").isEmpty());
			assertTrue("timestamp错误", dataObject.getLong("timestamp") > 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=1", expectedResults = "返回结果无异常", index = 2)
	public void testGetVideoDirs_Stat1() {
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_GETVIDEODIRS);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		assertEquals("配置项数量错误", 4, dataArray.size());
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("key错误", !dataObject.getString("key").isEmpty());
			assertTrue("value错误", !dataObject.getString("value").isEmpty());
			assertTrue("timestamp错误", dataObject.getLong("timestamp") > 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=2", expectedResults = "返回结果无异常", index = 3)
	public void testGetVideoDirs_Stat2() {
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_GETVIDEODIRS);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		assertEquals("配置项数量错误", 4, dataArray.size());
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("key错误", !dataObject.getString("key").isEmpty());
			assertTrue("value错误", !dataObject.getString("value").isEmpty());
			assertTrue("timestamp错误", dataObject.getLong("timestamp") > 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=3", expectedResults = "返回结果无异常", index = 4)
	public void testGetVideoDirs_Stat3() {
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.FILE_GETVIDEODIRS);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		assertEquals("配置项数量错误", 4, dataArray.size());
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("key错误", !dataObject.getString("key").isEmpty());
			assertTrue("value错误", !dataObject.getString("value").isEmpty());
			assertTrue("timestamp错误", dataObject.getLong("timestamp") > 0);
		}
	}
}
