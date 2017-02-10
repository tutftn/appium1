package com.base.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUtil extends BaseAppiumUitl{
	
	public static final String URL = "http://127.0.0.1:4723/wd/hub";
	
	public static final String app = "app";
	public static final String deviceName = "deviceName";
	public static final String platformVersion = "platformVersion";
	public static final String appPackage = "appPackage";
	public static final String appActivity = "appActivity";
	public static final String screenShotPath = "screenShotPath";	
	public static final String appWaitActivity = "appWaitActivity";

	
	/**
	 * 从配置文件获取设备以及所测app的基本信息
	 * @param properties  配置文件
	 * @return
	 */
	public static DesiredCapabilities getDesiredCapabilities(Properties properties){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
		capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
		capabilities.setCapability("app", properties.getProperty("app"));
		capabilities.setCapability("appPackage", properties.getProperty("appPackage"));// ------
		capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
		
		return capabilities;
	}
	
	/**
	 * 获取AndroidDriver
	 * @param url  http://127.0.0.1:4723/wd/hub
	 * @param capabilities
	 * @return
	 */
	public static AndroidDriver<AndroidElement> getAndroidDriver(String url, DesiredCapabilities capabilities){
		AndroidDriver<AndroidElement> driver = null;
		try {
			driver = new AndroidDriver<AndroidElement>(new URL(url), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	/**
	 * 获取AndroidDriver
	 * @param capabilities
	 * @return
	 */
	public static AndroidDriver<AndroidElement> getAndroidDriver(DesiredCapabilities capabilities){
		AndroidDriver<AndroidElement> driver = null;
		try {
			driver = new AndroidDriver<AndroidElement>(new URL(AndroidUtil.URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	/** 
     * 判断手机设备是否黑屏 
     * @param c 
     * @return 
     */  
//    public static boolean isScreenLocked(Context c) {  
//  
//         android.app.KeyguardManager mKeyguardManager = (KeyguardManager) c.getSystemService(c.KEYGUARD_SERVICE);  
//         return !mKeyguardManager.inKeyguardRestrictedInputMode();  
//  
//    }  

}
