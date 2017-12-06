package com.thread.sample.sample22;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
//������ִ�����б��ܾ�������
public class Main {

	public static void main(String[] args) {
		RejectedController controller = new RejectedController();
		//ͨ��Executors�������newCachedThreadPool()��������һ��ThreadPoolExecutorִ��������
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		System.out.println("main:starting");
		for(int i=0;i<3;i++){
			Task task = new Task("task-"+i);
			executor.submit(task);
		}
		System.out.println("main:shutting down the executor");
		executor.shutdown();
		
		System.out.println("main:sending another task");
		Task antherTask = new Task("rejectedTask");
		executor.submit(antherTask);
		System.out.println("main:end");
	}

}
