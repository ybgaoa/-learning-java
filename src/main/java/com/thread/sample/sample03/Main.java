package com.thread.sample.sample03;

import java.util.Date;
//等待线程的终止
/**
 * 
在一些情况下，我们必须等待线程终止后，在执行其他任务，这时候我们使用Thread类的join()方法。

当一个线程对象的join()方法被调用时，调用它的线程将被挂起，直到这个线程对象完成它的任务。

java提供了另外两种形式的join()方法：参数单位毫秒和纳秒

join(long milliseconds)

join(long milliseconds,long nanos)
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		DataSourcesLoader ds = new DataSourcesLoader();
		Thread t1 = new Thread(ds,"DataSourcesLoader");
		NetworkConnectionsLoader ncl = new NetworkConnectionsLoader();
		Thread t2 = new Thread(ncl,"NetworkConnectionsLoader");
		
		t1.start();
		t2.start();
		
		try {
			//使用join()方法等待两个线程的终止。join()方法会抛出InterruptedExceptiony异常。我们必须捕获并处理这个异常
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main:configuration has been loaded:"+ new Date());
	}

}
