package com.xunlei.mcp.test.cases.apple1.sniffer.hotword;

import static org.junit.Assert.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class HotwordGet extends BaseCase{
	@Test(summary = "获取电影类型热词", expectedResults = "返回结果格式正确", index = 1)
	public void testReciGet_Movie() {
		g_user.setHttpParam("tab", "movie");
		JSONObject result = g_user.postJsonResp(Constant.SNIFFER_HOTWORD_GET);
		assertNotNull("返回结果为空",result);
		JSONArray reciArray = result.getJSONArray("allreci");
		assertTrue("热词列表为空", reciArray.size() > 0);
		for (int i = 0; i < reciArray.size(); i++) {
			JSONObject reciObject = reciArray.getJSONObject(i);
			assertTrue("title为空", reciObject.getString("title").length() > 0);
			assertTrue("count错误", reciObject.getInt("count") > 0);
			assertTrue("hotflag错误", reciObject.getInt("hotflag") >= 0);
		}
	}
}
