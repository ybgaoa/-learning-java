package com.thread.sample.sample11;

import java.util.concurrent.Semaphore;
//创建一个打印队列类
public class PrintQueue {
	//声明一个信号量对象
	private final Semaphore semaphore;
	public PrintQueue(){
		//初始化信号量对象，以保护对打印队列的访问。信号量的内部计数器初始值是1，所以它只能保护一个共享资源的访问
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document){
		try {
			//通过acquire()方法获取信号量
			semaphore.acquire();
			long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue:printing a Job during "+ duration);
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//通过release()释放信号量
			semaphore.release();
		}
	}
}
