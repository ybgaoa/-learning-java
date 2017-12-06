package com.thread.sample.sample18;
//创建一个结果类，用来存储并发任务产生的结果
public class Result {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	private String name;
	private int value;
	
}
