package com.thread.sample.Customizing04;

import java.util.Date;

//ʵ��ThreadFactory�ӿ����ɶ����߳�
//1.����MyThread�࣬���̳�Thread��
public class MyThread extends Thread {
	//2.��������˽��Date����
	private Date creationDate;
	private Date startDate;
	private Date finishDate;
	
	//3.ʵ�ֹ��췽��
	public MyThread(Runnable target,String name){
		super(target,name);
		setCreationDate();
	}
	
	//4.ʵ��һ������������creationDate���Ե�ֵ
	public void setCreationDate(){
		creationDate = new Date();
	}
	//5.ʵ��һ������������startDate���Ե�ֵ
	public void setStartDate(){
		startDate = new Date();
	}
	//6.ʵ��һ������������finishDate���Ե�ֵ
	public void setFinishDate(){
		finishDate = new Date();
	}
	//7.ʵ��run()�����������̵߳Ŀ�ʼʱ�䣬Ȼ����ø����run����������ִ�еĽ���ʱ�䡣
	@Override
	public void run() {
		setStartDate();
		super.run();
		setFinishDate();
	}
	//8.ʵ��һ��getExecutionTime()���������������߳̿�ʼ�ͽ�����ʱ��
	public long getExecutionTime(){
		return finishDate.getTime() - startDate.getTime();
	}
	//9.����toString()������
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(getName());
		buffer.append(":");
		buffer.append("creation date:");
		buffer.append(creationDate);
		buffer.append("running date:");
		buffer.append(getExecutionTime());
		buffer.append(" milliseconds");
		return buffer.toString();
	}
}
