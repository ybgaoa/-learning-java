package com.thread.sample.Customizing06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
//1.创建MyWorkThread类，继承ForkJoinWorkerThread类
public class MyWorkThread extends ForkJoinWorkerThread {
	//2.声明一个私有ThreadLocal属性
	private static ThreadLocal<Integer> taskCounter = new ThreadLocal<Integer>();
	//3.实现构造方法
	protected MyWorkThread(ForkJoinPool pool) {
		super(pool);
	}
	
	//4.实现addTask()方法
	public void addTask(){
		int counter=taskCounter.get().intValue();
		counter++;
		taskCounter.set(counter);
		System.out.println("myWorkerThread:counter:"+taskCounter.get().intValue());
	}
	//5.覆盖onStart()方法
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("myWorkerThread:"+getId()+":initializing task counter");
		taskCounter.set(0);
	}
	//6.覆盖onTermination()方法
	@Override
	protected void onTermination(Throwable exception) {
		System.out.println("myWorkerThread:"+getId()+":"+taskCounter.get());
		super.onTermination(exception);
	}
	
}
