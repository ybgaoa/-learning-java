package com.thread.sample.ConcurrentCollections07;
//����һ����ΪBank���࣬�����ģ����˻���ȡǮ
public class Bank implements Runnable {
	private Account account;
	public Bank(Account account){
		this.account = account;
	}
	@Override
	public void run() {
		//ʵ�ִ��˻�ȡǮ
		for(int i=0;i<10;i++){
			account.subtractAmount(1000);
		}

	}

}
