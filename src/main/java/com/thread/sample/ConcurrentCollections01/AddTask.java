package com.thread.sample.ConcurrentCollections01;

import java.util.concurrent.ConcurrentLinkedDeque;
//����һ����ΪAddTask����
public class AddTask implements Runnable {
	//����һ��˽�е�ConcurrentLinkedDeque����list
	private ConcurrentLinkedDeque<String> list;
	
	public AddTask(ConcurrentLinkedDeque<String> list){
		this.list = list;
	}
	//ʵ��run()���������������10000���ַ�����ŵ��б��У���Щ�ַ����ɵ�ǰִ��������̵߳����ƺ��������
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i=0;i<10000;i++){
			list.add(name+":Element-"+i);
		}

	}

}
