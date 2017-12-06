package com.thread.sample.sample07;
//实现一个ATM模拟类Bank。它使用subtractAmount()方法对账户余额进行扣除。
public class Bank implements Runnable {
	private Account account;
	
	public Bank(Account account){
		this.account = account;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			account.subtractAmount(1000);
		}
	}

}
