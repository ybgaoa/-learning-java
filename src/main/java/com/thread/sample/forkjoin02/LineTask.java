package com.thread.sample.forkjoin02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
//����LineTask�࣬���̳���RecursiveTask�ࡣ�����ʵ����һ����������������Ҫ���ҵĴ���һ���г��ֵĴ���
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
	//ʵ��compute()������
	@Override
	protected Integer compute() {
		Integer result = null;
		//���end��start�Ĳ���С��100�������count����������start��end�������������е�Ƭ���в��Ҵ�
		if(end-start<100){
			result = count(line,start,end,word);
		}else{
			//���򣬲����Щ�г�Ϊ�������󣬲����������µ�LineTask�����������������Ȼ�����invokeAll()�������̳߳���ִ������
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
