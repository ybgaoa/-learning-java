package com.thread.sample.Customizing04;

import java.util.Date;

//实现ThreadFactory接口生成定制线程
//1.创建MyThread类，并继承Thread类
public class MyThread extends Thread {
	//2.声明三个私有Date属性
	private Date creationDate;
	private Date startDate;
	private Date finishDate;
	
	//3.实现构造方法
	public MyThread(Runnable target,String name){
		super(target,name);
		setCreationDate();
	}
	
	//4.实现一个方法来设置creationDate属性的值
	public void setCreationDate(){
		creationDate = new Date();
	}
	//5.实现一个方法来设置startDate属性的值
	public void setStartDate(){
		startDate = new Date();
	}
	//6.实现一个方法来设置finishDate属性的值
	public void setFinishDate(){
		finishDate = new Date();
	}
	//7.实现run()方法。保存线程的开始时间，然后调用父类的run方法，保存执行的结束时间。
	@Override
	public void run() {
		setStartDate();
		super.run();
		setFinishDate();
	}
	//8.实现一个getExecutionTime()方法，用来计算线程开始和结束的时间差。
	public long getExecutionTime(){
		return finishDate.getTime() - startDate.getTime();
	}
	//9.覆盖toString()方法。
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(getName());
		buffer.append(":");
		buffer.append("creation date:");
		buffer.append(creationDate);
		buffer.append("running date:");
		buffer.append(getExecutionTime());
		buffer.append(" milliseconds");
		return buffer.toString();
	}
}
