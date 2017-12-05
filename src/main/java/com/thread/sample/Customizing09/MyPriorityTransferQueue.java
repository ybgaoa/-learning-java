package com.thread.sample.Customizing09;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
//����MyPriorityTransferQueue�࣬���̳�PriorityBlockingQueue�࣬ʵ��TransferQueue�ӿ�
public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> implements TransferQueue<E> {
	//����һ����Ϊcounter��˽��AtomicInteger���ԣ������洢�ȴ�����Ԫ�ص�����������
	private AtomicInteger counter;
	//����һ����Ϊtransfered��˽��LinkedBlockingQueue����
	private LinkedBlockingQueue<E> transfered;
	//����һ����Ϊlock��˽��ReentrantLock����
	private ReentrantLock lock;
	
	public MyPriorityTransferQueue(){
		counter = new AtomicInteger(0);
		transfered = new LinkedBlockingQueue<E>();
		lock = new ReentrantLock();
	}
	//ʵ��tryTransfer()�����������������������Ԫ�ط��͵�һ�����ڵȴ��������ߡ����û�еȴ��������ߣ��÷�������false��
	@Override
	public boolean tryTransfer(E e) {
		lock.lock();
		boolean value;
		if(counter.get()==0){
			value = false;
		}else{
			put(e);
			value = true;
		}
		lock.unlock();
		return value;
	}
	//ʵ��transfer()�����������������������Ԫ�ط��͵�һ�����ڵȴ��������ߡ�
	//���û�еȴ��е������ߣ��÷�����Ԫ�ش洢��transfered���У����ȴ�������ͼ���Ԫ�صĵ�һ�������ߡ�����֮ǰ���߳̽���������
	@Override
	public void transfer(E e) throws InterruptedException {
		lock.lock();
		if(counter.get()!=0){
			put(e);
			lock.unlock();
		}else{
			transfered.add(e);
			lock.unlock();
			synchronized (e) {
				e.wait();
			}
		}
		
	}
	//ʵ��tryTransfer()������������������������һ���������Ա�ʾ���������ѵ�Ԫ�أ��ڶ���������ʾ���û����������ȴ�һ�������ߵ�ʱ�䣬������������ʾ�ȴ�ʱ��ĵ�λ��
	//������������ڵȴ���������������Ԫ�ء����򣬽�����ָ����ʱ��ת��Ϊ���벢ʹ��wait()�������߳����ߡ���������ȡԪ��ʱ������߳�����wait()���������ߣ���ʹ��notify()����ȥ��������
	@Override
	public boolean tryTransfer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		lock.lock();
		if(counter.get()!=0){
			put(e);
			lock.unlock();
			return true;
		}else{
			transfered.add(e);
			long newTimeOut = TimeUnit.MILLISECONDS.convert(timeout, unit);
			lock.unlock();
			e.wait(newTimeOut);
			lock.lock();
			if(transfered.contains(e)){
				transfered.remove(e);
				lock.unlock();
				return false;
			}else{
				lock.unlock();
				return true;
			}
		}
	}
	//ʵ��hasWaitingConsumer()������ʹ��counter���Ե�ֵ������÷����ķ���ֵ�����counter����0������true�����򷵻�false��
	@Override
	public boolean hasWaitingConsumer() {
		return (counter.get()!=0);
	}
	//ʵ��getWaitingConsumerCount()����������counter����ֵ��
	@Override
	public int getWaitingConsumerCount() {
		return counter.get();
	}
	//ʵ��getWaitingConsumerCount()�������÷�������׼������Ԫ�ص������ߵ��á�
	@Override
	public E take() throws InterruptedException {
		//���֮ǰ�������
		lock.lock();
		//�������ڵȴ��������ߵ�����
		counter.incrementAndGet();
		//�����transfered������û��Ԫ�أ����ͷ���������ʹ��take()�����Ӷ�����ȡ��һ��Ԫ�ز��ٴλ�ȡ����
		//���������û��Ԫ�أ��÷��������߳�����ֱ����Ԫ�ؿɱ����ѡ�
		E value = transfered.poll();
		if(value==null){
			lock.unlock();
			value =super.take();
			lock.lock();
		}else{//���򣬴�transfered������ȡ��valueԪ�أ������ѿ����ڵȴ�Ԫ�ر����ѵ��̡߳�
			synchronized (value) {
				value.notify();
			}
		}
		//�������ڵȴ��������ߵ��������ͷ���
		counter.decrementAndGet();
		lock.unlock();
		return value;
	}
}
