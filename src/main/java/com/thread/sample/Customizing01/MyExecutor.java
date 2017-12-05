package com.thread.sample.Customizing01;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//定制ThreadPoolExecutor类
//1.创建MyExecutor类，并继承ThreadPoolExecutor类
public class MyExecutor extends ThreadPoolExecutor {
	//2.声明一个私有ConcurrentHashMap属性，名称为startTimes
	private ConcurrentHashMap<String, Date> startTimes;
	//3.实现构造器，使用super关键字调用父类的构造器，然后初始化startTimes属性
	public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		startTimes = new ConcurrentHashMap();
	}
	//4.覆盖shutdown()方法。将已执行过的任务、正在执行的任务和等待执行的任务的信息输出到控制台。
	//接下来，使用super关键字调用父类的shutdown()方法。
	@Override
	public void shutdown() {
		System.out.println("*****************shutdown()*****************");
		System.out.println("myExecutor:going to shutdown");
		System.out.println("myExecutor:executed tasks:"+getCompletedTaskCount());
		System.out.println("myExecutor:running tasks:"+getActiveCount());
		System.out.println("myExecutor:pending tasks:"+getQueue().size());
		super.shutdown();
	}
	//5.覆盖shutdownNow()方法。将已经执行过的任务、正在执行的任务和等待执行的任务的信息输出到控制台。
	//接下来，使用super关键字调用父类的shutdownNow()方法。
	@Override
	public List<Runnable> shutdownNow() {
		System.out.println("*****************shutdownNow()*****************");
		System.out.println("myExecutor:going to immediately shutdown");
		System.out.println("myExecutor:executed tasks:"+getCompletedTaskCount());
		System.out.println("myExecutor:running tasks:"+getActiveCount());
		System.out.println("myExecutor:pending tasks:"+getQueue().size());
		return super.shutdownNow();
	}
	//6.覆盖beforeExecute()方法。输出将要执行的线程的名字、任务的哈希码、开始日期存放到HashMap中，它是以任务的哈希码值作为主键的。
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("*****************beforeExecute()*****************");
		System.out.println("myExecutor:A task is beginning:"+t.getName()+":"+r.hashCode());
		startTimes.put(String.valueOf(r.hashCode()), new Date());
	}
	//7.覆盖afterExecute()方法。将任务的执行结果输出到控制台，用当前时间减去存放在并发HashMap中的起始日期来计算任务的运行时间。
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("*****************afterExecute()*****************");
		Future<?> result = (Future<?>) r;
		System.out.println("myExecutor:A task is fininshing");
		try {
			System.out.println("myExecutor:result:"+result.get());
			Date startDate = startTimes.remove(String.valueOf(r.hashCode()));
			Date finishDate = new Date();
			long diff = finishDate.getTime()-startDate.getTime();
			System.out.println("myExecutor:duration:"+diff);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
