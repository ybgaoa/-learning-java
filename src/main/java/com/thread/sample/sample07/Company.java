package com.thread.sample.sample07;
//实现公司模拟类Company。它使用addAmount()方法对账户的余额进行充值
public class Company implements Runnable {
	private Account account;
	public Company(Account account){
		this.account = account;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			account.addAmount(1000);
		}
	}

}
