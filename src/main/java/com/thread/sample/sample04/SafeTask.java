package com.thread.sample.sample04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	//����һ��ThreadLocal���������������initialValue()��������ʽʵ�ֵġ�������������ص�ǰ����
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue(){
			return new Date();
		}
	};
	//ʵ��run()����������UnsafeTask���run()����ʵ����һ���Ĺ��ܣ����Ƿ���startDate���Եķ�ʽ�ı���
	@Override
	public void run() {
		System.out.println("starting thread:"+Thread.currentThread().getId()+":"+startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread finished:"+Thread.currentThread().getId()+":"+startDate.get());
	}

}
