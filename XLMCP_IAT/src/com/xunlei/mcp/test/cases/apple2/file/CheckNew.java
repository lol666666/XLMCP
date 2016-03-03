package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class CheckNew extends BaseCase {
	@Test(summary = "检查是否有新视频", expectedResults = "返回结果格式正确", index = 1)
	public void testCheckNew() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("startKey", "24964302841578496");
		JSONObject result = g_user.postJsonResp(Constant.FILE_CHECKNEW);
		assertNotNull("返回结果为空", result);
		assertTrue("newNum错误", result.getInt("newNum") >= 0);
	}
	
	@Test(summary = "检查是否有新视频(大于99)", expectedResults = "返回结果为9999", index = 2)
	public void testCheckNew_Num99() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("startKey", "0");
		JSONObject result = g_user.postJsonResp(Constant.FILE_CHECKNEW);
		assertNotNull("返回结果为空", result);
		assertTrue("newNum错误", result.getInt("newNum") == 9999);
	}
}
