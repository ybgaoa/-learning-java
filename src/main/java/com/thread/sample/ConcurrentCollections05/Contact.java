package com.thread.sample.ConcurrentCollections05;
//创建一个名为Contact的类
public class Contact {
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	private String name;
	private String phone;
	public Contact(String name,String phone){
		this.name = name;
		this.phone = phone;
	}
	
}
