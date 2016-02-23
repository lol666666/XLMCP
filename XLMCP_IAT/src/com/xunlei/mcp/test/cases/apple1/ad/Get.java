package com.xunlei.mcp.test.cases.apple1.ad;

import static org.junit.Assert.*;

import java.util.Date;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Get extends BaseCase{
	String sessionId = String.valueOf(new Date().getTime());
	
	@Test(summary = "获取通知栏推荐广告", expectedResults = "返回结果格式正确", index = 1)
	public void testAdGet() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("pid", "2");
		g_user.setHttpParam("mainName", "packagename");
		g_user.setHttpParam("recType", "app");
		g_user.setHttpParam("sessionId", sessionId);
		g_user.setHttpParam("timeTick", String.valueOf(new Date().getTime()));
		g_user.setHttpParam("packageName", "com.android.download");
		g_user.setHttpParam("ip", "106.39.75.131");
		JSONObject result = g_user.postJsonResp(Constant.AD_GET);
		assertNotNull("返回结果为空",result);
	}
}
