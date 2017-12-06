package com.thread.sample.forkjoin04;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
//取消任务
public class Main {

	public static void main(String[] args) {
		ArrayGenerator generator = new ArrayGenerator();
		int array[] = generator.generateArray(1000);
		TaskManager manager = new TaskManager();
		//通过默认的构造器创建一个ForkJoinPool对象
		ForkJoinPool pool = new ForkJoinPool();
		
		SearchNumberTask task = new SearchNumberTask(array,0,1000,5,manager);
		//调用execute()方法采用异步方式执行线程池中的任务
		pool.execute(task);
		//调用shutdown()方法关闭线程池
		pool.shutdown();
		try {
			//调用awaitTermination()方法等待任务执行结束
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:the program has finished");
	}

}
