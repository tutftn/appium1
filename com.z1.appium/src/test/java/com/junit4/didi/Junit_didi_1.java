package com.junit4.didi;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.base.common.SettingUtil;
import com.base.common.TimeUtil;
import com.base.mobile.AndroidUtil;
import com.base.mobile.SwipeUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Junit_didi_1{
	
	private AndroidDriver<AndroidElement> driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("===========ssss=before");
		
		// set up appium
		Properties pro = SettingUtil.getPropertiesByReleativePath("/didi.properties");
		DesiredCapabilities capabilities = AndroidUtil.getDesiredCapabilities(pro);
		
		//一般由启动页面进入引导页面，上一个activity跳转入新的activity
		capabilities.setCapability("appWaitActivity", "com.sdu.didi.gui.main.GuideActivity");
//		capabilities.setCapability("unicodeKeyboard", "True");  
//		capabilities.setCapability("resetKeyboard", "True");  
		
		driver = AndroidUtil.getAndroidDriver(capabilities);

//		driver = null; 当driver为null时，依旧会正常启动app，但是不会执行test方法
		if(driver == null){
			fail("初始化 driver 失败了");
		}
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("=======tearDown");
	}

	@Test
	public void test() {
		
		TimeUtil.waitTime();
		
//		fail("Not yet implemented");
		for(int i=0; i<5; i++){
			SwipeUtil.swipeToLeft(driver, 400); //这里时间设置要注意，太短，比如20，设备没有反应
		}
			
		driver.findElement(By.id("com.sdu.didi.gui:id/guide_button")).click();

		driver.findElement(By.id("com.sdu.didi.gsui:id/login_button")).click();
		
	    
	    System.out.println("=======test");
	}

}
