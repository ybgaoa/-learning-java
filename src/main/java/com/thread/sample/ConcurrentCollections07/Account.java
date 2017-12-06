package com.thread.sample.ConcurrentCollections07;

import java.util.concurrent.atomic.AtomicLong;
//创建一个名为Account的类来模拟银行账户
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
	//账户存钱的动作
	public void addAmount(long amount){
		this.balance.getAndAdd(amount);
	}
	//账户取钱的动作
	public void subtractAmount(long amount){
		this.balance.getAndAdd(-amount);
	}
}
