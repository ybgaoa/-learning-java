package com.thread.sample.sample09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//����һ����ӡ������PrintQueue
public class PrintQueue {
	//����һ�������󣬲�����ReentrantLock����г�ʼ��
	private final Lock queueLock = new ReentrantLock();
	public void printJob(Object document){
		//ͨ������lock()������ȡ��������Ŀ���
		queueLock.lock();
		try {
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+": PrintQueue:printing a Job during"+(duration/1000)+" seconds");
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//ͨ������unlock()�ͷŶ�������Ŀ���
			queueLock.unlock();
		}
	}
}
