package com.lanmeng.test;

import com.lanmeng.test.TimeUtil;

public class Log {
	private static final String TAG = " fenghe";

	public static void d(String tag, String s) {
		if (tag == null) {
			System.out.println(TimeUtil.currentTime() + " : " + s);
		} else {
			System.out.println(TimeUtil.currentTime() + tag + " : " + s);
		}
	}

	public static void d(String s) {
		d(null, s);
	}

}
