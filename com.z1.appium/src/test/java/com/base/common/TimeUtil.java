package com.base.common;

public class TimeUtil {
	
	public static final long defaultWaitTime = 2000;
	
	/**
	 * 等待默认时间 2s
	 */
	public static void waitTime(){
		try {
			Thread.sleep(defaultWaitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 等待时间
	 * @param millis 
	 */
	public static void waitTime(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
