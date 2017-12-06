package com.thread.sample.ConcurrentCollections03;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable {
	private int id;
	//声明一个私有的PriorityBlockingQueue属性queue，用来存放task生成的event
	private PriorityBlockingQueue<Event> queue;
	
	public Task(int id,PriorityBlockingQueue<Event> queue){
		this.id = id;
		this.queue = queue;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			Event event = new Event(id,i);
			queue.add(event);
		}
	}
}
