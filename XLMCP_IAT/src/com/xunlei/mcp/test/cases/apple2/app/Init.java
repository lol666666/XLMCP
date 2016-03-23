package com.xunlei.mcp.test.cases.apple2.app;

import static org.junit.Assert.*;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class Init extends BaseCase {
	@Test(summary = "初始化app必选参数", expectedResults = "初始化成功", index = 1)
	public void testInit1() {
		g_user.setHttpParam("deviceId", g_user.deviceID);
		g_user.setHttpParam("version", "0");
		g_user.setHttpParam("product_version", "1.0");
		g_user.setHttpParam("language", "zh");
		g_user.setHttpParam("screenHeight", "1280");
		g_user.setHttpParam("device", "unknown");
		g_user.setHttpParam("androidVersion", "5.0.2");
		g_user.setHttpParam("model", "HM+NOTE+2LTE");
		g_user.setHttpParam("screenResolution", "720*1280");
		g_user.setHttpParam("screenWidth", "720");
		g_user.setHttpParam("screenDensity", "2.0");
		JSONObject result = g_user.postJsonResp(Constant.APP_INIT);
		assertEquals("初始化失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "初始化app全部参数", expectedResults = "初始化成功", index = 2)
	public void testInit2() {
		g_user.setHttpParam("deviceId", g_user.deviceID);
		g_user.setHttpParam("version", "0");
		g_user.setHttpParam("product_version", "0.1.5");
		g_user.setHttpParam("language", "zh");
		g_user.setHttpParam("screenHeight", "1280");
		g_user.setHttpParam("device", "unknown");
		g_user.setHttpParam("androidVersion", "5.0.2");
		g_user.setHttpParam("model", "HM+NOTE+2LTE");
		g_user.setHttpParam("screenResolution", "720*1280");
		g_user.setHttpParam("screenWidth", "720");
		g_user.setHttpParam("screenDensity", "2.0");
		//以下为全部可选参数
		g_user.setHttpParam("miui_version", "V7.0.5.0.KHICNCI");
		g_user.setHttpParam("miui_type", "development");
		g_user.setHttpParam("mac", Constant.MAC);
		g_user.setHttpParam("macMd5", DigestUtils.md5Hex(Constant.MAC));
		g_user.setHttpParam("imei", g_user.imei);
		g_user.setHttpParam("imeiMd5", DigestUtils.md5Hex(g_user.imei));
//		String macAes = ParamUtils.encrypt(Constant.MAC, Constant.AES_PASSWORD);
//		g_user.setHttpParam("macAes", macAes);
//		String imeiAes = ParamUtils.encrypt(Constant.IMEI, Constant.AES_PASSWORD);
//		g_user.setHttpParam("imeiAes", imeiAes);
		g_user.setHttpParam("country", "CN");
		JSONObject result = g_user.postJsonResp(Constant.APP_INIT);
		assertEquals("初始化失败", 0, result.getInt("result"));
	}
	
	@Test(summary = "初始化app仅可选参数", expectedResults = "初始化成功", index = 3)
	public void testInit3() {
		g_user.setHttpParam("miui_version", "V7.0.5.0.KHICNCI");
		g_user.setHttpParam("miui_type", "development");
		g_user.setHttpParam("mac", Constant.MAC);
		g_user.setHttpParam("macMd5", DigestUtils.md5Hex(Constant.MAC));
		g_user.setHttpParam("imei", g_user.imei);
		g_user.setHttpParam("imeiMd5", DigestUtils.md5Hex(g_user.imei));
//		String macAes = ParamUtils.encrypt(Constant.MAC, Constant.AES_PASSWORD);
//		g_user.setHttpParam("macAes", macAes);
//		String imeiAes = ParamUtils.encrypt(Constant.IMEI, Constant.AES_PASSWORD);
//		g_user.setHttpParam("imeiAes", imeiAes);
		g_user.setHttpParam("country", "CN");
		JSONObject result = g_user.postJsonResp(Constant.APP_INIT);
		assertEquals("结果错误，仍初始化成功", 2, result.getInt("result"));
	}
}
