package com.thread.sample.ConcurrentCollections01;

import java.util.concurrent.ConcurrentLinkedDeque;
//创建一个名为PollTask的类
public class PollTask implements Runnable {
	//声明一个私有的ConcurrentLinkedDeque属性list
	private ConcurrentLinkedDeque<String> list;
	
	public PollTask(ConcurrentLinkedDeque<String> list){
		this.list = list;
	}
	//实现run()方法。这个方法将列表中的10000个字符串取出，总共取5000次，每次取两个元素
	@Override
	public void run() {
		for(int i=0;i<5000;i++){
			//该方法返回并移除列表中的第一个元素
			list.pollFirst();
			//该方法返回并移除列表中的最后一个元素
			list.pollLast();
		}
		
	}

}
