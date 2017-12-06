package com.thread.sample.sample01;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;
//�߳���Ϣ�Ļ�ȡ������
public class Main {

	public static void main(String[] args) {
		System.out.println("*************************");
		//����һ������Ϊ10���߳����飬�����洢�߳�
		Thread threads[] = new Thread[10];
		//����һ������Ϊ10��Thread.State���飬�����洢��10���߳�����ʱ��״̬
		Thread.State status[] = new Thread.State[10];
		for(int i=0;i<10;i++){
			threads[i] = new Thread(new Caluculator(i));
			//�����̵߳����ȼ�
			if((i%2)==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread"+i);
		}
		try {
			for(int i=0;i<10;i++){
				System.out.println("Main:Status of Thread "+i+":"+threads[i].getState());
				status[i] = threads[i].getState();
			}
			System.out.println("************start thread*************");
			for(int i=0;i<10;i++){
				threads[i].start();
			}
			boolean finish = false;
			while(!finish){
				for(int i=0;i<10;i++){
					if(threads[i].getState()!=status[i]){
						writeThreadInfo(threads[i],status[i]);
						status[i] = threads[i].getState();
					}
				}
			}
			finish = true;
			for(int i=0;i<10;i++){
				finish = finish && (threads[i].getState()==State.TERMINATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void writeThreadInfo(Thread thread,State state){
		System.out.println("");
		System.out.println("=================");
		System.out.println("id:"+thread.getId()+",name:"+thread.getName());
		System.out.println("priority:"+thread.getPriority());
		System.out.println("old state"+state);
		System.out.println("new state"+thread.getState());
	}
}