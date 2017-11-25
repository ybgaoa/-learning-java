package com.thread.sample.sample18;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
	private String name;
	public Task(String name){
		this.name = name;
	}
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
