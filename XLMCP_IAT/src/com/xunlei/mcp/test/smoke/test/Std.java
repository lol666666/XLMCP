package com.xunlei.mcp.test.smoke.test;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;

public class Std extends BaseCase{
	@Test(summary = "标准方式测试专用", expectedResults = "测试成功", index = 1)
	public void testStd() {
		g_user.setHttpParam("testId", "1");
		g_user.setHttpParam("userIds", "10000,20000");
		g_user.setHttpParam("testName", "TEST");
		JSONObject result = g_user.postJsonResp("test.std");		
		assertNotNull("返回数据为空", result);
	}
}
