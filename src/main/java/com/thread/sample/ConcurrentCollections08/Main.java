package com.thread.sample.ConcurrentCollections08;

import java.util.concurrent.atomic.AtomicIntegerArray;
//使用原子数组
/**
 * AtomicIntegerArray类
当实现一个并发应用时，将不可避免地会有多线程共享一个或多个对象的现象，为了避免数据不一致错误，需要使用同步机制来保护对这些共享属性的访问。但是这些同步机制存在下列问题。
1.死锁：一个线程被阻塞，并且试图获得的锁正被其他线程使用，但其他线程永远不会释放这个锁。这种情况使得应用不会继续执行，并且永远不会结束。
2.即使只有一个线程访问共享对象，它仍然需要执行必须的代码来获取和释放锁。
针对这种情况，为了提供更优的性能，java于是引入了比较和交换操作。这个操作使用一下三步修改变量的值：
1.取得变量值，即变量的旧值。
2.在一个临时变量中修改变量值，即变量的新值。
3.如果上面获得的变量旧值与当前变量值相等，就用新值替换旧值。如果已有其他线程修改了这个变量的值，上面获得的变量的旧值就可能与当前变量值不同。
采用比较和交换机制不需要使用同步机制，不仅可以避免死锁并且性能更好。
java在原子变量中实现了这种机制。这些变量提供了实现比较和交换操作的compareAndSet()方法，其他方法也基于它展开。
java也引入了原子数组(Atomic Array)提供对integer或long数字数组的原子操作。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		final int THREADS = 100;
		AtomicIntegerArray vector = new AtomicIntegerArray(1000);
		Incrementer incrementer = new Incrementer(vector);
		Decrementer decrementer = new Decrementer(vector);
		Thread thread_incrementer[] = new Thread[THREADS];
		Thread thread_decrementer[] = new Thread[THREADS];
		
		for(int i=0;i<THREADS;i++){
			thread_incrementer[i] = new Thread(incrementer);
			thread_decrementer[i] = new Thread(decrementer);
			
			thread_incrementer[i].start();
			thread_decrementer[i].start();
		}
		
		for(int i=0;i<100;i++){
			try {
				thread_incrementer[i].join();
				thread_decrementer[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<vector.length();i++){
			if(vector.get(i)!=0){
				System.out.println("vector["+i+"]:"+vector.get(i));
			}
		}
		
		System.out.println("main:end of zhe example");
	}

}
