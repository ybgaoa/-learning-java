package com.thread.sample.Customizing06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
//����MyRecursiveTask�࣬�̳�RecursiveTask��
public class MyRecursiveTask extends RecursiveTask<Integer>{
	private int array[];
	private int start,end;
	
	public MyRecursiveTask(int array[],int start,int end){
		this.array = array;
		this.start = start;
		this.end = end;
	}
	//ʵ��compute()���������ڶ������д���ʼλ��ָ��λ������Ԫ�����
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

	//ʵ��addResults()�����������㲢����ͨ�������������������Ľ��֮��
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
	
	//ʵ��addResults()�����������㲢����ͨ�������������������Ľ��֮��
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
