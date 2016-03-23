package com.xunlei.mcp.test.cases.apple2.configure;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Get extends BaseCase {
	@Test(summary = "获取云控配置", expectedResults = "返回结果格式正确", index = 1)
	public void testConfigGet() {
		String guid = DigestUtils.md5Hex(g_user.imei) + "10";
		
		g_user.setHttpParam("guid", guid);
		g_user.setHttpParam("appVersion", "1.7.2");
		System.out.println("IMEI = " + g_user.imei);
		System.out.println("MD5后DeviceID = " + DigestUtils.md5Hex(guid));
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
