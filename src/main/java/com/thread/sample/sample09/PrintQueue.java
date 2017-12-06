package com.thread.sample.sample09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//创建一个打印队列类PrintQueue
public class PrintQueue {
	//声明一个锁对象，并且用ReentrantLock类进行初始化
	private final Lock queueLock = new ReentrantLock();
	public void printJob(Object document){
		//通过调用lock()方法获取对锁对象的控制
		queueLock.lock();
		try {
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+": PrintQueue:printing a Job during"+(duration/1000)+" seconds");
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//通过调用unlock()释放对锁对象的控制
			queueLock.unlock();
		}
	}
}
