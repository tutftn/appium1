package com.siji.page;

import org.openqa.selenium.WebElement;

import com.siji.util.TestBase;

import io.appium.java_client.AppiumDriver;

public class mainPage {

	AppiumDriver driver;
	public WebElement outCar ;//出车按钮
	public WebElement destination;//订单卡片目的地
	public WebElement acceptOrder;//接单按钮
	public WebElement closeOrder;//红叉，关闭按钮
	public WebElement confirm;//知道了按钮
	
	
	public mainPage(AppiumDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		this.driver = driver;
		outCar = TestBase.getPageElement("id","com.sdu.didi.gsui:id/main_control_panel_start_off_btn_start_off");
		destination = TestBase.getPageElement("id", "com.sdu.didi.gsui:id/txt_name_to");
		acceptOrder = TestBase.getPageElement("id", "com.sdu.didi.gsui:id/grab_btn_layout");
		closeOrder = TestBase.getPageElement("id", "com.sdu.didi.gsui:id/main_order_fragment_img_close");
		confirm = TestBase.getPageElement("id", "com.sdu.didi.gsui:id/bt_confirm");
	}
}
