package com.thread.sample.Customizing10;

import java.util.concurrent.atomic.AtomicInteger;
//����ParkingCounter�࣬���̳�AtomicInteger��
public class ParkingCounter extends AtomicInteger {
	//����һ����ΪmaxNumber���ԣ������洢ͣ�����п�ͣ���������������
	private int maxNumber;
	
	//ʵ�ֹ�����������ʼ������
	public ParkingCounter(int maxNumber){
		set(0);
		this.maxNumber = maxNumber;
	}
	//ʵ��carIn()�������������ֵС��ָ�������ֵ��������������ӳ�������������һ������ѭ����ʹ��get()�����ڲ���������ֵ��
	public boolean carIn(){
		for(;;){
			int value = get();
			if(value==maxNumber){
				System.out.println("parkingCounter:the parking lot is full");
				return false;
			}else{
				int newValue = value+1;
				boolean changed = compareAndSet(value, newValue);
				if(changed){
					System.out.println("parkingCounter:a car has entered");
					return true;
				}
			}
		}
	}
	//ʵ��carOut()����������������������㣬������������ٳ�������������һ������ѭ����ʹ��get()�����ڲ���������ֵ��
	public boolean carOut(){
		for(;;){
			int value = get();
			if(value==0){
				System.out.println("parkingCounter:the parking lot is empty");
				return false;
			}else{
				int newValue = value-1;
				boolean changed = compareAndSet(value, newValue);
				if(changed){
					System.out.println("parkingCounter:a car has gone out");
					return true;
				}
			}
		}
	}
}
