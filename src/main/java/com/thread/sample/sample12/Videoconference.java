package com.thread.sample.sample12;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
	private final CountDownLatch controller;
	
	public Videoconference(int number){
		controller = new CountDownLatch(number);
	}
	public void arrive(String name){
		System.out.println(name+" has arrvied");
		//事情完成，调用countDown()方法将CountDownLatch类的内部计数器减1
		controller.countDown();
		System.out.println("Videoconference:waiting for "+controller.getCount()+" participants");
	}
	@Override
	public void run() {
		System.out.println("Videoconference:Initialization "+controller.getCount()+" participants");
		try {
			//使用await()方法等待所有的与会者到达
			controller.await();
			System.out.println("Videoconference:All the participants have come");
			System.out.println("Videoconference:Let's start...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
