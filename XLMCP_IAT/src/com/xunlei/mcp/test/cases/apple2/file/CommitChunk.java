package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;
import com.xunlei.mcp.test.modules.utils.VideoUtils;

public class CommitChunk extends BaseCase{
	@Test(summary = "分chunk上传单个文件(未上传)", expectedResults = "上传失败，返回错误信息", index = 1)
	public void testCommitChunk_New() {
		String path = "res/TestUpload.mp4";
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);

		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);

		g_user.setHttpParam("uploadMethod", "user");
		g_user.setHttpParam("files", files.toString());
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMITCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "fail", dataObject.getString("status"));
		assertTrue("errorMessage错误", !dataObject.getString("errorMessage")
				.isEmpty());
	}
		
	@Test(summary = "分chunk上传单个文件(已上传)", expectedResults = "上传失败，返回错误信息", index = 2)
	public void testCommitChunk_Already() {
		String path = "res/AlreadyUploaded.mp4";
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);

		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);

		g_user.setHttpParam("uploadMethod", "user");
		g_user.setHttpParam("files", files.toString());
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMITCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "fail", dataObject.getString("status"));
		assertTrue("errorMessage错误", !dataObject.getString("errorMessage")
				.isEmpty());
	}
	
	@Test(summary = "添加统计参数portalStyle=1", expectedResults = "返回结果无异常", index = 3)
	public void testCommitChunk_Stat1() {
		String path = "res/AlreadyUploaded.mp4";
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);

		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);

		g_user.setHttpParam("uploadMethod", "user");
		g_user.setHttpParam("files", files.toString());
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMITCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "fail", dataObject.getString("status"));
		assertTrue("errorMessage错误", !dataObject.getString("errorMessage")
				.isEmpty());
	}
	
	@Test(summary = "添加统计参数portalStyle=2", expectedResults = "返回结果无异常", index = 4)
	public void testCommitChunk_Stat2() {
		String path = "res/AlreadyUploaded.mp4";
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);

		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);

		g_user.setHttpParam("uploadMethod", "user");
		g_user.setHttpParam("files", files.toString());
		g_user.setHttpParam("portalStyle", "2");
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMITCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "fail", dataObject.getString("status"));
		assertTrue("errorMessage错误", !dataObject.getString("errorMessage")
				.isEmpty());
	}
	
	@Test(summary = "添加统计参数portalStyle=3", expectedResults = "返回结果无异常", index = 5)
	public void testCommitChunk_Stat3() {
		String path = "res/AlreadyUploaded.mp4";
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);

		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);

		g_user.setHttpParam("uploadMethod", "user");
		g_user.setHttpParam("files", files.toString());
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMITCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "fail", dataObject.getString("status"));
		assertTrue("errorMessage错误", !dataObject.getString("errorMessage")
				.isEmpty());
	}
}
