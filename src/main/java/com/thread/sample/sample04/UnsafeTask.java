package com.thread.sample.sample04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	private Date startDate;
	@Override
	public void run() {
		startDate = new Date();
		System.out.println("starting thread:"+Thread.currentThread().getId()+":"+startDate);
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread finished:"+Thread.currentThread().getId()+":"+startDate);
	}

}
