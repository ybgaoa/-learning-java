package com.thread.sample.ConcurrentCollections07;
//创建一个名为Bank的类，这个类模拟从账户中取钱
public class Bank implements Runnable {
	private Account account;
	public Bank(Account account){
		this.account = account;
	}
	@Override
	public void run() {
		//实现从账户取钱
		for(int i=0;i<10;i++){
			account.subtractAmount(1000);
		}

	}

}
