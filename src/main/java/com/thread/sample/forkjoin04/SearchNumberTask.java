package com.thread.sample.forkjoin04;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
//ʵ��һ����ΪSearchNumberTask���࣬���̳�RecursiveTask�ࡣ����ཫѰ������������Ԫ�ؿ��е�һ������
public class SearchNumberTask extends RecursiveTask<Integer> {
	private int numbers[];
	private int start,end;
	private int number;
	private TaskManager manager;
	private final static int NOT_FOUND=-1;
	
	public SearchNumberTask(int numbers[],int start,int end,int number,TaskManager manager){
		this.numbers = numbers;
		this.start = start;
		this.end = end;
		this.number = number;
		this.manager = manager;
	}
	//ʵ��compute()����
	@Override
	protected Integer compute() {
		System.out.println("task:"+start+":"+end);
		int ret;
		//���start��end����ֵ�Ĳ������10������launchTasks()���������������Ϊ����������
		if(end-start>10){
			ret = launchTasks();
		}else{
			//����Ѱ����������е����֣�����lookForNumber()���������������
			ret = lookForNumber();
		}
		return ret;
	}
	private int lookForNumber(){
		for(int i=start;i<end;i++){
			if(numbers[i]==number){
				System.out.println("task:end "+ number+" found in position:"+i);
				manager.cancelTasks(this);
				return i;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return NOT_FOUND;
	}
	private int launchTasks(){
		int mid = (start+end)/2;
		SearchNumberTask task1 = new SearchNumberTask(numbers,start,mid,number,manager);
		SearchNumberTask task2 = new SearchNumberTask(numbers,mid,end,number,manager);
		manager.addTask(task1);
		manager.addTask(task2);
		//����fork()�첽ִ���߳�
		task1.fork();
		task1.fork();
		int returnValue;
		
		returnValue = task1.join();
		if(returnValue!=-1){
			return returnValue;
		}
		returnValue = task2.join();
		return returnValue;
	}
	
	public void writeCancelMessage(){
		System.out.println("task:cancelled task from "+start+" to "+end);
	}
}
