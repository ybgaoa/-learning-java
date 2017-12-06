package com.thread.sample.forkjoin02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
//����DocumentTask�࣬���̳�RecursiveTask�ࡣ����ཫʵ��һ����������������Ҫ���ҵĴ������г��ֵĴ���
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
	//ʵ��compute()������
	@Override
	protected Integer compute() {
		int result = 0;
		//���end��start�Ĳ���С��10�������processLines������������������λ��֮��Ҫ���ҵĴʳ��ֵĴ���
		if(end-start<10){
			result = processLines(document,start,end,word);
		}else{
			//���򣬲����Щ�г�Ϊ�������󣬲����������µ�DocumentTask�����������������Ȼ�����invokeAll()�������̳߳���ִ������
			int mid = (start+end)/2;
			DocumentTask task1 = new DocumentTask(document,start,mid,word);
			DocumentTask task2 = new DocumentTask(document,mid,end,word);
			invokeAll(task1,task2);
			try {
				//����groupResults�����������񷵻ص�ֵ��ӡ���󣬷����������Ľ��
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
		//����invokeAll()����ִ���б������е�����
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
