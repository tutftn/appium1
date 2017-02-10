package com.junit4.contactmanager;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.base.common.SettingUtil;
import com.base.mobile.AndroidUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Junit_appium_1_modify_1 {

	private AndroidDriver<AndroidElement> driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("===========ssss=before");
		// set up appium
		
		Properties pro = SettingUtil.getPropertiesByReleativePath("/ContactManager.properties");
		DesiredCapabilities capabilities = AndroidUtil.getDesiredCapabilities(pro);
		driver = AndroidUtil.getAndroidDriver(capabilities);

//		driver = null; ��driverΪnullʱ�����ɻ���������app�����ǲ���ִ��test����
		if(driver == null){
			fail("��ʼ�� driver ʧ����");
		}
		
		
//		driver.lockDevice();
		
//		System.out.println("======" + driver.isLocked());
		
//		driver.unlockDevice();
		
		
		
		System.out.println("======" + driver.isLocked());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("============afterClass");
		
		if(driver == null){
			fail("driver�ǿգ�����Ҫ����");
		}else{
			driver.quit();
		}
	}

	@Test
	public void test() {
		System.out.println("============test1");
		WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));
		el.click();
		List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		textFieldsList.get(0).sendKeys("Some Name111");
		textFieldsList.get(2).sendKeys("Some@example.com");
		driver.swipe(100, 500, 100, 100, 2);
		driver.findElementByXPath(".//*[@text='Save']").click();
	}					

}
