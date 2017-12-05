package com.thread.sample.Customizing03;

public class Main {
	public static void main(String[] args) {
		//����MyThreadFactory����
		MyThreadFactory myFactory = new MyThreadFactory("myThreadFactory");
		//����MyTask����
		MyTask task = new MyTask();
		//ʹ�ù�����newThread()��������MyThread������ִ������
		Thread thread = myFactory.newThread(task);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:thread information");
		System.out.println(thread);
		System.out.println("main:end of the example");
	}

}
