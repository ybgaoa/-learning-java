package com.thread.sample.sample07;
/**
 * 同步方法
即有synchronized关键字修饰的方法。
由于java的每个对象都有一个内置锁，当用此关键字修饰方法时，内置锁会保护整个方法。在调用该方法前，需要获得内置锁，否则就处于阻塞状态。
代码如：
public synchronized void save(){}
对于实例的同步方法，使用this即当前实例对象。
对于静态的同步方法，使用当前类的字节码对象。
注： synchronized关键字也可以修饰静态方法，此时如果调用该静态方法，将会锁住整个类。

 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		System.out.println("Account:initial Balance:"+account.getBalance());
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			System.out.println("Account:Final Balance:"+account.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
