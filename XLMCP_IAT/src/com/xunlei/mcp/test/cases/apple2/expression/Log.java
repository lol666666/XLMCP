package com.xunlei.mcp.test.cases.apple2.expression;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Log extends BaseCase {
	@Test(summary = "表情日志", expectedResults = "返回结果格式正确", index = 1)
	public void testLog() {
		JSONObject result = g_user.postJsonResp(Constant.EXP_LOG);
		assertNotNull("返回结果为空", result);
	}
	
	@Test(summary = "添加统计参数portalStyle=1", expectedResults = "返回结果无异常", index = 2)
	public void testLog_Stat1() {
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.EXP_LOG);
		assertNotNull("返回结果为空", result);
	}
	
	@Test(summary = "添加统计参数portalStyle=2", expectedResults = "返回结果无异常", index = 3)
	public void testLog_Stat2() {
		g_user.setHttpParam("portalStyle", "2");
		JSONObject result = g_user.postJsonResp(Constant.EXP_LOG);
		assertNotNull("返回结果为空", result);
	}
	
	@Test(summary = "添加统计参数portalStyle=3", expectedResults = "返回结果无异常", index = 4)
	public void testLog_Stat3() {
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.EXP_LOG);
		assertNotNull("返回结果为空", result);
	}
}
