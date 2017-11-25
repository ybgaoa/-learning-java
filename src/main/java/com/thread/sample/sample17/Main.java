package com.thread.sample.sample17;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//在执行器中执行任务并返回结果
public class Main {
	public static void main(String[] args) {
		//执行器最多创建两个线程
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<10;i++){
			Integer number = random.nextInt(10);
			System.out.println(number);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(calculator);
			resultList.add(result);
		}
		do{
			System.out.println("main:number of completed task:"+executor.getCompletedTaskCount());
			for(int i=0;i<resultList.size();i++){
				Future<Integer> result = resultList.get(i);
				System.out.println("Main:task-"+i+":"+result.isDone());
			}
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(executor.getCompletedTaskCount()<resultList.size());//若执行器中完成的任务数量小于10，则一直重复执行这个循环
		System.out.println("main:results");
		for(int i=0;i<resultList.size();i++){
			Future<Integer> result = resultList.get(i);
			Integer number = null;
			try {
				number = result.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main:task-"+i+":"+number);
		}
	}

}
