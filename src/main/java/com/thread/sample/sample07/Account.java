package com.thread.sample.sample07;
//创建Account账号类，它是银行账户的模型，只有一个双精度浮点型属性balance
public class Account {
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	private double balance;
	//实现addAmount()方法。它会将传入的数据加入到余额中，并且在同一时间只允许一个线程改变这个值，
	//所以我们使用synchronized关键字将这个地方标记成临界区
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
	//实现subtractAmount()方法。它会将传入的数据从余额中扣除，并且在同一时间只允许一个线程改变这个值，
	//所以我们使用synchronized关键字将这个地方标记成临界区
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
