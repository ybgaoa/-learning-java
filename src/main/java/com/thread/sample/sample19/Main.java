package com.thread.sample.sample19;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//��ִ��������ʱִ������
public class Main {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
		System.out.println("main:starting at:"+new Date());
		for(int i=0;i<5;i++){
			Task task = new Task("task-"+i);
			//��������˵����1.����ִ�е�����2.����ִ��ǰ��Ҫ�ȴ���ʱ�䣻3.�ȴ�ʱ��ĵ�λ����TimeUint���һ��������ָ��
			executor.schedule(task, i+1, TimeUnit.SECONDS);
		}
		executor.shutdown();
		try {
			//����ִ����awaitTermination()�����ȴ������������
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:ends at:"+new Date());
	}

}
