package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;

import java.io.File;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;
import com.xunlei.mcp.test.modules.utils.VideoUtils;

public class RequestUploadChunk extends BaseCase {
	@Test(summary = "获取单个文件上传chunk(未上传)", expectedResults = "不需要上传(未达到次数)", index = 1)
	public void testRequestChunk_New() {
		String path = "res/TestUpload.mp4"; 
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);
		
		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);
		
		g_user.setHttpParam("uploadMethod", "sdk");
		g_user.setHttpParam("files", files.toString());
		JSONObject result = g_user.postJsonResp(Constant.FILE_REQUESTUPLOADCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("status错误", "notRequireUpload",
				dataObject.getString("status"));
		assertEquals("chunkNum错误", 0, dataObject.getInt("chunkNum"));
	}
	
	@Test(summary = "获取单个文件上传chunk(已上传)", expectedResults = "已上传，chunk=0", index = 2)
	public void testRequestChunk_Already() {
		String path = "res/AlreadyUploaded.mp4"; 
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);
		
		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);
		
		g_user.setHttpParam("uploadMethod", "sdk");
		g_user.setHttpParam("files", files.toString());
		JSONObject result = g_user.postJsonResp(Constant.FILE_REQUESTUPLOADCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("status错误", "uploaded", dataObject.getString("status"));
		assertEquals("chunkNum错误", 0, dataObject.getInt("chunkNum"));
	}
	
	@Test(summary = "添加统计参数portalStyle=1", expectedResults = "返回结果无异常", index = 3)
	public void testRequestChunk_Stat1() {
		String path = "res/AlreadyUploaded.mp4"; 
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);
		
		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);
		
		g_user.setHttpParam("uploadMethod", "sdk");
		g_user.setHttpParam("files", files.toString());
		g_user.setHttpParam("portalStyle", "1");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REQUESTUPLOADCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("status错误", "uploaded", dataObject.getString("status"));
		assertEquals("chunkNum错误", 0, dataObject.getInt("chunkNum"));
	}
	
	@Test(summary = "添加统计参数portalStyle=2", expectedResults = "返回结果无异常", index = 4)
	public void testRequestChunk_Stat2() {
		String path = "res/AlreadyUploaded.mp4"; 
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);
		
		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);
		
		g_user.setHttpParam("uploadMethod", "sdk");
		g_user.setHttpParam("files", files.toString());
		g_user.setHttpParam("portalStyle", "2");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REQUESTUPLOADCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("status错误", "uploaded", dataObject.getString("status"));
		assertEquals("chunkNum错误", 0, dataObject.getInt("chunkNum"));
	}
	
	@Test(summary = "添加统计参数portalStyle=3", expectedResults = "返回结果无异常", index = 5)
	public void testRequestChunk_Stat3() {
		String path = "res/AlreadyUploaded.mp4"; 
		JSONArray files = new JSONArray();
		JSONObject fileObject = new JSONObject();
		String gcid = VideoUtils.calcGcid(path);
		
		fileObject.put("gcid", gcid);
		fileObject.put("path", path);
		fileObject.put("size", new File(path).length());
		fileObject.put("createTime", new File(path).lastModified());
		files.add(fileObject);
		
		g_user.setHttpParam("uploadMethod", "sdk");
		g_user.setHttpParam("files", files.toString());
		g_user.setHttpParam("portalStyle", "3");
		JSONObject result = g_user.postJsonResp(Constant.FILE_REQUESTUPLOADCHUNK);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("status错误", "uploaded", dataObject.getString("status"));
		assertEquals("chunkNum错误", 0, dataObject.getInt("chunkNum"));
	}
}
