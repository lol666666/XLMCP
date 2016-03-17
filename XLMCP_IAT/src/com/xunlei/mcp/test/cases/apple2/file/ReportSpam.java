package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class ReportSpam extends BaseCase {
	@Test(summary = "举报小视频", expectedResults = "返回结果code=0", index = 1)
	public void testReportSpam() {
		g_user.setHttpParam("gcid", "c4df986907b277b62c54ab59cb4908aed4f42ed4");
		g_user.setHttpParam("reason", "Test Reason");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "举报小视频(添加备注)", expectedResults = "返回结果code=0", index = 2)
	public void testReportSpam2() {
		g_user.setHttpParam("gcid", "c4df986907b277b62c54ab59cb4908aed4f42ed4");
		g_user.setHttpParam("reason", "Test Reason");
		g_user.setHttpParam("memo", "Test Memo");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "添加统计portalStyle=1", expectedResults = "返回结果无异常", index = 3)
	public void testReportSpam_Stat1() {
		g_user.setHttpParam("gcid", "c4df986907b277b62c54ab59cb4908aed4f42ed4");
		g_user.setHttpParam("reason", "Test Reason");
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "添加统计portalStyle=2", expectedResults = "返回结果无异常", index = 4)
	public void testReportSpam_Stat2() {
		g_user.setHttpParam("gcid", "c4df986907b277b62c54ab59cb4908aed4f42ed4");
		g_user.setHttpParam("reason", "Test Reason");
		g_user.setHttpParam("portalStyle", "2");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "添加统计portalStyle=3", expectedResults = "返回结果无异常", index = 5)
	public void testReportSpam_Stat3() {
		g_user.setHttpParam("gcid", "c4df986907b277b62c54ab59cb4908aed4f42ed4");
		g_user.setHttpParam("reason", "Test Reason");
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REPORTSPAM);
		assertNotNull("返回结果为空", result);
		assertEquals("点赞失败", 0, result.getInt("result"));
	}
}
