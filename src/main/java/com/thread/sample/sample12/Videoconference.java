package com.thread.sample.sample12;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
	private final CountDownLatch controller;
	
	public Videoconference(int number){
		controller = new CountDownLatch(number);
	}
	public void arrive(String name){
		System.out.println(name+" has arrvied");
		//������ɣ�����countDown()������CountDownLatch����ڲ���������1
		controller.countDown();
		System.out.println("Videoconference:waiting for "+controller.getCount()+" participants");
	}
	@Override
	public void run() {
		System.out.println("Videoconference:Initialization "+controller.getCount()+" participants");
		try {
			//ʹ��await()�����ȴ����е�����ߵ���
			controller.await();
			System.out.println("Videoconference:All the participants have come");
			System.out.println("Videoconference:Let's start...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
