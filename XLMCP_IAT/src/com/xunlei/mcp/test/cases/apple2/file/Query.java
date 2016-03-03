package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Query extends BaseCase {
	@Test(summary = "通过gcid获取小视频", expectedResults = "返回结果code=0", index = 1)
	public void testQuery() {
		String gcid = "dbfb6d09e49ed510c967c0f0de88d3bfac1cb427";
		
		g_user.setHttpParam("gcid", gcid);
		JSONObject result = g_user.postJsonResp(Constant.FILE_QUERY);
		assertNotNull("返回结果为空", result);
		assertEquals("gcid错误", gcid, result.getString("gcid"));
		assertTrue("path错误", !result.getString("path").isEmpty());
		assertTrue("totalCount错误", result.getLong("totalCount") >= 0);
		assertTrue("size错误", result.getLong("size") > 0);
		assertTrue("createTime错误", result.getLong("createTime") > 0);
		assertTrue("title错误", !result.getString("title").isEmpty());
		assertTrue("downloadNum错误", result.getLong("downloadNum") >= 0);
		assertTrue("praiseNum错误", result.getLong("praiseNum") >= 0);
		assertTrue("shareNum错误", result.getLong("shareNum") >= 0);
		assertTrue("playNum错误", result.getLong("playNum") >= 0);
		assertTrue("spamNum错误", result.getLong("spamNum") >= 0);
		assertTrue("length错误", result.getLong("length") > 0);
		assertTrue("lastUploadTime错误", result.getLong("lastUploadTime") >= 0);
		assertTrue("issueTime错误", result.getLong("issueTime") >= 0);
		assertTrue("vframeUrl错误", !result.getString("vframeUrl").isEmpty());
		assertTrue("vframe300Url错误", !result.getString("vframe300Url").isEmpty());
		assertTrue("vframe98Url错误", !result.getString("vframe98Url").isEmpty());
		assertTrue("playUrl错误", !result.getString("playUrl").isEmpty());
		assertTrue("userName错误", !result.getString("userName").isEmpty());
		assertTrue("publishType错误", result.getLong("publishType") >= 0);
	}
}
