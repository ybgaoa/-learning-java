package com.thread.sample.sample18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//���ж�����񲢴������н��
public class Main {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Task> taskList = new ArrayList<>();
		for(int i=0;i<3;i++){
			Task task = new Task("task-"+i);
			taskList.add(task);
		}
		List<Future<Result>> resultList = null;
		try {
			//����������ִ����ɣ����߳�ʱ��ʱ��������������ر�������״̬�ͽ�����б�
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("Main:printing the results");
		for(int i=0;i<resultList.size();i++){
			Future<Result> future = resultList.get(i);
			try {
				Result result = future.get();
				System.out.println(result.getName()+":"+result.getValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
