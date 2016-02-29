package com.xunlei.mcp.test.cases.apple2.ad;

import static org.junit.Assert.*;

import java.util.Date;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class GetWeChatFaceAds extends BaseCase {
	String sessionId = String.valueOf(new Date().getTime());
	
	@Test(summary = "获取微信表情流广告", expectedResults = "返回结果格式正确", index = 1)
	public void testGetWeChatFaceAds() {
		g_user.setHttpParam("guid", Constant.DEVICE_ID);
		JSONObject body = new JSONObject();
		body.put("guid", Constant.DEVICE_ID);
		body.put("adRule", 16);
		body.put("recId", "0");
		body.put("algId", "000");
		body.put("mainName", "com.android.fileexplorer");
		body.put("recType", "emoji");
		body.put("businessLine", "0003");
		body.put("sessionId", sessionId);
		body.put("timeTick", String.valueOf(System.currentTimeMillis()));
		body.put("version", 1);
		JSONObject params = new JSONObject();
		params.put("latitude", "");
		params.put("longitude", "");
		params.put("clientInfo","{}");
		body.put("params", params);
		g_user.setHttpParam("body", body.toString());
		JSONObject result = g_user.postJsonResp(Constant.AD_GETWECHATFACEADS);
		assertNotNull("返回结果为空", result);
	}
}
