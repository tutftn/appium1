package com.junit4.sina;

import static org.junit.Assert.fail;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.common.MessageUtil;
import com.base.common.SettingUtil;
import com.base.common.TimeUtil;
import com.base.mobile.AndroidUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Junit_weibo_1{
	
	private AndroidDriver<AndroidElement> driver;
	
	Properties pro;

	@Before
	public void setUp() throws Exception {
		System.out.println("===========ssss=before");
		
		// set up appium
		pro = SettingUtil.getPropertiesByReleativePath("/weibo.properties");
		DesiredCapabilities capabilities = AndroidUtil.getDesiredCapabilities(pro);
		
		//一般由启动页面进入引导页面，上一个activity跳转入新的activity
		capabilities.setCapability("appWaitActivity", "com.sina.weibo.NavigateViewPageActivity");
//		capabilities.setCapability("unicodeKeyboard", "True");  
//		capabilities.setCapability("resetKeyboard", "True");  
		
		driver = AndroidUtil.getAndroidDriver(capabilities);
			

//		driver = null; 当driver为null时，依旧会正常启动app，但是不会执行test方法
		if(driver == null){
			fail("初始化 driver 失败了");
		}
		

		System.out.println("===========ssss=beforelllll");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("=======tearDown");
		driver.quit();
	}

	@Test
	public void test() {
		
		//app是否安装
		boolean falg = driver.isAppInstalled(pro.getProperty(AndroidUtil.appPackage));
	    System.out.println("=======falg::" + falg);
	    
	    //截图
//		AndroidUtil.getScreenShot(driver, pro.getProperty(AndroidUtil.screenShotPath));
			
		//开启。微博
		driver.findElementById("iv_navigater_clickable").click();
		
	    //获取当前activity
	    String curActivity = driver.currentActivity();
	    System.out.println("=======curActivity::" + curActivity); // .VisitorMainTabActivity
	    
	    //登录
		driver.findElement(By.id("com.sina.weibo:id/titleSave")).click();
		
		WebElement et_username = driver.findElement(By.id("com.sina.weibo:id/etLoginUsername"));
		if(et_username == null){
			fail(MessageUtil.isnull);
		}
		et_username.sendKeys("aaaaaa");
		
		WebElement et_password = driver.findElement(By.id("com.sina.weibo:id/etPwd"));
		if(et_password == null){
			fail(MessageUtil.isnull);
		}
		et_password.sendKeys("aaaaaa");
		
//		driver.hideKeyboard(); //当登录按钮被遮挡时，将不能触发点击事件
		
		//当被输入键盘遮挡时，依旧可以找到元素，但是触发点击事件了吗？？？答：没有，因为没有弹出提示框
		WebElement btn_login = driver.findElement(By.id("com.sina.weibo:id/bnLogin"));
		if(btn_login == null){
			System.out.println("=======ppppp");
			fail(MessageUtil.isnull);
		}
		btn_login.click();
		
		
		TimeUtil.waitTime();


		System.out.println("=======p133333333");
		
	    
	    //获取当前activity
//	    String curActivity = driver.currentActivity();
//	    System.out.println("=======curActivity::" + curActivity); // .VisitorMainTabActivity

		
		
	    
	}

	
	
	
	
}
