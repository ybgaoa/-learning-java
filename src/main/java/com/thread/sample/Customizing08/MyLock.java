package com.thread.sample.Customizing08;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//创建类MyLock，并实现Lock接口
public class MyLock implements Lock {
	//声明一个名为sync的私有AbstractQueuedSynchronizer属性
	private AbstractQueuedSynchronizer sync;
	//实现类构造器，并初始化属性值
	public MyLock(){
		sync = new MyAbstractQueuedSynchronizer();
	}
	//实现lock()方法。然后在方法中调用sync对象的acquire()方法
	@Override
	public void lock() {
		sync.acquire(1);
	}
	//实现lockInterruptibly()。然后在方法中调用sync对象的acquireInterruptibly()方法
	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}
	//实现tryLock()。然后在方法中调用sync对象的tryAcquireNanos()方法
	@Override
	public boolean tryLock() {
		try {
			return sync.tryAcquireNanos(1, 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//实现tryLock()。然后在方法中调用sync对象的tryAcquireNanos()方法
	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, TimeUnit.NANOSECONDS.convert(time, unit));
	}
	//实现unlock()。然后在方法中调用sync对象的release()方法
	@Override
	public void unlock() {
		sync.release(1);

	}
	//实现newCondition()。创建sync对象内部类ConditionObject的一个新对象
	@Override
	public Condition newCondition() {
		return sync.new ConditionObject();
	}

}
