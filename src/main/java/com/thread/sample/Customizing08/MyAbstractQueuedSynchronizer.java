package com.thread.sample.Customizing08;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//������MyAbstractQueuedSynchronizer�����̳�AbstractQueuedSynchronizer��
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {
	//����һ����Ϊstate��˽��AtomicInteger����
	private AtomicInteger state;
	//ʵ����Ĺ��췽��������ʼ������
	public MyAbstractQueuedSynchronizer(){
		state = new AtomicInteger(0);
	}
	//ʵ��tryAcquire()��������������state������ֵ��0��Ϊ1������ɹ�������true�����򷵻�false��
	@Override
	protected boolean tryAcquire(int arg) {
		return state.compareAndSet(0, 1);
	}
	//ʵ��tryRelease()��������������state������ֵ��1��Ϊ0������ɹ�������true�����򷵻�false��
	@Override
	protected boolean tryRelease(int arg) {
		return state.compareAndSet(1, 0);
	}
	
}
