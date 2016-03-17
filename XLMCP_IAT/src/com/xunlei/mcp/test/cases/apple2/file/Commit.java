package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;
import com.xunlei.mcp.test.modules.utils.VideoUtils;

public class Commit extends BaseCase{
	@Test(summary = "上传单个文件(未上传)", expectedResults = "上传成功，chunk=0", index = 1)
	public void testCommit_New() {
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
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMIT);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "ok", dataObject.getString("status"));
	}
	
	@Test(summary = "上传单个文件(已上传)", expectedResults = "上传成功，chunk=0", index = 2)
	public void testCommit_Already() {
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
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMIT);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "ok", dataObject.getString("status"));
	}
	
	@Test(summary = "上传两个文件", expectedResults = "上传成功", index = 3)
	public void testCommit_2() {
		String path1 = "res/AlreadyUploaded.mp4";
		String path2 = "res/TestUpload.mp4";
		JSONArray files = new JSONArray();
		
		JSONObject fileObject1 = new JSONObject();
		String gcid1 = VideoUtils.calcGcid(path1);
		fileObject1.put("gcid", gcid1);
		fileObject1.put("path", path1);
		fileObject1.put("size", new File(path1).length());
		fileObject1.put("createTime", new File(path1).lastModified());
		files.add(fileObject1);
		
		JSONObject fileObject2 = new JSONObject();
		String gcid2 = VideoUtils.calcGcid(path2);
		fileObject2.put("gcid", gcid2);
		fileObject2.put("path", path2);
		fileObject2.put("size", new File(path2).length());
		fileObject2.put("createTime", new File(path2).lastModified());
		files.add(fileObject2);

		g_user.setHttpParam("uploadMethod", "user");
		g_user.setHttpParam("files", files.toString());
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMIT);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject1 = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid1, dataObject1.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject1.getInt("chunk"));
		assertEquals("status错误", "ok", dataObject1.getString("status"));
		JSONObject dataObject2 = dataArray.getJSONObject(1);
		assertEquals("gcid错误", gcid2, dataObject2.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject2.getInt("chunk"));
		assertEquals("status错误", "ok", dataObject2.getString("status"));
	}
	
	@Test(summary = "添加统计参数portalStyle=1", expectedResults = "返回结果无异常", index = 4)
	public void testCommit_Stat1() {
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
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMIT);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "ok", dataObject.getString("status"));
	}
	
	@Test(summary = "添加统计参数portalStyle=2", expectedResults = "返回结果无异常", index = 5)
	public void testCommit_Stat2() {
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
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMIT);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "ok", dataObject.getString("status"));
	}
	
	@Test(summary = "添加统计参数portalStyle=3", expectedResults = "返回结果无异常", index = 6)
	public void testCommit_Stat3() {
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
		JSONObject result = g_user.postJsonResp(Constant.FILE_COMMIT);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("chunk错误", 0, dataObject.getInt("chunk"));
		assertEquals("status错误", "ok", dataObject.getString("status"));
	}
}
