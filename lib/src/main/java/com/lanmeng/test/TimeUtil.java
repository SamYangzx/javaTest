package com.lanmeng.test;

import java.util.Date;

public class TimeUtil {
	@SuppressWarnings("deprecation")
	public static String currentTime() {
		Date date = new Date();
		return date.toLocaleString();
	}

}
