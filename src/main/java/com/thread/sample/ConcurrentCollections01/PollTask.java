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
			//�÷������ز��Ƴ��б��еĵ�һ��Ԫ��
			list.pollFirst();
			//�÷������ز��Ƴ��б��е����һ��Ԫ��
			list.pollLast();
		}
		
	}

}
