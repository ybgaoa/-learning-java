package com.thread.sample.sample12;

import java.util.concurrent.CountDownLatch;
//������Ƶ�����࣬�����ʵ�ֵ���һ����Ƶ����ϵͳ
public class Videoconference implements Runnable {
	//����һ��CountDownLatch����
	private final CountDownLatch controller;
	
	public Videoconference(int number){
		//��ʼ��CountDownLatch���󣬶������ȴ���������ɵĲ�������Ŀ
		controller = new CountDownLatch(number);
	}
	public void arrive(String name){
		System.out.println(name+" has arrvied");
		//������ɣ�����countDown()������CountDownLatch����ڲ���������1��ÿ�����ȴ����¼�����ɵ�ʱ�����
		controller.countDown();
		System.out.println("Videoconference:waiting for "+controller.getCount()+" participants");
	}
	@Override
	public void run() {
		System.out.println("Videoconference:Initialization "+controller.getCount()+" participants");
		try {
			//ʹ��await()�����ȴ����е�����ߵ����Ҫ�ȴ������¼�����ɵ��̵߳���
			controller.await();
			System.out.println("Videoconference:All the participants have come");
			System.out.println("Videoconference:Let's start...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
