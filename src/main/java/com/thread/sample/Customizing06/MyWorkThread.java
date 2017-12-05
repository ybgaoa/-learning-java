package com.thread.sample.Customizing06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
//1.����MyWorkThread�࣬�̳�ForkJoinWorkerThread��
public class MyWorkThread extends ForkJoinWorkerThread {
	//2.����һ��˽��ThreadLocal����
	private static ThreadLocal<Integer> taskCounter = new ThreadLocal<Integer>();
	//3.ʵ�ֹ��췽��
	protected MyWorkThread(ForkJoinPool pool) {
		super(pool);
	}
	
	//4.ʵ��addTask()����
	public void addTask(){
		int counter=taskCounter.get().intValue();
		counter++;
		taskCounter.set(counter);
		System.out.println("myWorkerThread:counter:"+taskCounter.get().intValue());
	}
	//5.����onStart()����
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("myWorkerThread:"+getId()+":initializing task counter");
		taskCounter.set(0);
	}
	//6.����onTermination()����
	@Override
	protected void onTermination(Throwable exception) {
		System.out.println("myWorkerThread:"+getId()+":"+taskCounter.get());
		super.onTermination(exception);
	}
	
}
