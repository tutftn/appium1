package com.base.mobile;

import static org.junit.Assert.fail;

import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.base.common.SettingUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.TestCase;

public class BaseTestCase extends TestCase {
	
	protected AndroidDriver<AndroidElement> driver;
	
	/**
	 * 配置文件针对项目的相对路径
	 */
	private String propertiesPath;
	
	/**
	 * 赋值 配置文件针对项目的相对路径
	 * @param propertiesPath
	 */
	public void setPropertiesPath(String propertiesPath) {
		this.propertiesPath = propertiesPath;
	}
	

	/**
	 * 取值配置文件针对项目的相对路径
	 * @param propertiesPath
	 */
	public String getPropertiesPath() {
		return propertiesPath;
	}
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("============setUp");
		
		Properties pro = SettingUtil.getPropertiesByReleativePath(propertiesPath);
		DesiredCapabilities capabilities = AndroidUtil.getDesiredCapabilities(pro);
		driver = AndroidUtil.getAndroidDriver(capabilities);

//		driver = null; 当driver为null时，依旧会正常启动app，但是不会执行test方法
		if(driver == null){
			fail("初始化 driver 失败了");
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
		System.out.println("============tearDown");
		super.tearDown();
		
		if(driver != null){
			driver.quit();
		}
	}

}
