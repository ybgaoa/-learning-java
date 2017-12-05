package com.thread.sample.Customizing04;

import java.util.concurrent.ThreadFactory;
//1.创建MyThreadFactory类，实现ThreadFactory接口
public class MyThreadFactory implements ThreadFactory {
	//2.声明counter属性
	private int counter;
	//3.声明prefix属性
	private String prefix;
	//4.实现构造器
	public MyThreadFactory(String prefix){
		this.prefix = prefix;
		counter = 1;
	}
	//5.实现newThread()方法。创建MyThread对象并增加counter属性
	@Override
	public Thread newThread(Runnable r) {
		MyThread myThread = new MyThread(r,prefix+"-"+counter);
		counter++;
		return myThread;
	}

}
