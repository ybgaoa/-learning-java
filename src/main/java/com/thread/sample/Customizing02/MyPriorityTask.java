package com.thread.sample.Customizing02;

import java.util.concurrent.TimeUnit;

//实现基于优先级的Executor类
//1.创建MyPriorityTask类，并实现Runnable和Comparable接口 
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
	//2.声明属性 priority
	private int priority;
	//3.声明属性 name
	private String name;
	
	//4.实现构造器用来初始化属性
	public MyPriorityTask(String name,int priority){
		this.name = name;
		this.priority = priority;
	}
	//5.实现一个方法返回优先级属性的值
	public int getPriority(){
		return priority;
	}
	//6.实现在Comparable接口中声明compareTo()方法。它接收一个MyPriorityTask对象作为参数，然后比较当前和参数对象的优先级值。
	//让高优先级的任务先于低优先级的任务执行。
	@Override
	public int compareTo(MyPriorityTask o) {
		if(this.getPriority()<o.getPriority()){
			return 1;
		}
		if(this.getPriority()>o.getPriority()){
			return -1;
		}
		return 0;
	}
	//7.实现run()方法，使当前线程休眠2秒
	@Override
	public void run() {
		System.out.println("myPriorityTask:"+name+":priority:"+priority);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
