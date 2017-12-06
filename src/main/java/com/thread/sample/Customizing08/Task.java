package com.thread.sample.Customizing08;

import java.util.concurrent.TimeUnit;
//创建Task类，实现Runnable接口
public class Task implements Runnable {
	private MyLock lock;
	private String name;
	public Task(String name,MyLock lock){
		this.lock = lock;
		this.name = name;
	}
	@Override
	public void run() {
		lock.lock();
		System.out.println("task:"+name+":take he lock");
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("task:"+name+":free he lock");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}

	}

}
