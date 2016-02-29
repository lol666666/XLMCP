package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class ReportSpam extends BaseCase {
	@Test(summary = "举报小视频", expectedResults = "返回结果code=0", index = 1)
	public void testReportSpam() {
		g_user.setHttpParam("gcid", "c7fd15307a64551c2a902a15f5c83627bc53a7ee");
		g_user.setHttpParam("reason", "Test Reason");
		g_user.setHttpParam("memo", "memo");
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("code"));
	}
}
