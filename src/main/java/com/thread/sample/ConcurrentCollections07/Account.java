package com.thread.sample.ConcurrentCollections07;

import java.util.concurrent.atomic.AtomicLong;
//����һ����ΪAccount������ģ�������˻�
public class Account {
	private AtomicLong balance;
	public Account(){
		balance = new AtomicLong();
	}
	
	public long getBalance(){
		return balance.get();
	}
	
	public void setBalance(long balance){
		this.balance.set(balance);
	}
	//�˻���Ǯ�Ķ���
	public void addAmount(long amount){
		this.balance.getAndAdd(amount);
	}
	//�˻�ȡǮ�Ķ���
	public void subtractAmount(long amount){
		this.balance.getAndAdd(-amount);
	}
}
