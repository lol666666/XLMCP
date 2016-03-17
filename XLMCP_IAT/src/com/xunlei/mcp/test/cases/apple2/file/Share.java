package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Share extends BaseCase {
	@Test(summary = "分享小视频", expectedResults = "返回结果code=0", index = 1)
	public void testShare() {
		String gcid = "fba58da370e1a02e9d3444a6afecc217a11e63e3";

		g_user.setHttpParam("gcid", gcid);
		JSONObject result = g_user.postJsonResp(Constant.FILE_SHARE);
		assertNotNull("返回结果为空", result);
		assertEquals("gcid错误", gcid, result.getString("gcid"));
		assertTrue("点赞数错误", result.getInt("shareNum") > 0);
	}

	@Test(summary = "添加统计portalStyle=1", expectedResults = "返回结果无异常", index = 2)
	public void testShare_Stat1() {
		g_user.setHttpParam("gcid", "fba58da370e1a02e9d3444a6afecc217a11e63e3");
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_SHARE);
		assertNotNull("返回结果为空", result);
		assertEquals("gcid错误", "fba58da370e1a02e9d3444a6afecc217a11e63e3",
				result.getString("gcid"));
		assertTrue("点赞数错误", result.getInt("shareNum") > 0);
	}

	@Test(summary = "添加统计portalStyle=2", expectedResults = "返回结果无异常", index = 3)
	public void testShare_Stat2() {
		g_user.setHttpParam("gcid", "fba58da370e1a02e9d3444a6afecc217a11e63e3");
		g_user.setHttpParam("portalStyle", "2");
		JSONObject result = g_user.postJsonResp(Constant.FILE_SHARE);
		assertNotNull("返回结果为空", result);
		assertEquals("gcid错误", "fba58da370e1a02e9d3444a6afecc217a11e63e3",
				result.getString("gcid"));
		assertTrue("点赞数错误", result.getInt("shareNum") > 0);
	}

	@Test(summary = "添加统计portalStyle=2", expectedResults = "返回结果无异常", index = 4)
	public void testShare_Stat3() {
		g_user.setHttpParam("gcid", "fba58da370e1a02e9d3444a6afecc217a11e63e3");
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.FILE_SHARE);
		assertNotNull("返回结果为空", result);
		assertEquals("gcid错误", "fba58da370e1a02e9d3444a6afecc217a11e63e3",
				result.getString("gcid"));
		assertTrue("点赞数错误", result.getInt("shareNum") > 0);
	}
}
