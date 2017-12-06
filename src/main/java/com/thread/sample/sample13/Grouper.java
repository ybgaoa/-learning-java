package com.thread.sample.sample13;
//创建Grouper类，实现这个类来计算在矩阵中查找到的总次数。计算是基于Result对象的，后者存放了矩阵中每行查找到的次数
public class Grouper implements Runnable {
	private Results results;
	public Grouper(Results results){
		this.results = results;
	}
	@Override
	public void run() {
		int finalResult = 0;
		System.out.println("Grouper:processing results...");
		int data[] = results.getData();
		for(int number:data){
			finalResult += number;
		}
		System.out.println("Grouper:total result:"+finalResult);
	}

}
