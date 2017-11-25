package com.thread.sample.sample19;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	private String name;
	public Task(String name){
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println(name+":starting at "+ new Date());
		return "Hello,world";
	}

}
