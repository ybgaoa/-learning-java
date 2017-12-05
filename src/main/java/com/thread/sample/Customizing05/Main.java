package com.thread.sample.Customizing05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
		Task task = new Task();
		System.out.println("main:"+new Date());
		//ʹ��schedule()��������һ���ӳ�����ִ��������������ӳ�1���ִ��
		executor.schedule(task, 1, TimeUnit.SECONDS);
		//ʹ���߳�����3��
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task = new Task();
		System.out.println("main:"+new Date());
		//ʹ��scheduleAtFixedRate()��������һ������������ִ��������������ӳ�1���ִ�У�Ȼ��ÿ3��ִ��һ��
		executor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main:end of the program");
	}

}
