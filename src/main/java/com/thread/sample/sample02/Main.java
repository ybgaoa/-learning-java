package com.thread.sample.sample02;
//�̵߳��ж�
public class Main {

	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�ж��߳�
		task.interrupt();
	}

}
