package com.thread.sample.sample07;
//ʵ��һ��ATMģ����Bank����ʹ��subtractAmount()�������˻������п۳���
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
