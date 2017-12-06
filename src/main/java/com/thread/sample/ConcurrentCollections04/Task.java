package com.thread.sample.ConcurrentCollections04;

import java.util.Date;
import java.util.concurrent.DelayQueue;
//创建一个名为Task的类
public class Task implements Runnable {
	private int id;
	//声明私有DelayQueue类的属性queue
	private DelayQueue<Event> queue;
	
	public Task(int id,DelayQueue<Event> queue){
		this.id = id;
		this.queue = queue;
	}
	@Override
	public void run() {
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime()+(id*1000));
		System.out.println("thread:"+id+":"+delay);
		
		for(int i=0;i<100;i++){
			Event event = new Event(delay);
			queue.add(event);
		}
	}

}
