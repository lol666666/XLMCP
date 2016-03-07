package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class GetVideoDirs extends BaseCase {
	@Test(summary = "获取小视频目录", expectedResults = "返回结果格式正确", index = 1)
	public void testGetVideoDirs() {
		JSONObject result = g_user.postJsonResp(Constant.FILE_GETVIDEODIRS);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		assertEquals("配置项数量错误", 4, dataArray.size());
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("key错误", !dataObject.getString("key").isEmpty());
			assertTrue("value错误", !dataObject.getString("value").isEmpty());
			assertTrue("timestamp错误", dataObject.getLong("timestamp") > 0);
		}
	}
}
