package com.junit4.contactmanager;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.mobile.BaseTestCase;

import io.appium.java_client.android.AndroidElement;

public class Junit_appium_1_modify_2 extends BaseTestCase{

	@Before
	public void setUp() throws Exception {
		setPropertiesPath("/ContactManager.properties");
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
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
