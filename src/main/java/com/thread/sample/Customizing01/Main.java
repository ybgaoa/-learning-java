package com.thread.sample.Customizing01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		//����MyExecutor����
		MyExecutor myExecutor = new MyExecutor(2,4,1000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
		//����Future�����б�results
		List<Future<String>> results = new ArrayList<>();
		//�ύ10��task����
		for(int i=0;i<10;i++){
			SleepTwoSecondsTask task = new SleepTwoSecondsTask();
			Future<String> result = myExecutor.submit(task);
			results.add(result);
		}
		//ʹ��get()�����õ�ǰ5�������ִ�н��������������������̨
		for(int i=0;i<5;i++){
			try {
				String result = results.get(i).get();
				System.out.println("main:result for task "+i+":"+result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ʹ��shutdown()�������executor��ִ��
		myExecutor.shutdown();
		
		//ʹ��get()�����õ�����5�������ִ�н��������������������̨��
		for(int i=5;i<10;i++){
			try {
				String result = results.get(i).get();
				System.out.println("main:result for task "+i+":"+result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ʹ��awaitTermination()�����ȴ�ִ��������ɡ�
		try {
			myExecutor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main:end of the program");
	}

}
