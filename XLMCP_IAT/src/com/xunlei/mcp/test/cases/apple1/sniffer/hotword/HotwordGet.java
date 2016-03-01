package com.xunlei.mcp.test.cases.apple1.sniffer.hotword;

import static org.junit.Assert.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class HotwordGet extends BaseCase {
	@Test(summary = "获取所有类型热词", expectedResults = "返回结果格式正确", index = 1)
	public void testReciGet_all() {
		// g_user.setHttpParam("tab", "teleplay,movie"); // 不传参数，返回所有所有类型
		JSONObject result = g_user.postJsonResp(Constant.SPY_HOTWORD_GET);
		assertNotNull("返回结果为空", result);

		JSONArray movieArray = result.getJSONArray("movie");
		assertTrue("movie热词列表为空", movieArray.size() > 0);
		assertTrue("movie没有30个", movieArray.size() == 30);
		isValueEmpty(movieArray);

		JSONArray teleArray = result.getJSONArray("teleplay");
		assertTrue("teleplay列表为空", teleArray.size() > 0);
		assertTrue("teleplay没有30个", teleArray.size() == 30);
		isValueEmpty(teleArray);

		JSONArray animeArray = result.getJSONArray("anime");
		assertTrue("anime热词列表为空", animeArray.size() > 0);
		assertTrue("anime没有30个", animeArray.size() == 30);
		isValueEmpty(animeArray);

		JSONArray varietyArray = result.getJSONArray("variety");
		assertTrue("variety热词列表为空", varietyArray.size() > 0);
		assertTrue("variety没有30个", varietyArray.size() == 30);
		isValueEmpty(varietyArray);
	}

	@Test(summary = "获取movie类型热词", expectedResults = "返回结果格式正确", index = 2)
	public void testReciGet_movie() {
		g_user.setHttpParam("tab", "movie");
		JSONObject result = g_user.postJsonResp(Constant.SPY_HOTWORD_GET);
		assertNotNull("返回结果为空", result);
		JSONArray movieArray = result.getJSONArray("movie");
		assertTrue("movie热词列表为空", movieArray.size() > 0);
		assertTrue("movie没有30个", movieArray.size() == 30);
		isValueEmpty(movieArray);
	}

	@Test(summary = "获取teleplay类型热词", expectedResults = "返回结果格式正确", index = 3)
	public void testReciGet_teleplay() {
		g_user.setHttpParam("tab", "teleplay");
		JSONObject result = g_user.postJsonResp(Constant.SPY_HOTWORD_GET);
		assertNotNull("返回结果为空", result);
		JSONArray teleplayArray = result.getJSONArray("teleplay");
		assertTrue("teleplay热词列表为空", teleplayArray.size() > 0);
		assertTrue("teleplay没有30个", teleplayArray.size() == 30);
		isValueEmpty(teleplayArray);
	}

	@Test(summary = "获取anime类型热词", expectedResults = "返回结果格式正确", index = 4)
	public void testReciGet_anime() {
		g_user.setHttpParam("tab", "anime");
		JSONObject result = g_user.postJsonResp(Constant.SPY_HOTWORD_GET);
		assertNotNull("返回结果为空", result);
		JSONArray animeArray = result.getJSONArray("anime");
		assertTrue("anime热词列表为空", animeArray.size() > 0);
		assertTrue("anime没有30个", animeArray.size() == 30);
		isValueEmpty(animeArray);
	}

	@Test(summary = "获取variety类型热词", expectedResults = "返回结果格式正确", index = 5)
	public void testReciGet_variety() {
		g_user.setHttpParam("tab", "variety");
		JSONObject result = g_user.postJsonResp(Constant.SPY_HOTWORD_GET);
		assertNotNull("返回结果为空", result);
		JSONArray varietyArray = result.getJSONArray("variety");
		assertTrue("variety热词列表为空", varietyArray.size() > 0);
		assertTrue("variety没有30个", varietyArray.size() == 30);
		isValueEmpty(varietyArray);
	}

	private void isValueEmpty(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject reciObject = jsonArray.getJSONObject(i);
			assertTrue("title为空", reciObject.getString("title").length() > 0);
			assertTrue("count错误", reciObject.getInt("count") > 0);
			assertTrue("hotflag错误", reciObject.getInt("hotflag") >= 0);
		}
	}

}
