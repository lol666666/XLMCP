package com.xunlei.mcp.test.cases.apple2.expression;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Count extends BaseCase {
	@Test(summary = "对指定表情组进行下载", expectedResults = "下载成功", index = 1)
	public void testCount_Download() {
		g_user.setHttpParam("id", "100");
		g_user.setHttpParam("type", "1");
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_COUNT);
		assertNotNull("返回结果为空", result);
		assertEquals("下载失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "对指定表情组进行使用", expectedResults = "使用成功", index = 2)
	public void testCount_Use() {
		g_user.setHttpParam("id", "100");
		g_user.setHttpParam("type", "2");
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_COUNT);
		assertNotNull("返回结果为空", result);
		assertEquals("下载失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "对指定表情组进行点赞", expectedResults = "点赞成功", index = 3)
	public void testCount_Praise() {
		g_user.setHttpParam("id", "100");
		g_user.setHttpParam("type", "3");
		JSONObject result = g_user.postJsonResp(Constant.EXPRESSION_COUNT);
		assertNotNull("返回结果为空", result);
		assertEquals("下载失败", 0, result.getInt("result"));
	}
}
