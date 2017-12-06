package com.thread.sample.forkjoin02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
//创建LineTask类，并继承了RecursiveTask类。这个类实现了一个任务，用来计算所要查找的词在一行中出现的次数
public class LineTask extends RecursiveTask<Integer>{
	private String line[];
	private int start,end;
	private String word;
	
	public LineTask(String line[],int start,int end,String word){
		this.line = line;
		this.start = start;
		this.end = end;
		this.word = word;
	}
	//实现compute()方法。
	@Override
	protected Integer compute() {
		Integer result = null;
		//如果end和start的差异小于100，则调用count方法，在由start和end属性所决定的行的片段中查找词
		if(end-start<100){
			result = count(line,start,end,word);
		}else{
			//否则，拆分这些行成为两个对象，并创建两个新的LineTask对象来处理这个对象，然后调用invokeAll()方法在线程池里执行它们
			int mid = (start+end)/2;
			LineTask task1 = new LineTask(line,start,mid,word);
			LineTask task2 = new LineTask(line,mid,end,word);
			invokeAll(task1,task2);
			try {
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
	
	private Integer count(String[] line,int start,int end,String word){
		int counter = 0;
		for(int i=start;i<end;i++){
			if(line[i].equals(word)){
				counter++;
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counter;
	}
	
	private Integer groupResults(Integer number1,Integer number2){
		Integer result;
		result = number1+number2;
		return result;
	}
	
}
