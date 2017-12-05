package com.thread.sample.Customizing08;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//创建类MyAbstractQueuedSynchronizer，并继承AbstractQueuedSynchronizer类
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {
	//声明一个名为state的私有AtomicInteger属性
	private AtomicInteger state;
	//实现类的构造方法，并初始化属性
	public MyAbstractQueuedSynchronizer(){
		state = new AtomicInteger(0);
	}
	//实现tryAcquire()方法。它用来把state变量的值从0改为1。如果成功，返回true，否则返回false。
	@Override
	protected boolean tryAcquire(int arg) {
		return state.compareAndSet(0, 1);
	}
	//实现tryRelease()方法。它用来把state变量的值从1改为0。如果成功，返回true，否则返回false。
	@Override
	protected boolean tryRelease(int arg) {
		return state.compareAndSet(1, 0);
	}
	
}
