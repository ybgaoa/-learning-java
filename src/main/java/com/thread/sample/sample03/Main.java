package com.thread.sample.sample03;

import java.util.Date;
//�ȴ��̵߳���ֹ
/**
 * 
��һЩ����£����Ǳ���ȴ��߳���ֹ����ִ������������ʱ������ʹ��Thread���join()������

��һ���̶߳����join()����������ʱ�����������߳̽�������ֱ������̶߳��������������

java�ṩ������������ʽ��join()������������λ���������

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
			//ʹ��join()�����ȴ������̵߳���ֹ��join()�������׳�InterruptedExceptiony�쳣�����Ǳ��벶�񲢴�������쳣
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main:configuration has been loaded:"+ new Date());
	}

}
