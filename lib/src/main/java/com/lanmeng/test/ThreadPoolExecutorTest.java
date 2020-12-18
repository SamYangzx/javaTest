package com.lanmeng.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ExecutorService threadPool = Executors.newCachedThreadPool();
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
//		for (int i = 1; i <= 5; i++) {
//			final int index = i;
//			threadPool.execute(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						System.out.println("第" + index + "个线程" + Thread.currentThread().getName());
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//			});
//		}

		// 带周期或延迟执行的
		Log.d("newScheduledThreadPool");
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		for (int i = 1; i <= 5; i++) {
			final int index = i;
			scheduledThreadPool.schedule(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("第" + index + "个线程" + Thread.currentThread().getName());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Log.d("延迟三秒: " + Thread.currentThread().getName());
				}
			}, 3, TimeUnit.SECONDS);
		}

//
//		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Log.d("scheduleAtFixedRate");
//				
//			}
//		}, 1, 3, TimeUnit.SECONDS);

		// 单线程处理方式
//		Log.d("newSingleThreadExecutor");
//		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
//		for (int i = 1; i <= 5; i++) {
//			final int index = i;
//			new Thread(new Runnable() {
//
//				@Override
//				public void run() {
//					try {
//						Thread.sleep(2000 *index);
//					} catch (InterruptedException e) {
//						Log.d(e.getMessage());
//					}
//					Log.d("Done: " + Thread.currentThread().getName());
//					singleThreadPool.submit(new Callable<String>() {
//
//						@Override
//						public String call() throws Exception {
//							// TODO Auto-generated method stub
//							Log.d("callable：" + Thread.currentThread().getName());
//							return null;
//						}
//					});
//
//				}
//			}).start();
//
//		}

	}

}
