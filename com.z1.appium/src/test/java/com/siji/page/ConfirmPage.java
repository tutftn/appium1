package com.siji.page;

import org.openqa.selenium.WebElement;

import com.siji.util.TestBase;

import io.appium.java_client.AppiumDriver;

public class ConfirmPage {
	AppiumDriver driver;

	public WebElement collection ;//�����տ�
	
	public ConfirmPage(AppiumDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		this.driver = driver;
		collection = TestBase.getPageElement("xpath","//android.widget.Button[contains(@text,'�����տ�')]");
	}
		

}
