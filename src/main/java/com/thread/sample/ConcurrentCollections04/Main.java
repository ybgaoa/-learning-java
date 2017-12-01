package com.thread.sample.ConcurrentCollections04;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
//使用带有延迟元素的线程安全列表
/**
 * DelayQueue类
java api提供了一种用于并发应用的有趣的数据结构，即DelayQueue类。这个类可以存放带有激活日期的元素。当调用方法从队列中返回或提取元素时，未来的元素日期将被忽略。这些元素对于这些方法是不可见的。
为了具有条用行为，存放到DelayQueue类中的元素必须继承Delayed接口。delayed接口使对象成为延迟对象，它使存放在DelayQueue类中的对象具有了激活日期，即到激活日期的时间。该接口强制执行下列两个方法：
1.compareTo(Delayed o)：Delayed接口继承了Comparable接口，因此有了这个方法。如果当前对象的延迟值小于参数对象的值，将返回一个小于0的值；如果当前对象的延迟值大于参数对象的值，将返回一个大于0的值；如果两者的延迟值相等则返回0.
2.getDelay(TimeUnit unit)：这个方法返回到激活日期的剩余时间，单位由单位参数指定。

DelayQueue类提供的常用方法：
1.clear()：移除队列中的所有元素。
2.offer(E e)：E是DelayQueue的泛型参数，表示传入参数的类型。这个方法把参数对应的元素插入到队列中。
3.peek()：返回队列中的第一个元素，但不将其移除。
4.take()：返回队列中的第一个元素，并将其移除。如果队列为空，线程将被阻塞直到队列中有可用的元素。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Event> queue = new DelayQueue<>();
		Thread threads[] = new Thread[5];
		for(int i=0;i<threads.length;i++){
			Task task = new Task(i+1,queue);
			threads[i] = new Thread(task);
		}
		for(int i=0;i<threads.length;i++){
			threads[i].start();
		}
		
		for(int i=0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		do{
			int counter = 0;
			Event event;
			do{
				event = queue.poll();
				if(event!=null) counter++;
			}while(event!=null);
			System.out.println("at "+new Date()+" you have read "+counter+" events");
			TimeUnit.MILLISECONDS.sleep(500);
		}while(queue.size()>0);
	}

}
