package com.thread.sample.sample20;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
//��ִ������������ִ������
public class Main {

	public static void main(String[] args) {
		//ͨ��Executors�������newScheduledThreadPool()��������һ��ScheduledExecutorServiceִ������������1��Ϊ����
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		System.out.println("Main:starting at:"+new Date());
		Task task = new Task("task");
		//��������˵����1.����������ִ�е�����2.�����һ��ִ�к����ʱʱ�䣻3.����ִ�е�ʱ�����ڣ�4.�ڶ����͵����������ĵ�λ
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 10, TimeUnit.SECONDS);
		
		for(int i=0;i<10;i++){
			//����ScheduledFuture���getDelay()��������ȡ��һ�ν�Ҫִ�е�ʱ��
			System.out.println("main:delay:"+result.getDelay(TimeUnit.MILLISECONDS));
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�ر�ִ����
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:finished at:"+new Date());
	}

}
