package com.siji.page;

import org.openqa.selenium.WebElement;

import com.siji.util.TestBase;

import io.appium.java_client.AppiumDriver;

public class SendPage {
	AppiumDriver driver;

	public WebElement arriveDestination ;//����Ŀ�ĵ�
	
	public SendPage(AppiumDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		this.driver = driver;
		arriveDestination = TestBase.getPageElement("xpath","//android.widget.Button[contains(@text,'����Ŀ�ĵ�')]");
	}

}
