package com.junit4.sina.modify.page;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.base.common.MessageUtil;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage {
	
	@AndroidFindBy(id = "com.sina.weibo:id/etLoginUsername")
	private WebElement username;

	@AndroidFindBy(id = "com.sina.weibo:id/etPwd")
	private WebElement password;

	@AndroidFindBy(id = "com.sina.weibo:id/bnLogin")
	private WebElement btn_login;
	
	@AndroidFindBy(className = "android.view.WindowManager")
	public List<WebElement> androidTextViews;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtn_login() {
		return btn_login;
	}

	public List<WebElement> getAndroidTextViews() {
		return androidTextViews;
	}
	
	//发送正确的用户名密码
	public void sendSuccessEnter(){
		if(username == null || password == null){
			fail(MessageUtil.isnull);
		}
		username.sendKeys("virsual@yeah.net");
		password.sendKeys("(@)110xyz");
	}
	
	//点击登录按钮
	public void clickLogin(){
		btn_login.click();
	}
	
	
}
