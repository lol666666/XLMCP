package com.xunlei.mcp.test.cases.apple2.ad;

import static org.junit.Assert.*;

import java.util.Date;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Track extends BaseCase{
	String sessionId = String.valueOf(new Date().getTime());
	
	@Test(summary = "推荐广告的用户行为反馈", expectedResults = "返回结果格式正确", index = 1)
	public void testTrack() {
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		g_user.setHttpParam("mainName", "packagename");
		g_user.setHttpParam("itemId", "com.xunlei.fileexplorer");
		g_user.setHttpParam("type", "like");
		g_user.setHttpParam("sessionId", sessionId);
		JSONObject result = g_user.postJsonResp(Constant.AD_TRACK);
		assertNotNull("返回结果为空",result);
	}
}
