package com.thread.sample.Customizing03;

public class Main {
	public static void main(String[] args) {
		//创建MyThreadFactory对象
		MyThreadFactory myFactory = new MyThreadFactory("myThreadFactory");
		//创建MyTask对象
		MyTask task = new MyTask();
		//使用工厂的newThread()方法创建MyThread对象以执行任务
		Thread thread = myFactory.newThread(task);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:thread information");
		System.out.println(thread);
		System.out.println("main:end of the example");
	}

}
