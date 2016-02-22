package com.xunlei.mcp.test.cases.apple2.test;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Only1p extends BaseCase{
	@Test(summary = "单一参数测试专用", expectedResults = "测试成功", index = 1)
	public void testOnly1p() {
		g_user.setHttpParam("id", "10000");
		JSONObject result = g_user.postJsonResp(Constant.TEST_ONLY1P);
		assertNotNull(result);
	}
}
