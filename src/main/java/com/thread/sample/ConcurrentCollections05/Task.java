package com.thread.sample.ConcurrentCollections05;

import java.util.concurrent.ConcurrentSkipListMap;
//创建一个名为Task的类
public class Task implements Runnable {
	//声明一个私有的ConcurrentSkipListMap类型的map
	private ConcurrentSkipListMap<String,Contact> map;
	private String id;
	
	public Task(ConcurrentSkipListMap<String,Contact> map,String id){
		this.map = map;
		this.id = id;
	}
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			Contact contact = new Contact(id,String.valueOf(i+1000));
			map.put(id+contact.getPhone(), contact);
		}
	}
}
