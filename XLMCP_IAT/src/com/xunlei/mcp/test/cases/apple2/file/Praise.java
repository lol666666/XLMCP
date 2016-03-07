package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Praise extends BaseCase {
	@Test(summary = "对小视频第一次点赞", expectedResults = "点赞成功", index = 1)
	public void testPraise_First() {
		String gcid = "d62bc2553bea6d2c43dd471c926e03210ccbf008";
		g_user.setHttpParam("gcid", gcid);
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		JSONObject result = g_user.postJsonResp(Constant.FILE_PRAISE);
		assertNotNull("返回结果为空", result);
		assertEquals("gcid错误", gcid, result.getString("gcid"));
		assertTrue("点赞数错误", result.getInt("praiseNum") > 0);
	}

	@Test(summary = "对小视频再次点赞", expectedResults = "返回结果为0", index = 2)
	public void testPraise_Again() {
		String gcid = "8f51802c7bbd9aef12d978433a89ee704a83d6e6";
		g_user.setHttpParam("gcid", gcid);
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		JSONObject result = g_user.postJsonResp(Constant.FILE_PRAISE);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞数错误", 0, result.getInt("praiseNum"));
	}
}
