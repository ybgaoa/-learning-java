package com.thread.sample.sample04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	//声明一个ThreadLocal对象。这个对象是在initialValue()方法中隐式实现的。这个方法将返回当前日期
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue(){
			return new Date();
		}
	};
	//实现run()方法。它跟UnsafeTask类的run()方法实现了一样的功能，但是访问startDate属性的方式改变了
	@Override
	public void run() {
		System.out.println("starting thread:"+Thread.currentThread().getId()+":"+startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread finished:"+Thread.currentThread().getId()+":"+startDate.get());
	}

}
