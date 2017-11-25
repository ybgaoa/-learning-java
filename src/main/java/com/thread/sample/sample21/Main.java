package com.thread.sample.sample21;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;
//在执行器中取消任务
public class Main {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		Task task = new Task();
		System.out.println("main:executing the task");
		Future<String> result = executor.submit(task);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:canceling the task");
		//调用Future类的cancel()方法来取消任务的执行
		result.cancel(true);
		System.out.println("main:cancelled:"+result.isCancelled());
		System.out.println("main:Done:"+result.isDone());
		executor.shutdown();
		System.out.println("main:the executor has finished");
	}

}
