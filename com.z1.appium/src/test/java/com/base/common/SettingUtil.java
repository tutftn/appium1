package com.base.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SettingUtil {
	
	/**
	 * 从文件中读取配置文件
	 * @param fileAbsolutePath 文件绝对路径
	 * @return
	 */
	public static Properties getPrpertiesByAbsolutePath(String fileAbsolutePath){
		Properties pro = new Properties();// 生成实例
		try {
			InputStream inStream = new FileInputStream(new File(fileAbsolutePath));  
			pro.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	/**
	 * 从文件中读取配置文件
	 * @param releativePath 相对路径，针对工程所在位置
	 * @return
	 */
	public static Properties getPropertiesByReleativePath(String releativePath){
		Properties pro = new Properties();// 生成实例
		try {
			File project = new File(System.getProperty("user.dir"));
			String filePath = project.getAbsolutePath() + releativePath;
			System.out.println(filePath);
			File file = new File(filePath);
			pro.load(new FileInputStream(file));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
