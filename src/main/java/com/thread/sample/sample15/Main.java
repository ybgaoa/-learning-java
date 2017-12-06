package com.thread.sample.sample15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
/**
 * 并发任务间的数据交换
 * 
 * Exchanger类
java并发API还提供了一个同步辅助类，它就是Exchanger，它允许在并发任务之间交换数据。
具体来说，Exchanger类允许在两个线程之间定义同步点。当两个线程都到达同步点时，它们交换数据结构，
因此第一个线程的数据结构进入到第二个线程中，同时第二个线程的数据结构进入到第一个线程中。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();
		
		Exchanger<List<String>> exchanger = new Exchanger<>();
		Producer producer = new Producer(buffer1,exchanger);
		Consumer consumer = new Consumer(buffer2,exchanger);
		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);
		threadProducer.start();
		threadConsumer.start();
	}
}
