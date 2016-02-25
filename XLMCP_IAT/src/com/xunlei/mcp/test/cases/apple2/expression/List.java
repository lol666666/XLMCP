package com.xunlei.mcp.test.cases.apple2.expression;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class List extends BaseCase {
	@Test(summary = "获取表情组列表", expectedResults = "返回结果格式正确", index = 1)
	public void testList() {
		g_user.setHttpParam("last_id", "100");
		g_user.setHttpParam("page_size", "10");
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_LIST);
		assertNotNull("返回结果为空", result);
//		JSONArray expressionArray = result.getJSONArray("expression");
//		assertTrue("表情列表为空", expressionArray.size() > 0);
//		for (int i = 0; i < expressionArray.size(); i++) {
//			JSONObject expressionObject = expressionArray.getJSONObject(i);
//			assertTrue("表情ID错误", expressionObject.getInt("id") > 0);
//			assertTrue("表情链接错误", !expressionObject.getString("img").isEmpty());
//			assertTrue("表情类型错误", expressionObject.getInt("type") > 0);
//		}
	}
}
