package com.xunlei.mcp.test.cases.apple1.sniffer.hotword;

import static org.junit.Assert.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class HotwordGet extends BaseCase {
	@Test(summary = "获取所有类型热词", expectedResults = "返回结果格式正确", index = 1)
	public void testReciGet_Movie() {
		g_user.setHttpParam("tab", "teleplay,movie"); // 不传参数，返回所有,样例value可以为
														// movie,teleplay，返回指定类型数据,响应根据数组value顺序
		JSONObject result = g_user.postJsonResp(Constant.SPY_HOTWORD_GET);
		assertNotNull("返回结果为空", result);
		if (result.containsKey("movie")) {
			JSONArray movieArray = result.getJSONArray("movie");
			assertTrue("movie热词列表为空", movieArray.size() > 0);
			assertTrue("movie没有30个", movieArray.size() == 30);
			isValueEmpty(movieArray);
		}
		if (result.containsKey("teleplay")) {
			JSONArray teleArray = result.getJSONArray("teleplay");
			System.out.println("teleplay = " + teleArray.size());
			assertTrue("teleplay列表为空", teleArray.size() > 0);
			assertTrue("teleplay没有30个", teleArray.size() == 30);
			isValueEmpty(teleArray);
		}
		if (result.containsKey("anime")) {
			JSONArray animeArray = result.getJSONArray("anime");
			System.out.println("anime = " + animeArray.size());
			assertTrue("anime热词列表为空", animeArray.size() > 0);
			assertTrue("anime没有30个", animeArray.size() == 30);
			isValueEmpty(animeArray);
		}

		if (result.containsKey("variety")) {
			JSONArray varietyArray = result.getJSONArray("variety");
			System.out.println("variety = " + varietyArray.size());
			assertTrue("variety热词列表为空", varietyArray.size() > 0);
			assertTrue("variety没有30个", varietyArray.size() == 30);
			isValueEmpty(varietyArray);
		}
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
