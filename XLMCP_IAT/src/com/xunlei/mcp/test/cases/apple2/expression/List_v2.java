package com.xunlei.mcp.test.cases.apple2.expression;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

/**
 * exp.list，v=1.2
 * 
 */
public class List_v2 extends BaseCase {
	@Test(summary = "刷新热门表情列表", expectedResults = "返回结果格式正确", index = 1)
	public void testExpList_RefreshHot() {
		g_user.setHttpParam("lastId", "0");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "refresh");
		g_user.setHttpParam("category", "hot");
		g_user.setHttpParam("v", "1.2");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "1");
		JSONObject result = g_user.postJsonResp(Constant.EXP_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject expObject = dataArray.getJSONObject(i);
			assertTrue("id错误", expObject.getInt("id") > 0);
			assertTrue("sharer错误", !expObject.getString("sharer").isEmpty());
			assertTrue("share_time错误", expObject.getLong("share_time") > 0);
			assertTrue("ucount错误", expObject.getInt("ucount") >= 0);
			assertTrue("dcount错误", expObject.getInt("dcount") >= 0);
			assertTrue("gcount错误", expObject.getInt("gcount") >= 0);
			JSONArray shareArray = expObject.getJSONArray("share_expression");
			for (int j = 0; j < shareArray.size(); j++) {
				JSONObject shareObject = shareArray.getJSONObject(j);
				assertTrue("id错误", shareObject.getInt("id") > 0);
				assertTrue("type错误", shareObject.getInt("type") >= 0);
				assertTrue("img错误", !shareObject.getString("img").isEmpty());
			}
		}
		assertTrue("hasNext错误",
				result.getBoolean("hasNext") || !result.getBoolean("hasNext"));
	}

	@Test(summary = "加载更多热门表情列表", expectedResults = "返回结果格式正确", index = 2)
	public void testExpList_LoadHot() {
		g_user.setHttpParam("lastId", "20");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "loadmore");
		g_user.setHttpParam("category", "hot");
		g_user.setHttpParam("v", "1.2");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "1");
		JSONObject result = g_user.postJsonResp(Constant.EXP_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject expObject = dataArray.getJSONObject(i);
			assertTrue("id错误", expObject.getInt("id") > 0);
			assertTrue("sharer错误", !expObject.getString("sharer").isEmpty());
			assertTrue("share_time错误", expObject.getLong("share_time") > 0);
			assertTrue("ucount错误", expObject.getInt("ucount") >= 0);
			assertTrue("dcount错误", expObject.getInt("dcount") >= 0);
			assertTrue("gcount错误", expObject.getInt("gcount") >= 0);
			JSONArray shareArray = expObject.getJSONArray("share_expression");
			for (int j = 0; j < shareArray.size(); j++) {
				JSONObject shareObject = shareArray.getJSONObject(j);
				assertTrue("id错误", shareObject.getInt("id") > 0);
				assertTrue("type错误", shareObject.getInt("type") >= 0);
				assertTrue("img错误", !shareObject.getString("img").isEmpty());
			}
		}
		assertTrue("hasNext错误",
				result.getBoolean("hasNext") || !result.getBoolean("hasNext"));
	}
	
	@Test(summary = "刷新最新表情列表", expectedResults = "返回结果格式正确", index = 3)
	public void testExpList_RefreshNew() {
		g_user.setHttpParam("lastId", "0");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "refresh");
		g_user.setHttpParam("category", "new");
		g_user.setHttpParam("v", "1.2");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "1");
		JSONObject result = g_user.postJsonResp(Constant.EXP_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject expObject = dataArray.getJSONObject(i);
			assertTrue("id错误", expObject.getInt("id") > 0);
			assertTrue("sharer错误", !expObject.getString("sharer").isEmpty());
			assertTrue("share_time错误", expObject.getLong("share_time") > 0);
			assertTrue("ucount错误", expObject.getInt("ucount") >= 0);
			assertTrue("dcount错误", expObject.getInt("dcount") >= 0);
			assertTrue("gcount错误", expObject.getInt("gcount") >= 0);
			JSONArray shareArray = expObject.getJSONArray("share_expression");
			for (int j = 0; j < shareArray.size(); j++) {
				JSONObject shareObject = shareArray.getJSONObject(j);
				assertTrue("id错误", shareObject.getInt("id") > 0);
				assertTrue("type错误", shareObject.getInt("type") >= 0);
				assertTrue("img错误", !shareObject.getString("img").isEmpty());
			}
		}
		assertTrue("hasNext错误",
				result.getBoolean("hasNext") || !result.getBoolean("hasNext"));
	}

	@Test(summary = "加载更多最新表情列表", expectedResults = "返回结果格式正确", index = 4)
	public void testExpList_LoadNew() {
		g_user.setHttpParam("lastId", "50");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "loadmore");
		g_user.setHttpParam("category", "new");
		g_user.setHttpParam("v", "1.2");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "1");
		JSONObject result = g_user.postJsonResp(Constant.EXP_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject expObject = dataArray.getJSONObject(i);
			assertTrue("id错误", expObject.getInt("id") > 0);
			assertTrue("sharer错误", !expObject.getString("sharer").isEmpty());
			assertTrue("share_time错误", expObject.getLong("share_time") > 0);
			assertTrue("ucount错误", expObject.getInt("ucount") >= 0);
			assertTrue("dcount错误", expObject.getInt("dcount") >= 0);
			assertTrue("gcount错误", expObject.getInt("gcount") >= 0);
			JSONArray shareArray = expObject.getJSONArray("share_expression");
			for (int j = 0; j < shareArray.size(); j++) {
				JSONObject shareObject = shareArray.getJSONObject(j);
				assertTrue("id错误", shareObject.getInt("id") > 0);
				assertTrue("type错误", shareObject.getInt("type") >= 0);
				assertTrue("img错误", !shareObject.getString("img").isEmpty());
			}
		}
		assertTrue("hasNext错误",
				result.getBoolean("hasNext") || !result.getBoolean("hasNext"));
	}
}
