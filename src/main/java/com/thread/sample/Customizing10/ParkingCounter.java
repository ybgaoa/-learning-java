package com.thread.sample.Customizing10;

import java.util.concurrent.atomic.AtomicInteger;
//创建ParkingCounter类，并继承AtomicInteger类
public class ParkingCounter extends AtomicInteger {
	//声明一个名为maxNumber属性，用来存储停车场中可停放汽车的最大数量
	private int maxNumber;
	
	//实现构造器，并初始化属性
	public ParkingCounter(int maxNumber){
		set(0);
		this.maxNumber = maxNumber;
	}
	//实现carIn()方法。如果它的值小于指定的最大值，这个方法就增加车的数量。构建一个无线循环并使用get()方法内部计数器的值。
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
	//实现carOut()方法。如果车的数量大于零，这个方法将减少车的数量。构建一个无线循环并使用get()方法内部计数器的值。
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
