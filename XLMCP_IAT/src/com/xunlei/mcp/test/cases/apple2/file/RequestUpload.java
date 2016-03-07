package com.xunlei.mcp.test.cases.apple2.file;

import static org.junit.Assert.*;

import java.io.File;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;
import com.xunlei.mcp.test.modules.utils.VideoUtils;

public class RequestUpload extends BaseCase {
	@Test(summary = "请求上传单个文件(未上传)", expectedResults = "返回结果格式正确", index = 1)
	public void testRequest_New() {
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
		JSONObject result = g_user.postJsonResp(Constant.FILE_REQUESTUPLOAD);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("status错误", "requireUpload",
				dataObject.getString("status"));
		assertTrue("uploadToken错误", !dataObject.getString("uploadToken")
				.isEmpty());
	}

	@Test(summary = "请求上传单个文件(已上传)", expectedResults = "返回结果格式正确", index = 2)
	public void testRequest_Already() {
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
		JSONObject result = g_user.postJsonResp(Constant.FILE_REQUESTUPLOAD);
		assertNotNull("返回结果为空", result);
		JSONArray dataArray = result.getJSONArray("data");
		JSONObject dataObject = dataArray.getJSONObject(0);
		assertEquals("gcid错误", gcid, dataObject.getString("gcid"));
		assertEquals("status错误", "uploaded", dataObject.getString("status"));
	}
}
