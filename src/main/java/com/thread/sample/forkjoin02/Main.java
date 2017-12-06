package com.thread.sample.forkjoin02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
//合并任务的结果
public class Main {
	public static void main(String[] args) {
		DocumentMock mock = new DocumentMock();
		String[][] document = mock.generateDocument(100, 1000, "the");
		DocumentTask task = new DocumentTask(document,0,100,"the");
		//采用无参的构造器创建一个ForkJoinPool对象
		ForkJoinPool pool = new ForkJoinPool();
		//然后调用execute()方法在线程池里执行这个任务
		pool.execute(task);
		do{
			System.out.println("*************************");
			System.out.println("main:parallelism:"+pool.getParallelism());
			System.out.println("main:active threads:"+pool.getActiveThreadCount());
			System.out.println("main:task count:"+pool.getQueuedTaskCount());
			System.out.println("main:steal count:"+pool.getStealCount());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!task.isDone());
		//调用shutdown()方法关闭线程池
		pool.shutdown();
		try {
			//调用awaitTermination()方法等待任务执行结束
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("main:the word appears "+task.get()+" in the cocument");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
