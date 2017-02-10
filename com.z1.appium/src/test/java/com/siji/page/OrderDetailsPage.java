package com.siji.page;

import org.openqa.selenium.WebElement;

import com.siji.util.TestBase;

import io.appium.java_client.AppiumDriver;

public class OrderDetailsPage {
	AppiumDriver driver;

	public WebElement finish  ;//发起收款
	
	public OrderDetailsPage(AppiumDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		this.driver = driver;
		finish  = TestBase.getPageElement("xpath","//android.widget.Button[contains(@text,'完成，继续听单')]");
	}
}
