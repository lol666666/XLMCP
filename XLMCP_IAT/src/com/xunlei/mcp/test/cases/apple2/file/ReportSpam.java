package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class ReportSpam extends BaseCase {
	@Test(summary = "举报小视频", expectedResults = "返回结果code=0", index = 1)
	public void testReportSpam() {
		g_user.setHttpParam("gcid", "d4ec900fd559062f54b0dba0bc5b4a42062ee816");
		g_user.setHttpParam("reason", "Test Reason");
		g_user.setHttpParam("memo", "memo");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("result"));
	}
}
