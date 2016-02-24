package com.xunlei.mcp.test.cases.apple1.sniffer.hotword;

import static org.junit.Assert.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class HotwordGet extends BaseCase{
	@Test(summary = "获取所有类型热词", expectedResults = "返回结果格式正确", index = 1)
	public void testReciGet_Movie() {
//		g_user.setHttpParam("tab[]", "{movie , teleplay}"); //不传参数，返回所有
		
		JSONObject result = g_user.postJsonResp(Constant.SPY_HOTWORD_GET);
		assertNotNull("返回结果为空",result);
		JSONArray movieArray = result.getJSONArray("movie");
		JSONArray teleArray = result.getJSONArray("teleplay");
		JSONArray animeArray = result.getJSONArray("anime");
		JSONArray varietyArray = result.getJSONArray("variety");
		System.out.println("movieArray = " + movieArray.size());
		System.out.println("teleplay = " + teleArray.size());
		System.out.println("anime = " + animeArray.size());
		System.out.println("variety = " + varietyArray.size());
		assertTrue("热词列表为空", movieArray.size() > 0);
		assertTrue("movie没有40个", movieArray.size() == 40);
		for (int i = 0; i < movieArray.size(); i++) {
			JSONObject reciObject = movieArray.getJSONObject(i);
			assertTrue("title为空", reciObject.getString("title").length() > 0);
			assertTrue("count错误", reciObject.getInt("count") > 0);
			assertTrue("hotflag错误", reciObject.getInt("hotflag") >= 0);
		}
	}
}
