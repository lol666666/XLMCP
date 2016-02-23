package com.xunlei.mcp.test.cases.apple2.configure;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Get extends BaseCase{
	@Test(summary = "获取云控配置", expectedResults = "返回结果格式正确", index = 1)
	public void testConfigGet() {
		g_user.setHttpParam("guid", Constant.DEVICE_ID);
		g_user.setHttpParam("appVersion", "1.0");
		JSONObject result = g_user.postJsonResp(Constant.CONFIGURE_GET);
		assertNotNull("返回结果为空",result);
		assertNotNull("缺少data参数", result.getString("data"));
		assertTrue("更新时间戳数值错误", result.getInt("nextUpdateTime") > 0);
	}
}
