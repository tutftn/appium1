package com.junit4.sina.modify;

import static org.junit.Assert.fail;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.base.common.SettingUtil;
import com.base.mobile.AndroidUtil;
import com.junit4.sina.modify.page.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class Junit_weibo_1_modify{
	
	private AndroidDriver<AndroidElement> driver;
	
	Properties pro;
	
	LoginPage mLoginPage;

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
		mLoginPage = new LoginPage();

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

	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//		Alert alert = driver.switchTo().alert();
//		if(alert==null){
//			System.out.println("=====alertqqq");
//		}else{
//
//			System.out.println("=======alertdddddd");
//		}
		
	    //登录
		driver.findElement(By.id("com.sina.weibo:id/titleSave")).click();
		
		
		//登陆页面
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(5, TimeUnit.SECONDS)), mLoginPage);
		mLoginPage.sendSuccessEnter();
		driver.hideKeyboard();
		mLoginPage.clickLogin();
		
//		mLoginPage.androidTextViews;
		
		
		WebElement d7d = driver.findElement(By.className("android.widget.ListView"));

		if(d7d==null){
			System.out.println("=====sss");
		}else{

			System.out.println("=======wwwwww");
		}

		System.out.println("=======p133333333");
		
	    
	    //获取当前activity
//	    String curActivity = driver.currentActivity();
//	    System.out.println("=======curActivity::" + curActivity); // .VisitorMainTabActivity

		
		
	    
	}

	
	
	
	
}
