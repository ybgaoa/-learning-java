package com.thread.sample.sample07;
//����Account�˺��࣬���������˻���ģ�ͣ�ֻ��һ��˫���ȸ���������balance
public class Account {
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	private double balance;
	//ʵ��addAmount()���������Ὣ��������ݼ��뵽����У�������ͬһʱ��ֻ����һ���̸߳ı����ֵ��
	//��������ʹ��synchronized�ؼ��ֽ�����ط���ǳ��ٽ���
	public synchronized void addAmount(double amount){
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}
	//ʵ��subtractAmount()���������Ὣ��������ݴ�����п۳���������ͬһʱ��ֻ����һ���̸߳ı����ֵ��
	//��������ʹ��synchronized�ؼ��ֽ�����ط���ǳ��ٽ���
	public synchronized void subtractAmount(double amount){
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}
}
