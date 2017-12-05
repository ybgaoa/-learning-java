package com.thread.sample.Customizing08;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//������MyLock����ʵ��Lock�ӿ�
public class MyLock implements Lock {
	//����һ����Ϊsync��˽��AbstractQueuedSynchronizer����
	private AbstractQueuedSynchronizer sync;
	//ʵ���๹����������ʼ������ֵ
	public MyLock(){
		sync = new MyAbstractQueuedSynchronizer();
	}
	//ʵ��lock()������Ȼ���ڷ����е���sync�����acquire()����
	@Override
	public void lock() {
		sync.acquire(1);
	}
	//ʵ��lockInterruptibly()��Ȼ���ڷ����е���sync�����acquireInterruptibly()����
	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}
	//ʵ��tryLock()��Ȼ���ڷ����е���sync�����tryAcquireNanos()����
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
	//ʵ��tryLock()��Ȼ���ڷ����е���sync�����tryAcquireNanos()����
	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, TimeUnit.NANOSECONDS.convert(time, unit));
	}
	//ʵ��unlock()��Ȼ���ڷ����е���sync�����release()����
	@Override
	public void unlock() {
		sync.release(1);

	}
	//ʵ��newCondition()������sync�����ڲ���ConditionObject��һ���¶���
	@Override
	public Condition newCondition() {
		return sync.new ConditionObject();
	}

}
