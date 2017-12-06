package com.thread.sample.sample20;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
//在执行器中周期性执行任务
public class Main {

	public static void main(String[] args) {
		//通过Executors工厂类的newScheduledThreadPool()方法创建一个ScheduledExecutorService执行器，并传递1作为参数
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		System.out.println("Main:starting at:"+new Date());
		Task task = new Task("task");
		//方法参数说明：1.将被周期性执行的任务；2.任务第一次执行后的延时时间；3.任务执行的时间周期；4.第二个和第三个参数的单位
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 10, TimeUnit.SECONDS);
		
		for(int i=0;i<10;i++){
			//调用ScheduledFuture类的getDelay()方法来获取下一次将要执行的时间
			System.out.println("main:delay:"+result.getDelay(TimeUnit.MILLISECONDS));
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//关闭执行器
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:finished at:"+new Date());
	}

}
