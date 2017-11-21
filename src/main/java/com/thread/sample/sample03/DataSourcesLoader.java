package com.thread.sample.sample03;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable{

	@Override
	public void run() {
		System.out.println("begin data sources loading"+ new Date());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end data sources loading"+ new Date());
	}

}
