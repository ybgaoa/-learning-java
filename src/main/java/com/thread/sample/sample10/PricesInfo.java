package com.thread.sample.sample10;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//创建一个价格信息类，并存放两个产品的价格
public class PricesInfo {
	private double price1;
	private double price2;
	//声明读写锁对象
	private ReadWriteLock lock;
	
	public PricesInfo(){
		price1 = 1.0;
		price2 = 2.0;
		//初始化读写锁对象
		lock = new ReentrantReadWriteLock();
	}
	
	public double getPrice1() {
		//使用读锁来获取对这个属性的访问
		lock.readLock().lock();
		double value = price1;
		//释放读锁
		lock.readLock().unlock();
		return value;
	}

	public double getPrice2() {
		//使用读锁来获取对这个属性的访问
		lock.readLock().lock();
		double value = price2;
		//释放读锁
		lock.readLock().unlock();
		return value;
	}
	public void setPrices(double price1,double price2){
		//使用写锁来获取对这个属性的访问
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		//释放写锁
		lock.writeLock().unlock();
	}
}
