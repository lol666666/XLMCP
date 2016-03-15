package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class ReportSpam extends BaseCase {
	@Test(summary = "举报小视频", expectedResults = "返回结果code=0", index = 1)
	public void testReportSpam() {
		g_user.setHttpParam("gcid", "884b503a967d7c0c3ee8b3318b5b9fd6f785b3ba");
		g_user.setHttpParam("reason", "Test Reason");
//		g_user.setHttpParam("memo", "memo");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("result"));
	}
}
