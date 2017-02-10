package com.junit4.sina.modify.page;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListPage {
	
	@AndroidFindBy(className = "android.widget.ListView")
	private WebElement listview;

}
