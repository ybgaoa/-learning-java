package com.thread.sample.sample22;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String name;
	public Task(String name){
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("task "+name+":starting");
		long duration = (long)(Math.random()*10);
		System.out.println("task:duration:"+duration);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task:"+name+":ending");
	}
	public String toString(){
		return name;
	}
}
