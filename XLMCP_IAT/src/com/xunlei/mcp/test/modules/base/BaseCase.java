package com.xunlei.mcp.test.modules.base;

import java.util.Map;

import org.junit.*;
import org.junit.rules.TestName;

import com.xunlei.mcp.test.modules.model.User;
import com.xunlei.mcp.test.modules.utils.Configuration;

/**
 * 测试用例基类
 * 
 * @author peiyu
 * 
 */
public class BaseCase {

	public Map<String, String> http_param;
	public static String platform;
	public static User g_user;

	@Rule
	public TestName testName = new TestName();

	public BaseCase() {
	}

	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		platform = Configuration.loadProperties().getProperty("environment");
/*		switch (platform) {
		case "test":
			g_user = new User(Constant.OPENID_TEST, Constant.USERNAME_TEST,
					"weixin");
			break;
		case "pre":
			g_user = new User(Constant.OPENID_PRE, Constant.USERNAME_PRE,
					"weixin");
			break;
		default:
			g_user = new User(Constant.OPENID_ONLINE, Constant.USERNAME_ONLINE,
					"weixin");
			break;
		}*/
		g_user = new User();
	}

	@Before
	public void setup() {
		System.out.println("**********" + testName.getMethodName()
				+ " START**********");
	}

	@After
	public void tearDown() {
		System.out.println("**********" + testName.getMethodName()
				+ " END**********");
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
