package com.thread.sample.ConcurrentCollections01;

import java.util.concurrent.ConcurrentLinkedDeque;
//使用非阻塞式线程安全列表
/**
 * 并发集合
数据结构是编程中的基本元素，几乎每个程序都使用一种或多种数据结构来存储和管理数据。java api提供了包含接口、类和算法的java集合框架，它实现了可用在程序中的大量数据结构。
当需要在并发程序中使用数据集合时，必须要谨慎地选择相应的实现方式。大多数集合类不能直接用于并发应用，因为它们没有对本身数据的并发访问进行控制。
如果一些并发任务共享了一个不适用于并发任务的数据结构，将会遇到数据不一致的错误，并将影响程序的准确运行。这类数据结构的一个例子是ArrayList类。
java提供了一些可以用于并发程序中的数据集合，它们不会引起任何问题。一般来说，java提供了两类适用于并发应用的集合：
1.阻塞式集合(Blocking Collection)：这类集合包括添加和移除数据的方法。当集合已满或者为空时，被调用的添加或移除方法就不能立即被执行，那么调用这个方法的线程将被阻塞，一直到该方法可以被成功执行。
2.非阻塞式集合(Non-Blocking Collection)：这类集合也包括添加和移除数据的方法。如果方法不能立即被执行，则返回null或者抛出异常，但是调用这个方法的线程不会被阻塞。

并发应用中常用的java集合类：
1.非阻塞式列表对应的实现类：ConcurrentLinkedDeque类
2.阻塞式列表对应的实现类：LinkedBlockingDeque类
3.用于数据生成或消费的阻塞式列表对应的实现类：LinkedTransferQueue类
4.按优先级排序列表元素的阻塞式列表对应的实现类：PriorityBlockingQueue类
5.带有延迟列表元素的阻塞式列表对应的实现类：DelayQueue类
6.非阻塞式可遍历映射对应的实现类：ConcurrentSkipListMap类
7.随机数字对应的实现类：ThreadLocalRandom类
8.原子变量对应的实现类：AtomicLong和AtomicIntegerArray类

一、ConcurrentLinkedDeque类提供的常用方法：
1.getFirst()和getLast()：分别返回列表中的第一个和最后一个元素，返回的元素不会从列表中移除。如果列表为空，这两个方法抛出NoSuchElementExcpetion异常。
2.peek()、peekFirst()和peekLast()：分别返回列表中第一个和最后一个元素，返回的元素不会从列表中移除。如果列表为空，这些方法返回null。
3.remove(), removeFirst(), removeLast()：这些方法返回列表的第一个和最后一个元素。他们从列表中移除返回的元素。如果列表是空的,这些方法抛出一个 NoSuchElementException例外。
4.pollFirst()和pollLast()：pollFirst()方法返回和删除列表的第一个元素和pollLast()方法返回和删除最后一个元素的列表。如果列表为空,这些方法返回一个null值。
5.size()：该方法返回的值可能不是真实的,尤其当有线程在添数据或者移除数据时。这个方法需要遍历整个列表来计算元素数量，而遍历过的数据可能已经改变。仅当没有任何线程修改列表时，才能保证返回的结果是准确的。
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		//创建ConcurrentLinkedDeque对象
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		//创建线程数组
		Thread threads[] = new Thread[100];
		//创建AddTask对象以及其对应的运行线程，然后启动线程
		for(int i=0;i<threads.length;i++){
			AddTask task = new AddTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		System.out.println("main:"+threads.length+" AddTask threads have been launched");
		//使用join()方法等待线程完成
		for(int i=0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:size of the list:"+list.size());
		//创建PollTask对象以及其对应的运行线程，然后启动线程
		for(int i=0;i<threads.length;i++){
			PollTask task = new PollTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.println("main:"+threads.length+" polltask threads have been  launched");
		//使用join()方法等待线程完成
		for(int i=0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:size of the list:"+list.size());
	}
}
