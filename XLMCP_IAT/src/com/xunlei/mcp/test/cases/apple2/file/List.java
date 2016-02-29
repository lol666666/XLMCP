package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class List extends BaseCase {
	@Test(summary = "获取小视频列表", expectedResults = "返回结果格式正确", index = 1)
	public void testList() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("startKey", "21746963176229888");
		g_user.setHttpParam("orderBy", "asc");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
	}
}
