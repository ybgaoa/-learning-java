package com.thread.sample.Customizing05;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	@Override
	public void run() {
		System.out.println("task:begin");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task:end");
	}

}
