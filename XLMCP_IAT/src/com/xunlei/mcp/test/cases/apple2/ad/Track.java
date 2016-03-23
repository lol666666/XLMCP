package com.xunlei.mcp.test.cases.apple2.ad;

import static org.junit.Assert.*;

import java.util.Date;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Track extends BaseCase{
	String sessionId = String.valueOf(new Date().getTime());
	
	@Test(summary = "推荐广告的用户反馈为直接下载", expectedResults = "返回结果成功", index = 1)
	public void testTrack_Download() {
		g_user.setHttpParam("deviceId", g_user.deviceID);
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("itemId", "com.xunlei.fileexplorer");
		g_user.setHttpParam("type", "direct_download");
		g_user.setHttpParam("sessionId", sessionId);
		JSONObject result = g_user.postJsonResp(Constant.AD_TRACK);
		assertNotNull("返回结果为空",result);
		assertEquals("返回失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "推荐广告的用户反馈为进入详情页", expectedResults = "返回结果成功", index = 2)
	public void testTrack_Detail() {
		g_user.setHttpParam("deviceId", g_user.deviceID);
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("itemId", "com.xunlei.fileexplorer");
		g_user.setHttpParam("type", "open_detail");
		g_user.setHttpParam("sessionId", sessionId);
		JSONObject result = g_user.postJsonResp(Constant.AD_TRACK);
		assertNotNull("返回结果为空",result);
		assertEquals("返回失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "推荐广告的用户反馈为打开应用", expectedResults = "返回结果成功", index = 3)
	public void testTrack_Open() {
		g_user.setHttpParam("deviceId", g_user.deviceID);
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("itemId", "com.xunlei.fileexplorer");
		g_user.setHttpParam("type", "open");
		g_user.setHttpParam("sessionId", sessionId);
		JSONObject result = g_user.postJsonResp(Constant.AD_TRACK);
		assertNotNull("返回结果为空",result);
		assertEquals("返回失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "推荐广告的用户反馈为不喜欢", expectedResults = "返回结果成功", index = 4)
	public void testTrack_Dislike() {
		g_user.setHttpParam("deviceId", g_user.deviceID);
		g_user.setHttpParam("mainName", "com.android.fileexplorer");
		g_user.setHttpParam("itemId", "com.xunlei.fileexplorer");
		g_user.setHttpParam("type", "dislike");
		g_user.setHttpParam("sessionId", sessionId);
		JSONObject result = g_user.postJsonResp(Constant.AD_TRACK);
		assertNotNull("返回结果为空",result);
		assertEquals("返回失败", 0, result.getInt("result"));
	}
}
