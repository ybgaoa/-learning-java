package com.thread.sample.Customizing02;

import java.util.concurrent.TimeUnit;

//ʵ�ֻ������ȼ���Executor��
//1.����MyPriorityTask�࣬��ʵ��Runnable��Comparable�ӿ� 
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
	//2.�������� priority
	private int priority;
	//3.�������� name
	private String name;
	
	//4.ʵ�ֹ�����������ʼ������
	public MyPriorityTask(String name,int priority){
		this.name = name;
		this.priority = priority;
	}
	//5.ʵ��һ�������������ȼ����Ե�ֵ
	public int getPriority(){
		return priority;
	}
	//6.ʵ����Comparable�ӿ�������compareTo()������������һ��MyPriorityTask������Ϊ������Ȼ��Ƚϵ�ǰ�Ͳ�����������ȼ�ֵ��
	//�ø����ȼ����������ڵ����ȼ�������ִ�С�
	@Override
	public int compareTo(MyPriorityTask o) {
		if(this.getPriority()<o.getPriority()){
			return 1;
		}
		if(this.getPriority()>o.getPriority()){
			return -1;
		}
		return 0;
	}
	//7.ʵ��run()������ʹ��ǰ�߳�����2��
	@Override
	public void run() {
		System.out.println("myPriorityTask:"+name+":priority:"+priority);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
