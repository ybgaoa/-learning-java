package com.thread.sample.Customizing06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
//创建MyRecursiveTask类，继承RecursiveTask类
public class MyRecursiveTask extends RecursiveTask<Integer>{
	private int array[];
	private int start,end;
	
	public MyRecursiveTask(int array[],int start,int end){
		this.array = array;
		this.start = start;
		this.end = end;
	}
	//实现compute()方法。用于对数组中从起始位到指定位的所有元素求和
	@Override
	protected Integer compute() {
		Integer ret;
		MyWorkThread thread = (MyWorkThread) Thread.currentThread();
		thread.addTask();
		if(end-start<10){
			MyRecursiveTask task = new MyRecursiveTask(array,start,end);
			ret = addResults(task);
		}else{
			int mid = (start+end)/2;
			MyRecursiveTask task1 = new MyRecursiveTask(array,start,mid);
			MyRecursiveTask task2 = new MyRecursiveTask(array,mid,end);
			ret = this.addResults(task1, task2);
		}
		return ret;
	}

	//实现addResults()方法。它计算并返回通过参数传入的两个任务的结果之和
	private Integer addResults(MyRecursiveTask task1,MyRecursiveTask task2){
		int value = 0;
		try {
			value = task1.get().intValue()+task2.get().intValue();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	//实现addResults()方法。它计算并返回通过参数传入的两个任务的结果之和
	private Integer addResults(MyRecursiveTask task){
			int value = 0;
			try {
				value = task.get().intValue();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}
}
