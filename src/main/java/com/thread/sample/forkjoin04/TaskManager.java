package com.thread.sample.forkjoin04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
//����һ������ΪTaskManager���࣬�����������ȡ��ForkJoinPool�������е�����
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
				//ForkJoinTask���ṩ��cancel()��������ȡ��һ����û�б�ִ�е�������������Ѿ���ʼִ�У���ô����cancel()����Ҳ�޷�ȡ��
				task.cancel(true);
				((SearchNumberTask)task).writeCancelMessage();
			}
		}
	}
}
