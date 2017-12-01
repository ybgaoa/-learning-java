package com.thread.sample.ConcurrentCollections05;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
//使用线程安全可遍历映射
/**
 * ConcurrentSkipListMap类
java api提供了一种用于并发应用程序中的有趣数据结构，即ConcurrentNavigableMap接口及其实现类。实现这个接口的类以如下两部分存放元素：
1.一个键值(Key)，它是元素的标识并且是唯一的。
2.元素其他部分数据。
每一个组成部分必须在不同的类中实现。
java api也提供了一个实现ConcurrentSkipListMap接口的类，ConcurrentSkipListMap接口实现了与ConcurrentNavigableMap接口有相同行为的一个非阻塞式列表。从内部实现机制来讲，它使用了一个Skip List来存放数据。Skip List是基于并发列表的数据结构，效率与二叉树相近。
当插入元素到映射中时，ConcurrentSkipListMap接口类使用键值来排序所有元素。除了提供返回一个具体元素的方法外，这个类也提供获取子映射的方法。

ConcurrentSkipListMap类提供的常用方法：
1.headMap(K toKey)：K是在ConcurrentSkipListMap对象的 泛型参数里用到的键。这个方法返回映射中所有键值小于参数值toKey的子映射。
2.tailMap(K fromKey)：K是在ConcurrentSkipListMap对象的 泛型参数里用到的键。这个方法返回映射中所有键值大于参数值fromKey的子映射。
3.putIfAbsent(K key,V value)：如果映射中不存在键key，那么就将key和value保存到映射中。
4.pollLastEntry()：返回并移除映射中的最后一个Map.Entry对象。
5.replace(K key,V value)：如果映射中已经存在键key，则用参数中的value替换现有的值。

 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		ConcurrentSkipListMap<String, Contact> map;
		map = new ConcurrentSkipListMap<>();
		Thread threads[] = new Thread[25];
		int counter = 0;
		for(char i='A';i<'Z';i++){
			Task task = new Task(map,String.valueOf(i));
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}
		
		for(int i=0;i<25;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:size of the map:"+map.size());
		Map.Entry<String, Contact> element;
		Contact contact;
		element = map.firstEntry();
		contact = element.getValue();
		System.out.println("main:first entry:"+contact.getName()+":"+contact.getPhone());
		
		element = map.lastEntry();
		contact = element.getValue();
		System.out.println("main:last entry:"+contact.getName()+":"+contact.getPhone());
		
		System.out.println("main:submap from A1996 to B1002:");
		//获取ConcurrentSkipListMap的对象队列中键名在“A1996”和“B1002”的部分队列，这个队列的对象为ConcurrentNavigableMap类
		ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
		do{
			element = submap.pollFirstEntry();
			if(element!=null){
				contact = element.getValue();
				System.out.println(contact.getName()+":"+contact.getPhone());
			}
		}while(element!=null);
		
	}

}
