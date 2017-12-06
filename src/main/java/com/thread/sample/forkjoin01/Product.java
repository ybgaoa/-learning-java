package com.thread.sample.forkjoin01;
//创建一个名为Product的类，用来存储产品的名称和价格
public class Product {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String name;
	private double price;
}
