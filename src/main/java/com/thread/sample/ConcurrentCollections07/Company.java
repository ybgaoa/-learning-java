package com.thread.sample.ConcurrentCollections07;

public class Company implements Runnable {
	private Account account;
	public Company(Account account){
		this.account = account;
	}
	@Override
	public void run() {
		//ʵ�����˻��д�Ǯ
		for(int i=0;i<10;i++){
			account.addAmount(1000);
		}
	}
}
