package com.thread.sample.forkjoin03;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
//�첽��������
public class Main {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		FolderProcessor system = new FolderProcessor("c:\\Windows","log");
		FolderProcessor apps = new FolderProcessor("c:\\Program Files","log");
		FolderProcessor documents = new FolderProcessor("c:\\Documents and Settings","log");
		//����execute()��������3����ʼ�����̳߳���
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);
		
		do{
			/**
			 * ForkJoinPool���е����·�����
			    getPoolSize(): �˷������� int ֵ������ForkJoinPool�ڲ��̳߳ص�worker�߳��ǵ�������
			    getParallelism(): �˷������سصĲ��еļ���
			    getActiveThreadCount(): �˷������ص�ǰִ��������̵߳�������
			    getRunningThreadCount():�˷�������û�б��κ�ͬ���������������ڹ������̡߳�
			    getQueuedSubmissionCount(): �˷��������Ѿ��ύ���ػ�û�п�ʼ���ǵ�ִ�е���������
			    getQueuedTaskCount(): �˷��������Ѿ��ύ�����Ѿ���ʼ���ǵ�ִ�е���������
			    hasQueuedSubmissions(): �˷������� Boolean ֵ������������Ƿ���queued����û�п�ʼ���ǵ�ִ�С�
			    getStealCount(): �˷������� long ֵ��worker �߳��Ѿ�����һ���߳�͵ȡ����ʱ������
			    isTerminated(): �˷������� Boolean ֵ������ fork/join ���Ƿ��Ѿ����ִ�С�
			 */
			System.out.println("**************************************");
			System.out.println("main:parallelism:"+pool.getParallelism());
			System.out.println("main:active threads:"+pool.getActiveThreadCount());
			System.out.println("main:task count:"+pool.getQueuedTaskCount());
			System.out.println("main:steal count:"+pool.getStealCount());
			System.out.println("***************************************");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while((!system.isDone())||(!apps.isDone())||(!documents.isDone()));
		//�ر��̳߳�
		pool.shutdown();
		
		List<String> results;
		//����Join()�����ȴ����͵��̳߳��е�����������ִ����ɡ�
		results = system.join();
		System.out.println("main:system:"+results.size()+" files found");
		results = apps.join();
		System.out.println("main:apps:"+results.size()+" files found");
		results = documents.join();
		System.out.println("main:documents:"+results.size()+" files found");
	}

}
