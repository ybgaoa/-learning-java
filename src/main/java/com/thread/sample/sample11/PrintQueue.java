package com.thread.sample.sample11;

import java.util.concurrent.Semaphore;

public class PrintQueue {
	//����һ���ź�������
	private final Semaphore semaphore;
	public PrintQueue(){
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document){
		try {
			//��ȡ�ź���
			semaphore.acquire();
			long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue:printing a Job during "+ duration);
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ͷ��ź���
			semaphore.release();
		}
	}
}
