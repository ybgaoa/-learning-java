package com.thread.sample.ConcurrentCollections06;
//生成并发随机数
/**
 * ThreadLocalRandom类
java api提供了一个特殊类用以在并发程序中生成伪随机数，即ThreadLocalRandom类。它是线程本地变量。每个生成随机数的线程都有一个不同的生成器，但是都在同一个类中被管理，对程序员来讲是透明的。
相比于使用共享的Random对象为所有线程生成随机数，这种机制具有更好的性能。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		Thread threads[] = new Thread[3];
		for(int i=0;i<3;i++){
			TaskLocalRandom task = new TaskLocalRandom();
			threads[i] = new Thread(task);
			threads[i].start();
		}

	}

}
