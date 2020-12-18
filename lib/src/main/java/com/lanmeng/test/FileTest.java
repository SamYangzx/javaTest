package com.lanmeng.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lanmeng.test.Log;

public class FileTest {
	private static final String TAG = "fenghe";
	private static final String EXPORT_FILE = "E:/log.txt";
	private static final String EXPORT_CONTENT = "432";
	private static final String DIRECTION_FILE = "/sys/class/gpio/gpio432/direction";
	private static final String DIRECTION_CONTENT = "out";
	private static final String VALUE_FILE = "/sys/class/gpio/gpio432/value";
	private static final String VALUE_CONTENT = "0";

	public static void main(String[] args) {
		FileTest fileTest = new FileTest();
		fileTest.writeData(EXPORT_FILE,EXPORT_CONTENT);
//		Log.d(TAG, "file.exist(): " + file.exists());
//		if (!file.exists()) {
//			return;
//		}
//		OutputStream out;
//		try {
//			out = new FileOutputStream(file);
////			String export = "432";
//			// 读取数据
//			// 一次性取多少字节
//			byte[] bytes = export.getBytes();
//			// 接受读取的内容(n就代表的相关数据，只不过是数字的形式)
////			int n = 4;
////			bytes[0] = '4';
////			bytes[1] = '3';
////			bytes[2] = '2';
////			bytes[3] = 0;
//			// 循环取出数据
//			out.write(bytes, 0, export.length());
//
//			// 关闭流
//			out.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	/**
	 * Write content to path file
	 * @param path
	 * @param content
	 */
	private void writeData(String path, String content) {
		if(path == null || content == null) {
			System.out.println("path or content is null, return!!");
			return;
		}
		File file = new File(path);
		Log.d(TAG, "file.exist(): " + file.exists());
		if (!file.exists()) {
			return;
		}
		OutputStream out;
		try {
			out = new FileOutputStream(file);
			byte[] bytes = content.getBytes();
			Log.d(TAG, "content.length(): " + content.length());
			out.write(bytes, 0, content.length());
			// 关闭流
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
