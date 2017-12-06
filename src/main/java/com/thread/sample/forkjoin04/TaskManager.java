package com.thread.sample.forkjoin04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
//创建一个名称为TaskManager的类，利用这个类来取消ForkJoinPool类中所有的任务
public class TaskManager {
	private List<ForkJoinTask<Integer>> tasks;
	public TaskManager(){
		tasks = new ArrayList<>();
	}
	
	public void addTask(ForkJoinTask<Integer> task){
		tasks.add(task);
	}
	
	public void cancelTasks(ForkJoinTask<Integer> cancelTask){
		for(ForkJoinTask<Integer> task:tasks){
			if(task!=cancelTask){
				//ForkJoinTask类提供的cancel()方法允许取消一个仍没有被执行的任务，如果任务已经开始执行，那么调用cancel()方法也无法取消
				task.cancel(true);
				((SearchNumberTask)task).writeCancelMessage();
			}
		}
	}
}
