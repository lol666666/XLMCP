package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class List extends BaseCase {
	@Test(summary = "获取小视频列表(降序)", expectedResults = "返回结果格式正确", index = 1)
	public void testFileList_Desc() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("orderBy", "desc");
		g_user.setHttpParam("pageName", "video");
		g_user.setHttpParam("first", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("rowkey错误", dataObject.getLong("rowkey") > 0);
			assertTrue("gcid错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("path错误", !dataObject.getString("path").isEmpty());
			assertTrue("totalCount错误", dataObject.getLong("totalCount") >= 0);
			assertTrue("size错误", dataObject.getLong("size") > 0);
			assertTrue("createTime错误", dataObject.getLong("createTime") > 0);
			assertTrue("title错误", !dataObject.getString("title").isEmpty());
			assertTrue("downloadNum错误", dataObject.getLong("downloadNum") >= 0);
			assertTrue("praiseNum错误", dataObject.getLong("praiseNum") >= 0);
			assertTrue("shareNum错误", dataObject.getLong("shareNum") >= 0);
			assertTrue("playNum错误", dataObject.getLong("playNum") >= 0);
			assertTrue("spamNum错误", dataObject.getLong("spamNum") >= 0);
			assertTrue("length错误", dataObject.getLong("length") > 0);
			assertTrue("lastUploadTime错误", dataObject.getLong("lastUploadTime") >= 0);
			assertTrue("issueTime错误", dataObject.getLong("issueTime") >= 0);
			assertTrue("vframeUrl错误", !dataObject.getString("vframeUrl").isEmpty());
			assertTrue("vframe300Url错误", !dataObject.getString("vframe300Url").isEmpty());
			assertTrue("vframe98Url错误", !dataObject.getString("vframe98Url").isEmpty());
			assertTrue("playUrl错误", !dataObject.getString("playUrl").isEmpty());
			assertTrue("userName错误", !dataObject.getString("userName").isEmpty());
			assertTrue("publishType错误", dataObject.getLong("publishType") >= 0);
		}
	}
	
	@Test(summary = "获取小视频列表(升序)", expectedResults = "返回结果格式正确", index = 2)
	public void testFileList_Asc() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("orderBy", "asc");
		g_user.setHttpParam("pageName", "video");
		g_user.setHttpParam("first", "2");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("rowkey错误", dataObject.getLong("rowkey") > 0);
			assertTrue("gcid错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("path错误", !dataObject.getString("path").isEmpty());
			assertTrue("totalCount错误", dataObject.getLong("totalCount") >= 0);
			assertTrue("size错误", dataObject.getLong("size") > 0);
			assertTrue("createTime错误", dataObject.getLong("createTime") > 0);
			assertTrue("title错误", !dataObject.getString("title").isEmpty());
			assertTrue("downloadNum错误", dataObject.getLong("downloadNum") >= 0);
			assertTrue("praiseNum错误", dataObject.getLong("praiseNum") >= 0);
			assertTrue("shareNum错误", dataObject.getLong("shareNum") >= 0);
			assertTrue("playNum错误", dataObject.getLong("playNum") >= 0);
			assertTrue("spamNum错误", dataObject.getLong("spamNum") >= 0);
			assertTrue("length错误", dataObject.getLong("length") > 0);
			assertTrue("lastUploadTime错误", dataObject.getLong("lastUploadTime") >= 0);
			assertTrue("issueTime错误", dataObject.getLong("issueTime") >= 0);
			assertTrue("vframeUrl错误", !dataObject.getString("vframeUrl").isEmpty());
			assertTrue("vframe300Url错误", !dataObject.getString("vframe300Url").isEmpty());
			assertTrue("vframe98Url错误", !dataObject.getString("vframe98Url").isEmpty());
			assertTrue("playUrl错误", !dataObject.getString("playUrl").isEmpty());
			assertTrue("userName错误", !dataObject.getString("userName").isEmpty());
			assertTrue("publishType错误", dataObject.getLong("publishType") >= 0);
		}
	}
	
	@Test(summary = "主页获取最新视频", expectedResults = "返回结果格式正确", index = 3)
	public void testFileList_Homepage() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("orderBy", "desc");
		g_user.setHttpParam("pageName", "homepage");
		g_user.setHttpParam("first", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("rowkey错误", dataObject.getLong("rowkey") > 0);
			assertTrue("gcid错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("path错误", !dataObject.getString("path").isEmpty());
			assertTrue("totalCount错误", dataObject.getLong("totalCount") >= 0);
			assertTrue("size错误", dataObject.getLong("size") > 0);
			assertTrue("createTime错误", dataObject.getLong("createTime") > 0);
			assertTrue("title错误", !dataObject.getString("title").isEmpty());
			assertTrue("downloadNum错误", dataObject.getLong("downloadNum") >= 0);
			assertTrue("praiseNum错误", dataObject.getLong("praiseNum") >= 0);
			assertTrue("shareNum错误", dataObject.getLong("shareNum") >= 0);
			assertTrue("playNum错误", dataObject.getLong("playNum") >= 0);
			assertTrue("spamNum错误", dataObject.getLong("spamNum") >= 0);
			assertTrue("length错误", dataObject.getLong("length") > 0);
			assertTrue("lastUploadTime错误", dataObject.getLong("lastUploadTime") >= 0);
			assertTrue("issueTime错误", dataObject.getLong("issueTime") >= 0);
			assertTrue("vframeUrl错误", !dataObject.getString("vframeUrl").isEmpty());
			assertTrue("vframe300Url错误", !dataObject.getString("vframe300Url").isEmpty());
			assertTrue("vframe98Url错误", !dataObject.getString("vframe98Url").isEmpty());
			assertTrue("playUrl错误", !dataObject.getString("playUrl").isEmpty());
			assertTrue("userName错误", !dataObject.getString("userName").isEmpty());
			assertTrue("publishType错误", dataObject.getLong("publishType") >= 0);
		}
	}
	
	@Test(summary = "获取热门小视频列表", expectedResults = "返回结果格式正确", index = 4)
	public void testFileList_Hot() {
		g_user.setHttpParam("category", "hot");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("orderBy", "desc");
		g_user.setHttpParam("pageName", "video");
		g_user.setHttpParam("first", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("rowkey错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("gcid错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("path错误", !dataObject.getString("path").isEmpty());
			assertTrue("totalCount错误", dataObject.getLong("totalCount") >= 0);
			assertTrue("size错误", dataObject.getLong("size") > 0);
			assertTrue("createTime错误", dataObject.getLong("createTime") > 0);
			assertTrue("title错误", !dataObject.getString("title").isEmpty());
			assertTrue("downloadNum错误", dataObject.getLong("downloadNum") >= 0);
			assertTrue("praiseNum错误", dataObject.getLong("praiseNum") >= 0);
			assertTrue("shareNum错误", dataObject.getLong("shareNum") >= 0);
			assertTrue("playNum错误", dataObject.getLong("playNum") >= 0);
			assertTrue("spamNum错误", dataObject.getLong("spamNum") >= 0);
			assertTrue("length错误", dataObject.getLong("length") > 0);
			assertTrue("lastUploadTime错误", dataObject.getLong("lastUploadTime") >= 0);
			assertTrue("issueTime错误", dataObject.getLong("issueTime") >= 0);
			assertTrue("vframeUrl错误", !dataObject.getString("vframeUrl").isEmpty());
			assertTrue("vframe300Url错误", !dataObject.getString("vframe300Url").isEmpty());
			assertTrue("vframe98Url错误", !dataObject.getString("vframe98Url").isEmpty());
			assertTrue("playUrl错误", !dataObject.getString("playUrl").isEmpty());
			assertTrue("userName错误", !dataObject.getString("userName").isEmpty());
			assertTrue("publishType错误", dataObject.getLong("publishType") >= 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=1", expectedResults = "返回结果无异常", index = 5)
	public void testFileList_Stat1() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("orderBy", "desc");
		g_user.setHttpParam("pageName", "video");
		g_user.setHttpParam("first", "1");
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("rowkey错误", dataObject.getLong("rowkey") > 0);
			assertTrue("gcid错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("path错误", !dataObject.getString("path").isEmpty());
			assertTrue("totalCount错误", dataObject.getLong("totalCount") >= 0);
			assertTrue("size错误", dataObject.getLong("size") > 0);
			assertTrue("createTime错误", dataObject.getLong("createTime") > 0);
			assertTrue("title错误", !dataObject.getString("title").isEmpty());
			assertTrue("downloadNum错误", dataObject.getLong("downloadNum") >= 0);
			assertTrue("praiseNum错误", dataObject.getLong("praiseNum") >= 0);
			assertTrue("shareNum错误", dataObject.getLong("shareNum") >= 0);
			assertTrue("playNum错误", dataObject.getLong("playNum") >= 0);
			assertTrue("spamNum错误", dataObject.getLong("spamNum") >= 0);
			assertTrue("length错误", dataObject.getLong("length") > 0);
			assertTrue("lastUploadTime错误", dataObject.getLong("lastUploadTime") >= 0);
			assertTrue("issueTime错误", dataObject.getLong("issueTime") >= 0);
			assertTrue("vframeUrl错误", !dataObject.getString("vframeUrl").isEmpty());
			assertTrue("vframe300Url错误", !dataObject.getString("vframe300Url").isEmpty());
			assertTrue("vframe98Url错误", !dataObject.getString("vframe98Url").isEmpty());
			assertTrue("playUrl错误", !dataObject.getString("playUrl").isEmpty());
			assertTrue("userName错误", !dataObject.getString("userName").isEmpty());
			assertTrue("publishType错误", dataObject.getLong("publishType") >= 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=2", expectedResults = "返回结果无异常", index = 6)
	public void testFileList_Stat2() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("orderBy", "desc");
		g_user.setHttpParam("pageName", "video");
		g_user.setHttpParam("first", "2");
		g_user.setHttpParam("portalStyle", "2");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("rowkey错误", dataObject.getLong("rowkey") > 0);
			assertTrue("gcid错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("path错误", !dataObject.getString("path").isEmpty());
			assertTrue("totalCount错误", dataObject.getLong("totalCount") >= 0);
			assertTrue("size错误", dataObject.getLong("size") > 0);
			assertTrue("createTime错误", dataObject.getLong("createTime") > 0);
			assertTrue("title错误", !dataObject.getString("title").isEmpty());
			assertTrue("downloadNum错误", dataObject.getLong("downloadNum") >= 0);
			assertTrue("praiseNum错误", dataObject.getLong("praiseNum") >= 0);
			assertTrue("shareNum错误", dataObject.getLong("shareNum") >= 0);
			assertTrue("playNum错误", dataObject.getLong("playNum") >= 0);
			assertTrue("spamNum错误", dataObject.getLong("spamNum") >= 0);
			assertTrue("length错误", dataObject.getLong("length") > 0);
			assertTrue("lastUploadTime错误", dataObject.getLong("lastUploadTime") >= 0);
			assertTrue("issueTime错误", dataObject.getLong("issueTime") >= 0);
			assertTrue("vframeUrl错误", !dataObject.getString("vframeUrl").isEmpty());
			assertTrue("vframe300Url错误", !dataObject.getString("vframe300Url").isEmpty());
			assertTrue("vframe98Url错误", !dataObject.getString("vframe98Url").isEmpty());
			assertTrue("playUrl错误", !dataObject.getString("playUrl").isEmpty());
			assertTrue("userName错误", !dataObject.getString("userName").isEmpty());
			assertTrue("publishType错误", dataObject.getLong("publishType") >= 0);
		}
	}
	
	@Test(summary = "添加统计portalStyle=3", expectedResults = "返回结果无异常", index = 7)
	public void testFileList_Stat3() {
		g_user.setHttpParam("category", "weichat");
		g_user.setHttpParam("pageSize", "10");
		g_user.setHttpParam("orderBy", "desc");
		g_user.setHttpParam("pageName", "homepage");
		g_user.setHttpParam("first", "2");
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.FILE_LIST);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			assertTrue("rowkey错误", dataObject.getLong("rowkey") > 0);
			assertTrue("gcid错误", !dataObject.getString("gcid").isEmpty());
			assertTrue("path错误", !dataObject.getString("path").isEmpty());
			assertTrue("totalCount错误", dataObject.getLong("totalCount") >= 0);
			assertTrue("size错误", dataObject.getLong("size") > 0);
			assertTrue("createTime错误", dataObject.getLong("createTime") > 0);
			assertTrue("title错误", !dataObject.getString("title").isEmpty());
			assertTrue("downloadNum错误", dataObject.getLong("downloadNum") >= 0);
			assertTrue("praiseNum错误", dataObject.getLong("praiseNum") >= 0);
			assertTrue("shareNum错误", dataObject.getLong("shareNum") >= 0);
			assertTrue("playNum错误", dataObject.getLong("playNum") >= 0);
			assertTrue("spamNum错误", dataObject.getLong("spamNum") >= 0);
			assertTrue("length错误", dataObject.getLong("length") > 0);
			assertTrue("lastUploadTime错误", dataObject.getLong("lastUploadTime") >= 0);
			assertTrue("issueTime错误", dataObject.getLong("issueTime") >= 0);
			assertTrue("vframeUrl错误", !dataObject.getString("vframeUrl").isEmpty());
			assertTrue("vframe300Url错误", !dataObject.getString("vframe300Url").isEmpty());
			assertTrue("vframe98Url错误", !dataObject.getString("vframe98Url").isEmpty());
			assertTrue("playUrl错误", !dataObject.getString("playUrl").isEmpty());
			assertTrue("userName错误", !dataObject.getString("userName").isEmpty());
			assertTrue("publishType错误", dataObject.getLong("publishType") >= 0);
		}
	}
}
