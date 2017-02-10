package com.siji.page;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event.ID;

import com.siji.util.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class loginPage {
	AppiumDriver driver;

	public WebElement username ;
	public WebElement password ;
	public WebElement consent_button;
	public WebElement login_button ;
	
	public loginPage(AppiumDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		this.driver = driver;
		username = TestBase.getPageElement("id","com.sdu.didi.gsui:id/actv_phone_number");
		System.out.println(username);
		password = TestBase.getPageElement("id","com.sdu.didi.gsui:id/login_phone_password");
		consent_button = TestBase.getPageElement("id","com.sdu.didi.gsui:id/cb_law");
		login_button = TestBase.getPageElement("id","com.sdu.didi.gsui:id/tv_login");
	}
	
	



}
