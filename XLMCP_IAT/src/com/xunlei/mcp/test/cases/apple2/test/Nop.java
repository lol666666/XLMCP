package com.xunlei.mcp.test.cases.apple2.test;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Nop extends BaseCase{
	@Test(summary = "无参测试专用", expectedResults = "测试成功", index = 1)
	public void testNop() {
		JSONObject result = g_user.postJsonResp(Constant.TEST_NOP);
		assertNotNull(result);
	}
}
