package com.xunlei.mcp.test.cases.apple2.app;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Init extends BaseCase {
	@Test(summary = "初始化app参数", expectedResults = "初始化成功", index = 1)
	public void testInit() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("version", "0");
		g_user.setHttpParam("product_version", "1.0");
		JSONObject result = g_user.postJsonResp(Constant.APP_INIT);
		assertEquals("初始化失败", 0, result.getInt("code"));
	}
}
