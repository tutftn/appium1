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
	 * �����ļ������Ŀ�����·��
	 */
	private String propertiesPath;
	
	/**
	 * ��ֵ �����ļ������Ŀ�����·��
	 * @param propertiesPath
	 */
	public void setPropertiesPath(String propertiesPath) {
		this.propertiesPath = propertiesPath;
	}
	

	/**
	 * ȡֵ�����ļ������Ŀ�����·��
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

//		driver = null; ��driverΪnullʱ�����ɻ���������app�����ǲ���ִ��test����
		if(driver == null){
			fail("��ʼ�� driver ʧ����");
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
