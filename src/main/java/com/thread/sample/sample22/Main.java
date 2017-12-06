package com.thread.sample.sample22;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
//处理在执行器中被拒绝的任务
public class Main {

	public static void main(String[] args) {
		RejectedController controller = new RejectedController();
		//通过Executors工厂类的newCachedThreadPool()方法创建一个ThreadPoolExecutor执行器对象
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		System.out.println("main:starting");
		for(int i=0;i<3;i++){
			Task task = new Task("task-"+i);
			executor.submit(task);
		}
		System.out.println("main:shutting down the executor");
		executor.shutdown();
		
		System.out.println("main:sending another task");
		Task antherTask = new Task("rejectedTask");
		executor.submit(antherTask);
		System.out.println("main:end");
	}

}
