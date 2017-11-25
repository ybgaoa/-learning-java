package com.thread.sample.sample16;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	//����ThreadPoolExecutor�����
	private ThreadPoolExecutor executor;
	public Server(){
		//ͨ��Executors������ʼ��ThreadPoolExecutor��Ķ��󣬴���ִ�����̳߳�
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public void executeTask(Task task){
		System.out.println("server:a new task has arrived");
		//һ��������ִ�������Ϳ���ʹ��ִ������execute()����������Runnable����Callable���͵�����
		executor.execute(task);
		System.out.println("server:pool size:"+executor.getPoolSize());//����ִ�����̳߳���ʵ�ʵ��߳���
		System.out.println("server:active count:"+executor.getActiveCount());//����ִ����������ִ��������߳���
		System.out.println("server:completed tasks:"+executor.getCompletedTaskCount());//����ִ�����Ѿ���ɵ�������
	}
	
	public void endServer(){
		//ִ�����Լ�ThreadPoolExecutor��һ����Ҫ�������ǣ�ͨ����Ҫ��ʾ��ȥ��������
		//���������������ôִ����������ִ�У�����Ҳ������������ִ����û�������ִ���ˣ����������ȴ�������ĵ��������������ִ�С�
		//javaӦ�ó��򲻻����ֱ�����з��ػ��߳̽������ǵ����У���ˣ����û����ִֹ������Ӧ�ó�����Զ���������
		executor.shutdown();
	}
}
