package com.thread.sample.ConcurrentCollections05;
//����һ����ΪContact����
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
