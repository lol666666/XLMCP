package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Play extends BaseCase {
	@Test(summary = "播放小视频", expectedResults = "返回结果code=0", index = 1)
	public void testPlay() {
		g_user.setHttpParam("gcid", "b19313858690554868ac34ea3bc36430b2601113");
		g_user.setHttpParam("deviceId", Constant.DEVICE_ID);
		JSONObject result = g_user.postJsonResp(Constant.FILE_PLAY);
		assertNotNull("返回结果为空", result);
		assertEquals("播放错误", 0, result.getInt("result"));
	}
}
