package com.thread.sample.sample19;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//在执行器中延时执行任务
public class Main {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
		System.out.println("main:starting at:"+new Date());
		for(int i=0;i<5;i++){
			Task task = new Task("task-"+i);
			//方法参数说明：1.即将执行的任务；2.任务执行前所要等待的时间；3.等待时间的单位，由TimeUint类的一个常量来指定
			executor.schedule(task, i+1, TimeUnit.SECONDS);
		}
		executor.shutdown();
		try {
			//调用执行器awaitTermination()方法等待所有任务结束
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:ends at:"+new Date());
	}

}
