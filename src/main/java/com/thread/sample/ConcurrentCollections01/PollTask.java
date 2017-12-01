package com.thread.sample.ConcurrentCollections01;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable {
	private ConcurrentLinkedDeque<String> list;
	public PollTask(ConcurrentLinkedDeque<String> list){
		this.list = list;
	}
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
