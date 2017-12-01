package com.thread.sample.ConcurrentCollections03;

import java.util.concurrent.PriorityBlockingQueue;
//使用按优先级排序的阻塞式线程安全列表
/**
 * PriorityBlockingQueue类
数据结构中的一个经典需求是实现一个有序列表。java引用了PriorityBlockingQueue类来满足这类需求。
所有添加进PriorityBlockingQueue的元素必须实现Comparable接口。这个接口提供了compareTo()方法，它的传入参数是一个同类型的对象。这样就有了两个类型的对象并且相互比较：其中一个是执行这个方法的对象，另一个是参数传入的对象。这个方法必须返回一个数字值，如果当前对象小于参数传入的对象，那么返回一个小于0的值；如果当前对象大于参数传入的对象，那么返回一个大于0的值；如果两个对象相等就是返回0.
当插入元素时，PriorityBlockingQueue使用compareTo()方法来决定插入元素的位置。元素越大越靠后。
PriorityBlockingQueue的另一个重要的特性是：它是阻塞式数据结构。当它的方法被调用并且不能立即执行时，调用这个方法的线程将被阻塞直到方法执行成功。

 * PriorityBlockingQueue类提供的常用方法：
1.clear()：移除队列中的所有元素
2.take()：返回队列中的第一个元素并将其移除。如果队列为空，线程阻塞直到队列中有可用的元素。
3.put(E e)：E是PriorityBlockingQueue的泛型参数，表示传入参数的类型。这个方法把参数对应的元素插入到队列中。
4.peek()：返回队列中的第一个元素，但不将其移除。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue();
		Thread[] taskThreads = new Thread[5];
		for(int i=0;i<taskThreads.length;i++){
			Task task = new Task(i,queue);
			taskThreads[i] = new Thread(task); 
		}
		for(int i=0;i<taskThreads.length;i++){
			taskThreads[i].start();
		}
		
		for(int i=0;i<taskThreads.length;i++){
			try {
				taskThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:queue size:"+queue.size());
		for(int i=0;i<taskThreads.length*100;i++){
			Event event = queue.poll();//该方法返回队列中的第一个元素并将其移除
			System.out.println("thread "+event.getThread()+" priority "+event.getPriorty());
		}
		System.out.println("main:Queue size:"+queue.size());
		System.out.println("main:end of the program");
	}

}
