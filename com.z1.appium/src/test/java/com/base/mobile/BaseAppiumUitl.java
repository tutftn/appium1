package com.base.mobile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseAppiumUitl {
	
	/**
	 * �����������浽����
	 * 
	 * @param driver
	 * @param path ͼƬ�������·��
	 */
	public static void getScreenShot(RemoteWebDriver driver, String path){
        //����������������
		File screen = driver.getScreenshotAs(OutputType.FILE);
		String imgName = "screen_" + System.currentTimeMillis()+".png";
		File screenFile = new File(path + File.separator + imgName);
		try {
		    FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar�е�api
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

}
