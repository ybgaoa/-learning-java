package com.thread.sample.Customizing09;

import java.util.concurrent.TimeUnit;
//实行基于优先级的传输队列
public class Main {
	public static void main(String[] args) {
		MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<Event>();
		Producer producer = new Producer(buffer);
		Thread producerThreads[] = new Thread[10];
		for(int i=0;i<producerThreads.length;i++){
			producerThreads[i] = new Thread(producer);
			producerThreads[i].start();
		}
		
		Consumer consumer = new Consumer(buffer);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		
		System.out.println("main:buffer:consumer count:"+buffer.getWaitingConsumerCount());
		Event myEvent = new Event("core event",0);
		try {
			buffer.transfer(myEvent);
			System.out.println("main:my event has been transfered");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<producerThreads.length;i++){
			try {
				producerThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:buffer:consumer count:"+buffer.getWaitingConsumerCount());
		myEvent = new Event("core Event 2",0);
		try {
			buffer.transfer(myEvent);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			consumerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:end of the program");
	}

}
