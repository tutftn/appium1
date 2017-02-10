package com.siji.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.siji.page.mainPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TestBase {
	static AppiumDriver driver;
	/**
     * This Method for swipe up
     * 上滑
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToUp(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loading
    }

    /**
     * This Method for swipe down
     * 下滑
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToDown(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
        // wait for page loading
    }

    /**
     * This Method for swipe Left
     * 左滑
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToLeft(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
        // wait for page loading
    }

    /**
     * This Method for swipe Right
     * 右滑
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToRight(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
        // wait for page loading
    }
    /**
     * 滑动到达约定地点、接到乘客、到达目的地等按钮
     */
    public  void SwipeToRightElement(AppiumDriver driver, WebElement element){
//    	int width = driver.findElement(by).getSize().getWidth();
//		int height = driver.findElement(by).getSize().getHeight();
//		driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
//    	WebElement element = driver.findElement(by);
//    	System.out.println(element.getText());
    	element.click();
    	int xStartPoint = element.getLocation().getX();
//    	System.out.println("xStartPoint:"+xStartPoint);
    	int xMiddlePoint = xStartPoint + element.getSize().getWidth();
//    	System.out.println("xStartPoint+width:"+xMiddlePoint);
    	int yPoint = element.getLocation().getY();
//    	System.out.println("yPoint:"+yPoint);
    	
    	
    	TouchAction action = new TouchAction(driver);
//		action.press(xStartPoint, yPoint).moveTo(xMiddlePoint, yPoint).release().perform();
    	driver.swipe(xStartPoint,yPoint, xMiddlePoint,yPoint, 500); 


//    	action.press(element, xMiddlePoint, yPoint).release().perform();

    }
    /**
     * 获取页面元素
     */
    public static WebElement getPageElement(String expression,String value){
		switch (expression) {
			case "id":
				return findById(value);
			case "xpath":
				return findByXpath(value);
			default:
				break;
		}
		
        return null;
    }
    /**
     * 根据id查找页面元素
     */
	public static WebElement findById(String id) {
        return findElementBy(By.id(id));
    }
	/**
	 * 根据xpath查找页面元素
	 */
	public static WebElement findByXpath(String xpath) {
        return findElementBy(By.xpath(xpath));
    }
	/**
	 * 查找页面元素
	 */
	public static WebElement findElementBy(By by){
        try {
            if (driver != null) {
                return    driver.findElement(by);
            } else {
//                print("driverΪ��");
            }
        } catch (NoSuchElementException e) {
//            print("�Ҳ����ؼ�:" +str+" �쳣��Ϣ:"+ e.getMessage());
        }

        return null;
    }
    /**
     * 等待时间
     */
    public  void waitTime(int num){
    	try {
			Thread.sleep(num*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 点击更新弹窗
     */
    public  void clickUpdate(AppiumDriver driver){
    	WebElement update_cancel = getPageElement("id", "com.sdu.didi.gsui:id/cancel_btn");
    	if (update_cancel.isDisplayed()) {
			update_cancel.click();
		}
//		if(driver.findElement(By.id("com.sdu.didi.gsui:id/cancel_btn")).isDisplayed()){
//			driver.findElement(By.id("com.sdu.didi.gsui:id/cancel_btn")).click();
//			waitTime(1);
//		}
    }
    
    
    
    /**
     * 模拟安卓返回按钮，清除手势引导
     */
    public void androidBack (AndroidDriver driver){
    	driver.pressKeyCode(AndroidKeyCode.BACK);
    	waitTime(1);
    }
    
    
}
