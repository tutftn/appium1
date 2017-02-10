package com.junit4.contactmanager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Junit_appium_1 {

	private AppiumDriver<AndroidElement> driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("===========ssss=before");
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		
		File appDir = new File(classpathRoot, "src/test/java/apps/contactmanager");// -------
		File app = new File(appDir, "ContactManager.apk"); // ---
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.example.android.contactmanager");// ------
		capabilities.setCapability("appActivity", ".ContactManager");
		try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("============before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("============afterClass");
		driver.quit();
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
