package com.thread.sample.Customizing04;

import java.util.concurrent.ThreadFactory;
//1.����MyThreadFactory�࣬ʵ��ThreadFactory�ӿ�
public class MyThreadFactory implements ThreadFactory {
	//2.����counter����
	private int counter;
	//3.����prefix����
	private String prefix;
	//4.ʵ�ֹ�����
	public MyThreadFactory(String prefix){
		this.prefix = prefix;
		counter = 1;
	}
	//5.ʵ��newThread()����������MyThread��������counter����
	@Override
	public Thread newThread(Runnable r) {
		MyThread myThread = new MyThread(r,prefix+"-"+counter);
		counter++;
		return myThread;
	}

}
