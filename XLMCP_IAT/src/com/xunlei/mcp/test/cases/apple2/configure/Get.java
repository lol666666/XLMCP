package com.xunlei.mcp.test.cases.apple2.configure;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Get extends BaseCase {
	@Test(summary = "获取云控配置", expectedResults = "返回结果格式正确", index = 1)
	public void testConfigGet() {
		g_user.setHttpParam("guid", Constant.DEVICE_ID);
		g_user.setHttpParam("appVersion", "1.0");
		JSONObject result = g_user.postJsonResp(Constant.CONFIGURE_GET);
		assertNotNull("返回结果为空", result);
		String dataString = result.getString("data");
		JSONObject dataObject = JSONObject.fromObject(dataString);
		JSONArray adArray = dataObject.getJSONArray("show_ad");
		for (int i = 0; i < adArray.size(); i++) {
			JSONObject adObject = adArray.getJSONObject(i);
			assertTrue("open_origin为空", !adObject.getString("open_origin")
					.isEmpty());
			assertTrue("miui_type为空", !adObject.get("miui_type").toString()
					.isEmpty());
			assertTrue("network_type为空", !adObject.get("network_type")
					.toString().isEmpty());
		}
		assertTrue("miui_version为空", !dataObject.getString("miui_version")
				.isEmpty());
		assertTrue("show_hot_expression为空",
				!dataObject.getString("show_hot_expression").isEmpty());
		assertTrue("scan_batch_size错误",
				dataObject.getInt("scan_batch_size") > 0);
		assertTrue("scan_video为空", !dataObject.getString("scan_video")
				.isEmpty());
		assertTrue("show_hot_video为空", !dataObject.getString("show_hot_video")
				.isEmpty());
		assertTrue("更新时间戳数值错误", result.getInt("nextUpdateTime") > 0);
	}
}
