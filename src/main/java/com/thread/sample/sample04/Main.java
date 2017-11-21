package com.thread.sample.sample04;

import java.util.concurrent.TimeUnit;
/**
 * 线程局部变量的使用

ThreadLocal为每个使用该变量的线程分配一个独立的变量副本。所以每一个线程都可以独立地改变自己的副本，而不会影响其他线程所对应的副本。
1、ThreadLocal不是线程，是线程的一个变量，你可以先简单理解为线程类的属性变量。
2、ThreadLocal在类中通常定义为静态变量。
3、每个线程有自己的一个ThreadLocal，它是变量的一个“拷贝”，修改它不影响其他线程。
ThreadLocal适用于资源共享但不需要维护状态的情况，也就是一个线程对资源的修改，不影响另一个线程的运行；这种设计是‘空间换时间’，synchronized顺序执行是‘时间换取空间’。
四个核心方法说明如下：
T get()：返回此线程局部变量的当前线程副本中的值。
protected T initialValue()：返回此线程局部变量的当前线程的“初始值”。
void remove()：移除此线程局部变量当前线程的值。
void set(T value)：将此线程局部变量的当前线程副本中的值设置为指定值。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
//		System.out.println("java局部变量设置");
//		UnsafeTask ust = new UnsafeTask();
//		for(int i=0;i<10;i++){
//			Thread t = new Thread(ust);
//			t.start();
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.out.println("java线程局部变量设置");
		SafeTask st = new SafeTask();
		for(int i=0;i<10;i++){
			Thread t = new Thread(st);
			t.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
