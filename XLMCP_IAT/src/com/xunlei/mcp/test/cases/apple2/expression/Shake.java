package com.xunlei.mcp.test.cases.apple2.expression;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Shake extends BaseCase {
	@Test(summary = "表情组摇一摇", expectedResults = "返回结果不为空", index = 1)
	public void testShake() {
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_SHAKE);
		assertNotNull("返回结果为空", result);
	}
}
