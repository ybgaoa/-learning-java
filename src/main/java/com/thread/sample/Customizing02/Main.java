package com.thread.sample.Customizing02;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//实现基于优先级的Executor类
public class Main {
	public static void main(String[] args) {
		//创建ThreadPoolExecutor对象
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
		//创建4个任务，并在执行器中执行
		for(int i=0;i<4;i++){
			MyPriorityTask task = new MyPriorityTask("task-"+i,i);
			executor.execute(task);
		}
		//1.当前线程休眠1秒
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//再次创建4个任务到执行器中
		for(int i=4;i<8;i++){
			MyPriorityTask task = new MyPriorityTask("task-"+i,i);
			executor.execute(task);
		}
		//关闭执行器
		executor.shutdown();
		
		try {
			//等待执行器结束
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main:end of the program");
	}

}
