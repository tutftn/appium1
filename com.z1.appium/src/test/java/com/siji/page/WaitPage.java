package com.siji.page;

import org.openqa.selenium.WebElement;

import com.siji.util.TestBase;

import io.appium.java_client.AppiumDriver;

public class WaitPage {
	AppiumDriver driver;

	public WebElement received ;//接到乘客
	
	public WaitPage(AppiumDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		this.driver = driver;
		received = TestBase.getPageElement("id","//android.widget.Button[contains(@text,'接到乘客')]");
	}

}
