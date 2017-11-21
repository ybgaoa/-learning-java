package com.thread.sample.sample02;

public class Main {

	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		task.interrupt();
	}

}
