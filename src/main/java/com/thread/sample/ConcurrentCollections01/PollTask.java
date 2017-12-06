package com.thread.sample.ConcurrentCollections01;

import java.util.concurrent.ConcurrentLinkedDeque;
//����һ����ΪPollTask����
public class PollTask implements Runnable {
	//����һ��˽�е�ConcurrentLinkedDeque����list
	private ConcurrentLinkedDeque<String> list;
	
	public PollTask(ConcurrentLinkedDeque<String> list){
		this.list = list;
	}
	//ʵ��run()����������������б��е�10000���ַ���ȡ�����ܹ�ȡ5000�Σ�ÿ��ȡ����Ԫ��
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
