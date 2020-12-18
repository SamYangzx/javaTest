package com.lanmeng.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(5);
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, queue);
		//�������ò�ͬ�ı��Ͳ���
		threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 16 ; i++)
        {
        	System.out.println(i+"");
            threadPool.execute(
                new Thread(new ThreadPoolTest(), "Thread".concat(i + "")));
            System.out.println("�̳߳��л�Ծ���߳����� " + threadPool.getPoolSize());
            if (queue.size() > 0)
            {
                System.out.println("----------------�������������߳���" + queue.size());
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
