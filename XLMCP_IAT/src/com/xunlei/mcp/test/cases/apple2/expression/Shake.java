package com.xunlei.mcp.test.cases.apple2.expression;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Shake extends BaseCase {
	@Test(summary = "表情组摇一摇", expectedResults = "返回结果格式正确", index = 1)
	public void testShake() {
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_SHAKE);
		assertNotNull("返回结果为空", result);
		JSONArray expressionArray = result.getJSONArray("expression");
		assertTrue("表情列表为空", expressionArray.size() > 0);
		for (int i = 0; i < expressionArray.size(); i++) {
			JSONObject expressionObject = expressionArray.getJSONObject(i);
			assertTrue("表情ID错误", expressionObject.getInt("id") > 0);
			assertTrue("表情链接错误", !expressionObject.getString("img").isEmpty());
			assertTrue("表情类型错误", expressionObject.getInt("type") > 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=1", expectedResults = "返回结果无异常", index = 2)
	public void testShake_Stat1() {
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_SHAKE);
		assertNotNull("返回结果为空", result);
		JSONArray expressionArray = result.getJSONArray("expression");
		assertTrue("表情列表为空", expressionArray.size() > 0);
		for (int i = 0; i < expressionArray.size(); i++) {
			JSONObject expressionObject = expressionArray.getJSONObject(i);
			assertTrue("表情ID错误", expressionObject.getInt("id") > 0);
			assertTrue("表情链接错误", !expressionObject.getString("img").isEmpty());
			assertTrue("表情类型错误", expressionObject.getInt("type") > 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=2", expectedResults = "返回结果无异常", index = 3)
	public void testShake_Stat2() {
		g_user.setHttpParam("portalStyle", "2");
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_SHAKE);
		assertNotNull("返回结果为空", result);
		JSONArray expressionArray = result.getJSONArray("expression");
		assertTrue("表情列表为空", expressionArray.size() > 0);
		for (int i = 0; i < expressionArray.size(); i++) {
			JSONObject expressionObject = expressionArray.getJSONObject(i);
			assertTrue("表情ID错误", expressionObject.getInt("id") > 0);
			assertTrue("表情链接错误", !expressionObject.getString("img").isEmpty());
			assertTrue("表情类型错误", expressionObject.getInt("type") > 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=3", expectedResults = "返回结果无异常", index = 3)
	public void testShake_Stat3() {
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_SHAKE);
		assertNotNull("返回结果为空", result);
		JSONArray expressionArray = result.getJSONArray("expression");
		assertTrue("表情列表为空", expressionArray.size() > 0);
		for (int i = 0; i < expressionArray.size(); i++) {
			JSONObject expressionObject = expressionArray.getJSONObject(i);
			assertTrue("表情ID错误", expressionObject.getInt("id") > 0);
			assertTrue("表情链接错误", !expressionObject.getString("img").isEmpty());
			assertTrue("表情类型错误", expressionObject.getInt("type") > 0);
		}
	}
}
