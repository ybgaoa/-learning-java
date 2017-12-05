package com.thread.sample.Customizing05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
		Task task = new Task();
		System.out.println("main:"+new Date());
		//使用schedule()方法发送一个延迟任务到执行器。这个任务将延迟1秒后被执行
		executor.schedule(task, 1, TimeUnit.SECONDS);
		//使主线程休眠3秒
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task = new Task();
		System.out.println("main:"+new Date());
		//使用scheduleAtFixedRate()方法发送一个周期性任务到执行器。这个任务将延迟1秒后被执行，然后每3秒执行一次
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
