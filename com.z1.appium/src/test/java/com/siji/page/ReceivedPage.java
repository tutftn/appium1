package com.siji.page;

import org.openqa.selenium.WebElement;

import com.siji.util.TestBase;

import io.appium.java_client.AppiumDriver;

public class ReceivedPage {
	AppiumDriver driver;

	public WebElement arrive ;//到达约定地点
	
	public ReceivedPage(AppiumDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		this.driver = driver;
		arrive = TestBase.getPageElement("xpath","");
	}

}
