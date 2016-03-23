package com.xunlei.mcp.test.cases.apple2.expression;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

/**
 * exp.list，v=1.0
 * 
 */
public class List_v0 extends BaseCase {
	@Test(summary = "获取表情组列表(首次进入)", expectedResults = "返回结果格式正确", index = 1)
	public void testExpList_First() {
		g_user.setHttpParam("lastId", "0");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "refresh");
		g_user.setHttpParam("version", "1.7.1");
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
	
	@Test(summary = "获取表情组列表(下拉刷新)", expectedResults = "返回结果格式正确", index = 2)
	public void testExpList_Refresh() {
		g_user.setHttpParam("lastId", "0");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "refresh");
		g_user.setHttpParam("version", "1.7.1");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "2");
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
	
	@Test(summary = "获取表情组列表(加载更多)", expectedResults = "返回结果格式正确", index = 3)
	public void testExpList_Loadmore() {
		g_user.setHttpParam("lastId", "30");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "loadmore");
		g_user.setHttpParam("version", "1.7.1");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "2");
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
	
	@Test(summary = "主页获取最新表情", expectedResults = "返回结果格式正确", index = 4)
	public void testExpList_Homepage() {
		g_user.setHttpParam("lastId", "1:92_2:-1_3:-1");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "refresh");
		g_user.setHttpParam("version", "1.7.1");
		g_user.setHttpParam("pageName", "homepage");
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
	
	@Test(summary = "添加统计参数portalStyle=1", expectedResults = "返回结果无异常", index = 5)
	public void testExpList_Stat1() {
		g_user.setHttpParam("lastId", "1:92_2:-1_3:-1");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "refresh");
		g_user.setHttpParam("version", "1.7.1");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "1");
		g_user.setHttpParam("portalStyle", "1");
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
	
	@Test(summary = "添加统计参数portalStyle=2", expectedResults = "返回结果无异常", index = 6)
	public void testExpList_Stat2() {
		g_user.setHttpParam("lastId", "1:92_2:-1_3:-1");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "refresh");
		g_user.setHttpParam("version", "1.7.1");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "2");
		g_user.setHttpParam("portalStyle", "2");
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
	
	@Test(summary = "添加统计参数portalStyle=3", expectedResults = "返回结果无异常", index = 7)
	public void testExpList_Stat3() {
		g_user.setHttpParam("lastId", "1:92_2:-1_3:-1");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("type", "loadmore");
		g_user.setHttpParam("version", "1.7.1");
		g_user.setHttpParam("pageName", "expression");
		g_user.setHttpParam("first", "2");
		g_user.setHttpParam("portalStyle", "3");
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
