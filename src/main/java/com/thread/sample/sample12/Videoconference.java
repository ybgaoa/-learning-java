package com.thread.sample.sample12;

import java.util.concurrent.CountDownLatch;
//创建视频会议类，这个类实现的是一个视频会议系统
public class Videoconference implements Runnable {
	//声明一个CountDownLatch对象
	private final CountDownLatch controller;
	
	public Videoconference(int number){
		//初始化CountDownLatch对象，定义必须等待的先行完成的操作的数目
		controller = new CountDownLatch(number);
	}
	public void arrive(String name){
		System.out.println(name+" has arrvied");
		//事情完成，调用countDown()方法将CountDownLatch类的内部计数器减1。每个被等待的事件在完成的时候调用
		controller.countDown();
		System.out.println("Videoconference:waiting for "+controller.getCount()+" participants");
	}
	@Override
	public void run() {
		System.out.println("Videoconference:Initialization "+controller.getCount()+" participants");
		try {
			//使用await()方法等待所有的与会者到达。需要等待其他事件先完成的线程调用
			controller.await();
			System.out.println("Videoconference:All the participants have come");
			System.out.println("Videoconference:Let's start...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
