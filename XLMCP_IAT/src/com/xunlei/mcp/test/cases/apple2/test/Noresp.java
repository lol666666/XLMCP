package com.xunlei.mcp.test.cases.apple2.test;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Noresp extends BaseCase{
	@Test(summary = "无返回值测试专用", expectedResults = "测试成功", index = 1)
	public void testNoresp() {
		JSONObject result = g_user.postJsonResp(Constant.TEST_NORESP);
		assertNotNull(result);
	}
}
