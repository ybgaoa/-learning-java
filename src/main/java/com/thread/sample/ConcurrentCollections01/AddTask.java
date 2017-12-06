package com.thread.sample.ConcurrentCollections01;

import java.util.concurrent.ConcurrentLinkedDeque;
//创建一个名为AddTask的类
public class AddTask implements Runnable {
	//声明一个私有的ConcurrentLinkedDeque属性list
	private ConcurrentLinkedDeque<String> list;
	
	public AddTask(ConcurrentLinkedDeque<String> list){
		this.list = list;
	}
	//实现run()方法。这个方法将10000个字符串存放到列表中，这些字符串由当前执行任务的线程的名称和数字组成
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i=0;i<10000;i++){
			list.add(name+":Element-"+i);
		}

	}

}
