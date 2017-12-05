package com.thread.sample.Customizing07;

import java.util.Date;
import java.util.concurrent.ForkJoinTask;
//定制运行在Fork/Join框架中的任务
//1.创建MyWorkerTask类，继承ForkJoinTask类
public abstract class MyWorkerTask extends ForkJoinTask<Void> {
	private String name;
	//2.实现构造方法
	public MyWorkerTask(String name){
		this.name = name;
	}
	//3.实现getRawResult()方法。这是一个ForkJoinTask类的抽象方法，当MyWorkerTask任务不返回任何结果时，这个方法必须返回null值。
	@Override
	public Void getRawResult() {
		return null;
	}
	//4.实现setRawResult()方法。这是ForkJoinTask类的另一个抽象方法，用于当MyWorkerTask任务不返回任何结果时，设置方法体为空。
	@Override
	protected void setRawResult(Void value) {		
	}
	//5.实现exec()方法。这是类的主方法。计算这个方法的执行时间并输出到控制台。
	@Override
	protected boolean exec() {
		Date startDate = new Date();
		compute();
		Date finishDate = new Date();
		long diff = finishDate.getTime() - startDate.getTime();
		System.out.println("MyWorkerTask:"+name+":"+diff+"milliseconds to complete");
		return true;
	}
	
	public String getName(){
		return name;
	}
	
	protected abstract void compute();

}
