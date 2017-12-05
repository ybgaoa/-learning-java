package com.thread.sample.Customizing08;

import java.util.concurrent.TimeUnit;
//实现定制lock类
public class Main {
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		for(int i=0;i<10;i++){
			Task task = new Task("task-"+i,lock);
			Thread thread = new Thread(task);
			thread.start();
		}
		boolean value;
		do{
			try {
				value = lock.tryLock(1, TimeUnit.SECONDS);
				if(!value){
					System.out.println("main:trying to get the lock");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				value = false;
			}
		}while(!value);
		System.out.println("main:got the lock");
		lock.unlock();
		System.out.println("main:end of the program");
	}

}
