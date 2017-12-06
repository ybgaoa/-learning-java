package com.thread.sample.Customizing02;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//ʵ�ֻ������ȼ���Executor��
public class Main {
	public static void main(String[] args) {
		//����ThreadPoolExecutor����
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
		//����4�����񣬲���ִ������ִ��
		for(int i=0;i<4;i++){
			MyPriorityTask task = new MyPriorityTask("task-"+i,i);
			executor.execute(task);
		}
		//1.��ǰ�߳�����1��
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ٴδ���4������ִ������
		for(int i=4;i<8;i++){
			MyPriorityTask task = new MyPriorityTask("task-"+i,i);
			executor.execute(task);
		}
		//�ر�ִ����
		executor.shutdown();
		
		try {
			//�ȴ�ִ��������
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main:end of the program");
	}

}
