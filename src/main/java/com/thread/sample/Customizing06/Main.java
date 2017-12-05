package com.thread.sample.Customizing06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		MyWorkerThreadFactory factory = new MyWorkerThreadFactory();
		ForkJoinPool pool = new ForkJoinPool(4,factory,null,false);
		int array[] = new int[10];
		for(int i=0;i<array.length;i++){
			array[i] = 1;
		}
		MyRecursiveTask task = new MyRecursiveTask(array,0,array.length);
		pool.execute(task);
		task.join();
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("main:result:"+task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:end of the program");
	}

}
