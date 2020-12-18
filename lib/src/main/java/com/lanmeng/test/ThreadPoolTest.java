package com.lanmeng.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(5);
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, queue);
		//这里设置不同的饱和策略
		threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 16 ; i++)
        {
        	System.out.println(i+"");
            threadPool.execute(
                new Thread(new ThreadPoolTest(), "Thread".concat(i + "")));
            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
            if (queue.size() > 0)
            {
                System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPool.shutdown();

	}

	@Override
	public void run() {
		try {
			Thread.sleep(20);
			System.out.println("Completed: " + Thread.currentThread().getName());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
