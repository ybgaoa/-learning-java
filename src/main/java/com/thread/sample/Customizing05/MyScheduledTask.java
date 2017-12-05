package com.thread.sample.Customizing05;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//定制运行在定时线程池中的任务
//1.创建MyScheduledTask类，继承FutureTask类，并实现RunnableScheduledFuture接口
public class MyScheduledTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
	//2.声明一个名称为task的私有RunnableScheduledFuture对象属性
	private RunnableScheduledFuture<V> task;
	//3.声明一个名称为executor的私有ScheduledThreadPoolExecutor对象属性
	private ScheduledThreadPoolExecutor executor;
	//4.声明一个名为period的私有long属性
	private long period;
	//5.声明一个名为startDate的私有long属性
	private long startDate;
	//6.实现构造器
	public MyScheduledTask(Runnable runnable, V result,RunnableScheduledFuture<V> task,ScheduledThreadPoolExecutor executor) {
		super(runnable, result);
		this.task = task;
		this.executor = executor;
	}
	//7.实现getDelay()方法。如果是周期性任务且startDate属性值不等于0，则计算startDate属性和当前时间的时间差作为返回值。
	//否则返回存放在task属性中的延迟值。
	@Override
	public long getDelay(TimeUnit unit) {
		if(!isPeriodic()){
			return task.getDelay(unit);
		}else{
			if(startDate==0){
				return task.getDelay(unit);
			}else{
				Date now = new Date();
				long delay = startDate - now.getTime();
				return unit.convert(delay, TimeUnit.MILLISECONDS);
			}
		}
	}
	//8.实现compareTo()方法
	@Override
	public int compareTo(Delayed o) {
		return task.compareTo(o);
	}
	//9.实现isPeriodic()方法
	@Override
	public boolean isPeriodic() {
		return task.isPeriodic();
	}
	//10.实现setPeriod()方法来设置任务的周期
	public void setPeriod(long period){
		this.period = period;
	}
	
	//11.实现run()方法。如果是周期性任务，则需要用任务下一次执行的开始时间更新它的startDate属性，
	//即用当前时间加上周期间隔作为下一次执行的开始时间。然后，再次增加任务到ScheduledThreadPoolExecutor对象的队列中。
	@Override
	public void run() {
		if(isPeriodic()&&(!executor.isShutdown())){
			Date now = new Date();
			startDate = now.getTime()+period;
			executor.getQueue().add(this);
		}
		System.out.println("Pre-MyScheduledTask:"+new Date());
		System.out.println("MyScheduledTask:is periodic:"+isPeriodic());
		super.runAndReset();
		System.out.println("Post-MyScheduledTask:"+new Date());
	}
}
