package com.thread.sample.sample13;

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
