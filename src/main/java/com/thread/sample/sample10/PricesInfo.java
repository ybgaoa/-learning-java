package com.thread.sample.sample10;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//����һ���۸���Ϣ�࣬�����������Ʒ�ļ۸�
public class PricesInfo {
	private double price1;
	private double price2;
	//������д������
	private ReadWriteLock lock;
	
	public PricesInfo(){
		price1 = 1.0;
		price2 = 2.0;
		//��ʼ����д������
		lock = new ReentrantReadWriteLock();
	}
	
	public double getPrice1() {
		//ʹ�ö�������ȡ��������Եķ���
		lock.readLock().lock();
		double value = price1;
		//�ͷŶ���
		lock.readLock().unlock();
		return value;
	}

	public double getPrice2() {
		//ʹ�ö�������ȡ��������Եķ���
		lock.readLock().lock();
		double value = price2;
		//�ͷŶ���
		lock.readLock().unlock();
		return value;
	}
	public void setPrices(double price1,double price2){
		//ʹ��д������ȡ��������Եķ���
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		//�ͷ�д��
		lock.writeLock().unlock();
	}
}
