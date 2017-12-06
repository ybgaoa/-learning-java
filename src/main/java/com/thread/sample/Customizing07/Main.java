package com.thread.sample.Customizing07;

import java.util.concurrent.ForkJoinPool;
//定制运行在Fork/Join框架中的任务
public class Main {
	public static void main(String[] args) {
		int array[] = new int[10000];
		ForkJoinPool pool = new ForkJoinPool();
		Task task = new Task("Task",array,0,array.length);
		pool.invoke(task);
		pool.shutdown();
		System.out.println("main:end of the program");
	}

}
