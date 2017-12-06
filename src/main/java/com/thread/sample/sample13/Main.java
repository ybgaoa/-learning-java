package com.thread.sample.sample13;

import java.util.concurrent.CyclicBarrier;
/**
 * 在集合点的同步
 * 
 * CyclicBarrier类
 * CyclicBarrier类有一个内部计数器，可以控制指定数目的几个线程必须都到达集合点。
 * 每一个线程到达集合点后就会调用await()方法通知CyclicBarrier对象，CyclicBarrier对象会让这个线程休眠直到其他所有的线程都到达集合点。
 * 当所有线程都到达集合点后，CyclicBarrier对象就唤醒所有在await()方法里等待的线程，同时，还可以以构造器传入的Runnable对象创建一个新的线程，以执行其他任务。
 * 
java并发API提供了CyclicBarrier类，它是一个同步辅助类。它允许两个或者多个线程在某个点上进行同步。
CyclicBarrier类使用了一个整型数进行初始化，这个数是需要在某个点上同步的线程数。当一个线程到达指定的点后，它将调用await()方法等待其他的线程。当线程调用await()方法后，CyclicBarrier类将阻塞这个线程并使之休眠直到所有其他线程到达。当最后一个线程调用CyclicBarrier类的await()方法时，CyclicBarrier对象将唤醒所有在等待的线程，然后这些线程将继续执行。
CyclicBarrier类提供了getNumberWaiting()方法和getparties()方法，前者将返回在await()上阻塞的线程的数目，后者返回被CyclicBarrier对象同步的任务数。
CyclicBarrier对象的重置，是通过CyclicBarrier类提供的reset()方法完成的。当重置发生后，在awai()方法中等待的线程将收到一个BrokenBarrierException异常。
CyclicBarrier类提供了isBroken()方法，如果处于损坏状态就行true，否则返回false.
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICHIPANIS = 5;
		final int LINES_PARTICIPANT = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS,NUMBERS,SEARCH);
		Results results = new Results(ROWS);
		Grouper grouper = new Grouper(results);
		//使用CyclicBarrier对象同步5个线程，执行Grouper查找任务处理结果，并且计算最终的结果
		CyclicBarrier barrier = new CyclicBarrier(PARTICHIPANIS,grouper);
		Searcher searchers[] = new Searcher[PARTICHIPANIS];
		for(int i=0;i<PARTICHIPANIS;i++){
			searchers[i] = new Searcher(i*LINES_PARTICIPANT,(i*LINES_PARTICIPANT)+LINES_PARTICIPANT,mock,results,5,barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		System.out.println("Main:the main thread has finished");
	}

}
