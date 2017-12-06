package com.thread.sample.ConcurrentCollections06;

import java.util.concurrent.ThreadLocalRandom;
//����һ����ΪTaskLocalRandom����
public class TaskLocalRandom implements Runnable {
	public TaskLocalRandom(){
		/**
		 * ����ThreadLocalRandom���current()����
		 * current()������һ����̬�����������뵱ǰ�̹߳�����ThreadLocalRandom�������Կ���ʹ��������������������
		 * �����������������̻߳�û�й���������󣬾ͻ�����һ���µġ�
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
