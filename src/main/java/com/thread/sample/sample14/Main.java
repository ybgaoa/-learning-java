package com.thread.sample.sample14;

import java.util.concurrent.Phaser;
/**
 * 并发阶段任务的运行
 * 
 * Phaser类
java并发API还提供了一个更复杂、更强大的同步辅助类，即Phaser，它允许执行并发多阶段任务。当我们有并发任务并且需要分解成几步执行时，这种机制就非常适用。Phaser类机制是在每一步结束的位置对线程进行同步，当所有的线程都完成了这一步，才允许执行下一步。
常用方法：
arriveAndDeregister()方法：调用Phaser对象的arriveAndDeregister()方法来通知Phaser对象当前线程已经结束这个阶段，并且将不再参与接下来的阶段操作。相当于取消该线程的注册。
arriveAndAwaitAdvance()方法：调用Phaser对象的arriveAndAwaitAdvance()方法，来通知Phaser对象当前线程已经完成了当前阶段，需要被阻塞直到其他线程也都完成当前阶段。
isTerminated()方法：调用了phaser对象的isTerminated()方法，当phaser对象不存在参与同步的线程时，phaser是终止的，该方法将返回true。当取消所有线程的注册时，phaser对象就会变成终止状态。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		//指定参与阶段同步的线程是3个
		Phaser phaser = new Phaser(3);
		FileSearch system = new FileSearch("c:\\Windows","log",phaser);
		FileSearch apps = new FileSearch("c:\\Program Files","log",phaser);
		FileSearch documents = new FileSearch("c:\\Documents And Settings","log",phaser);
		
		Thread systemThread = new Thread(system,"system");
		systemThread.start();
		Thread appsThread = new Thread(apps,"apps");
		appsThread.start();
		Thread documentsThread = new Thread(documents,"documents");
		documentsThread.start();
		
		try {
			systemThread.join();
			appsThread.join();
			documentsThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//三个线程都完成后，调用了phaser对象的isTerminated()方法。
		//当phaser对象不存在参与同步的线程时，phaser是终止的，该方法将返回true。当取消所有线程的注册时，phaser对象就会变成终止状态。
		System.out.println("Terminated:"+phaser.isTerminated());
	}
}
