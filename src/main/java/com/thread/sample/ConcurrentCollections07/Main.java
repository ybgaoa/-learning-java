package com.thread.sample.ConcurrentCollections07;
/**
 * AtomicLong类
原子变量(Atomic Variable)是从java5开始引入的，它提供了单个变量上的原子操作。在编译程序时，java代码中的每个变量、每个操作都将被转换成机器可以理解的指令。
例如，当给一个变量赋值时，在java代码中只使用一个指令，但是编译这个程序时，指令被转换成JVM语言中的不同指令。当多个线程共享同一个变量时，就会发生数据不一致的错误。
为了避免这类错误，java引入了原子变量。当一个线程在对原子变量操作时，如果其他线程也试图对同一原子变量执行操作，原子变量的实现类提供了一套机制来检查操作是否在一步内完成。一般来说，这个操作先获取变量值，然后在本地改变变量的值，然后试图用这个改变的值去替换之前的值。如果之前的值没有被其他线程改变，就可以执行这个替换操作。否则，方法将再次执行这个操作。这种操作称为CAS原子操作。
原子变量不使用锁或其他同步机制来保护对其值的并发访问。所有操作都是基于CAS原子操作的。它保证了多线程在同一时间操作一个原子变量而不会产生数据不一致的错误，并且它的性能优于使用同步机制保护的普通变量。
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		//初始化账户金额为1000
		Account account = new Account();
		account.setBalance(1000);
		//公司实现账户存钱
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		//银行实现账户取钱
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		//账户开始时候的金额
		System.out.println("Account:Initial Balance:"+account.getBalance());
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			//账户最终的金额
			System.out.println("Account:Final Balance:"+account.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
