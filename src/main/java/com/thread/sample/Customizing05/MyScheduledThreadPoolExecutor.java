package com.thread.sample.Customizing05;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//创建MyScheduledThreadPoolExecutor类，继承ScheduledThreadPoolExecutor类，用来执行MyScheduledTask任务
public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
	//实现构造器
	public MyScheduledThreadPoolExecutor(int corePoolSize) {
		super(corePoolSize);
	}
	//覆盖decorateTask()方法。这个方法返回MyScheduledTask任务
	@Override
	protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
		MyScheduledTask<V> myTask = new MyScheduledTask<V>(runnable, null, task, this);
		return myTask;
	}
	//覆盖scheduleAtFixedRate()方法。
	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		ScheduledFuture<?> task = super.scheduleAtFixedRate(command, initialDelay, period, unit);
		MyScheduledTask<?> myTask = (MyScheduledTask<?>) task;
		myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period, unit));
		return myTask;
	}

}
