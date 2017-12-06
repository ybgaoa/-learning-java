package com.thread.sample.ConcurrentCollections06;

import java.util.concurrent.ThreadLocalRandom;
//创建一个名为TaskLocalRandom的类
public class TaskLocalRandom implements Runnable {
	public TaskLocalRandom(){
		/**
		 * 调用ThreadLocalRandom类的current()方法
		 * current()方法是一个静态方法，返回与当前线程关联的ThreadLocalRandom对象，所以可以使用这个对象生成随机数。
		 * 如果调用这个方法的线程还没有关联随机对象，就会生成一个新的。
		 */
		ThreadLocalRandom.current();
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i=0;i<10;i++){
			System.out.println(name+":"+ThreadLocalRandom.current().nextInt(10));
		}

	}

}
