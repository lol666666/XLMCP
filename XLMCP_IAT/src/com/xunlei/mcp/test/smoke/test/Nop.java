package com.xunlei.mcp.test.smoke.test;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;

public class Nop extends BaseCase{
	@Test(summary = "无参测试专用", expectedResults = "测试成功", index = 1)
	public void testNop() {
		JSONObject result = g_user.postJsonResp("test.nop");
		assertNotNull(result);
	}
}
