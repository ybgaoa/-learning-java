package com.thread.sample.forkjoin02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
//创建DocumentTask类，并继承RecursiveTask类。这个类将实现一个任务，用来计算所要查找的词在行中出现的次数
public class DocumentTask extends RecursiveTask<Integer> {
	private String document[][];
	private int start,end;
	private String word;
	
	public DocumentTask(String document[][],int start,int end,String word){
		this.document = document;
		this.start = start;
		this.end = end;
		this.word = word;
	}
	//实现compute()方法。
	@Override
	protected Integer compute() {
		int result = 0;
		//如果end和start的差异小于10，则调用processLines方法，来计算这两个位置之间要查找的词出现的次数
		if(end-start<10){
			result = processLines(document,start,end,word);
		}else{
			//否则，拆分这些行成为两个对象，并创建两个新的DocumentTask对象来处理这个对象，然后调用invokeAll()方法在线程池里执行它们
			int mid = (start+end)/2;
			DocumentTask task1 = new DocumentTask(document,start,mid,word);
			DocumentTask task2 = new DocumentTask(document,mid,end,word);
			invokeAll(task1,task2);
			try {
				//采用groupResults将这两个任务返回的值相加。最后，返回任务计算的结果
				result = groupResults(task1.get(),task2.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	private Integer processLines(String[][] document,int start,int end,String word){
		List<LineTask> tasks = new ArrayList<LineTask>();
		for(int i=start;i<end;i++){
			LineTask task = new LineTask(document[i],0,document[i].length,word);
			tasks.add(task);
		}
		//调用invokeAll()方法执行列表中所有的任务
		invokeAll(tasks);
		int result = 0;
		for(int i=0;i<tasks.size();i++){
			LineTask task = tasks.get(i);
			try {
				result = result+task.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return new Integer(result);
	}
	
	private Integer groupResults(Integer number1,Integer number2){
		Integer result;
		result = number1+number2;
		return result;
	}
}
