package com.xunlei.mcp.test.cases.apple2.ad;

import static org.junit.Assert.*;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class GetWeChatFaceAds extends BaseCase{
	@Test(summary = "获取微信表情流广告", expectedResults = "返回结果格式正确", index = 1)
	public void testGetWeChatFaceAds() {
		g_user.setHttpParam("guid", Constant.DEVICE_ID);
		g_user.setHttpParam("body", "0003");
		JSONObject result = g_user.postJsonResp(Constant.AD_GETWECHATFACEADS);
		assertNotNull("返回结果为空",result);
	}
}
