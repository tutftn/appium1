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

//		driver = null; 当driver为null时，依旧会正常启动app，但是不会执行test方法
		if(driver == null){
			fail("初始化 driver 失败了");
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
			fail("driver是空，不需要销毁");
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
