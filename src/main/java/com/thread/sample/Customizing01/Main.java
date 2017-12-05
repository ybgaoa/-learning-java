package com.thread.sample.Customizing01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		//创建MyExecutor对象
		MyExecutor myExecutor = new MyExecutor(2,4,1000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
		//创建Future对象列表results
		List<Future<String>> results = new ArrayList<>();
		//提交10个task对象
		for(int i=0;i<10;i++){
			SleepTwoSecondsTask task = new SleepTwoSecondsTask();
			Future<String> result = myExecutor.submit(task);
			results.add(result);
		}
		//使用get()方法得到前5个任务的执行结果，并将结果输出到控制台
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
		
		//使用shutdown()方法完成executor的执行
		myExecutor.shutdown();
		
		//使用get()方法得到后面5个任务的执行结果，并将结果输出到控制台。
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
		
		//使用awaitTermination()方法等待执行器的完成。
		try {
			myExecutor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main:end of the program");
	}

}
