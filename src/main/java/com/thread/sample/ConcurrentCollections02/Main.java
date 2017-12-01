package com.thread.sample.ConcurrentCollections02;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
//使用阻塞式线程安全列表
/**
 * LinkedBlockingDeque类提供的常用方法：
1.takeFirst和takeLast()：分别返回列表中第一个和最后一个元素，返回的元素会从列表中移除。如果列表为空，调用方法的线程将被阻塞直到列表中有可用的元素出现。
2.getFirst()和getLast()：分别返回列表中第一个和最后一个元素，返回的元素不会从列表中移除。如果列表为空，则抛出NoSuchElementException异常。
3.peek()、peekFirst()和peekLast()：分别返回列表中第一个和最后一个元素，返回的元素不会从列表中移除。如果列表为空，返回null。
4.poll()、pollFirst()和pollLast()：分别返回列表中第一个和最后一个元素，返回的元素将会从列表中移除。如果列表为空，返回null。
5.add()、addFirst()和addLast()：分别将元素 添加到列表中第一位和最后一位。如果列表已经满了，这些方法将抛出ILLegalStateException异常。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(40);
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		
		for(int i=0;i<3;i++){
			System.out.println("===========");
			for(int j=0;j<5;j++){
				String request = list.take();//take()方法：返回队列中的第一个元素并将其移除。如果队列为空，线程阻塞直到队列中有可用的元素
				System.out.println("main:request:"+request+" at "+new Date()+":size:"+list.size());
			}
			TimeUnit.SECONDS.sleep(10);
			System.out.println("************");
		}
		System.out.println("main:end of the program");
	}

}
