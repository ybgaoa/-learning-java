package com.thread.sample.Customizing04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//实现ThreadFactory接口生成定制线程
public class Main {
	public static void main(String[] args) {
		MyThreadFactory threadFactory = new MyThreadFactory("myThreadFactory");
		ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
		MyTask task = new MyTask();
		executor.submit(task);
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:end of hte program");
	}

}
