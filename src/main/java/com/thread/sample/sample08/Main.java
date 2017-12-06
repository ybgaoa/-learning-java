package com.thread.sample.sample08;
/**
 * 使用非依赖属性实现同步
 * 
 * 同步代码块
即有synchronized关键字修饰的语句块。
被该关键字修饰的语句块会自动被加上内置锁，从而实现同步
代码如：
synchronized(object){}
Java中任意的对象都可以作为一个监听器(monitor)，监听器可以被上锁和解锁，在线程同步中称为同步锁，且同步锁在同一时间只能被一个线程所持有。上面的obj对象就是一个同步锁，分析一下上面代码的执行过程：
1).一个线程执行到synchronized代码块，首先检查obj，如果obj为空，抛出NullPointerExpression异常；
2).如果obj不为空，线程尝试给监听器上锁，如果监听器已经被锁，则线程不能获取到锁，线程就被阻塞；
3).如果监听器没被锁，则线程将监听器上锁，并且持有该锁，然后执行代码块；
4).代码块正常执行结束或者非正常结束，监听器都将自动解锁；

线程同步锁对多个线程必须是互斥的，即多个线程需要使用同一个同步锁。代码中obj对象被多个线程共享，能够实现同步。
注：同步是一种高开销的操作，因此应该尽量减少同步的内容。
通常没有必要同步整个方法，使用synchronized代码块同步关键代码即可。 

两者的区别主要体现在同步锁上面。对于实例的同步方法，因为只能使用this来作为同步锁，如果一个类中需要使用到多个锁，为了避免锁的冲突，必然需要使用不同的对象，这时候同步方法不能满足需求，只能使用同步代码块(同步代码块可以传入任意对象)；或者多个类中需要使用到同一个锁，这时候多个类的实例this显然是不同的，也只能使用同步代码块，传入同一个对象。
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1,"ticketOffice1");
		
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2,"ticketOffice2");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Room 1 Vacancies:"+cinema.getVacanciesCinema1());
		System.out.println("Room 2 Vacancies:"+cinema.getVacanciesCinema2());
	}

}
