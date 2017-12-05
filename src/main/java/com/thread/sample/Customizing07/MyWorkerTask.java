package com.thread.sample.Customizing07;

import java.util.Date;
import java.util.concurrent.ForkJoinTask;
//����������Fork/Join����е�����
//1.����MyWorkerTask�࣬�̳�ForkJoinTask��
public abstract class MyWorkerTask extends ForkJoinTask<Void> {
	private String name;
	//2.ʵ�ֹ��췽��
	public MyWorkerTask(String name){
		this.name = name;
	}
	//3.ʵ��getRawResult()����������һ��ForkJoinTask��ĳ��󷽷�����MyWorkerTask���񲻷����κν��ʱ������������뷵��nullֵ��
	@Override
	public Void getRawResult() {
		return null;
	}
	//4.ʵ��setRawResult()����������ForkJoinTask�����һ�����󷽷������ڵ�MyWorkerTask���񲻷����κν��ʱ�����÷�����Ϊ�ա�
	@Override
	protected void setRawResult(Void value) {		
	}
	//5.ʵ��exec()����������������������������������ִ��ʱ�䲢���������̨��
	@Override
	protected boolean exec() {
		Date startDate = new Date();
		compute();
		Date finishDate = new Date();
		long diff = finishDate.getTime() - startDate.getTime();
		System.out.println("MyWorkerTask:"+name+":"+diff+"milliseconds to complete");
		return true;
	}
	
	public String getName(){
		return name;
	}
	
	protected abstract void compute();

}
