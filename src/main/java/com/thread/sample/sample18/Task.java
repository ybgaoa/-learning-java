package com.thread.sample.sample18;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
//创建一个任务类
public class Task implements Callable<Result> {
	private String name;
	public Task(String name){
		this.name = name;
	}
	//实现call()方法，这个方法将返回一个Result类型的对象
	@Override
	public Result call() throws Exception {
		System.out.println(name+":starting");
		long duration = (long)(Math.random()*10);
		System.out.println(name+":waiting "+duration+" seconds for results");
		TimeUnit.SECONDS.sleep(duration);
		
		int value = 0;
		for(int i=0;i<5;i++){
			value += (int)(Math.random()*100);
		}
		Result result = new Result();
		result.setName(this.name);
		result.setValue(value);
		System.out.println(this.name+":ends");
		return result;
	}

}
