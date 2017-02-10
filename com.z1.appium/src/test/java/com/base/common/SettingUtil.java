package com.base.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SettingUtil {
	
	/**
	 * ���ļ��ж�ȡ�����ļ�
	 * @param fileAbsolutePath �ļ�����·��
	 * @return
	 */
	public static Properties getPrpertiesByAbsolutePath(String fileAbsolutePath){
		Properties pro = new Properties();// ����ʵ��
		try {
			InputStream inStream = new FileInputStream(new File(fileAbsolutePath));  
			pro.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	/**
	 * ���ļ��ж�ȡ�����ļ�
	 * @param releativePath ���·������Թ�������λ��
	 * @return
	 */
	public static Properties getPropertiesByReleativePath(String releativePath){
		Properties pro = new Properties();// ����ʵ��
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
