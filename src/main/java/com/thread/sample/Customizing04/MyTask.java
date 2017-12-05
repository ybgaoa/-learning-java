package com.thread.sample.Customizing04;

import java.util.concurrent.TimeUnit;

//创建MyTask类，并实现Runnable接口
public class MyTask implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
