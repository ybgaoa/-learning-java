package com.thread.sample.sample16;

import java.util.Date;
import java.util.concurrent.TimeUnit;
//创建一个任务类，实现将被web服务器执行的任务
public class Task implements Runnable {
	private Date initDate;
	private String name;
	public Task(String name){
		this.name = name;
		initDate = new Date();
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":task:"+name+":created on:"+initDate);
		System.out.println(Thread.currentThread().getName()+":task:"+name+":started on:"+new Date());
	
		Long duration = (long)(Math.random()*10);
		System.out.println(Thread.currentThread().getName()+":task:"+name+":doing a tast during:"+duration+" seconds");
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":task:"+name+":finished on:"+new Date());
	}

}
