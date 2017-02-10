package com.base.mobile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseAppiumUitl {
	
	/**
	 * 截屏，并保存到本地
	 * 
	 * @param driver
	 * @param path 图片保存绝对路径
	 */
	public static void getScreenShot(RemoteWebDriver driver, String path){
        //截屏并保存至本地
		File screen = driver.getScreenshotAs(OutputType.FILE);
		String imgName = "screen_" + System.currentTimeMillis()+".png";
		File screenFile = new File(path + File.separator + imgName);
		try {
		    FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

}
