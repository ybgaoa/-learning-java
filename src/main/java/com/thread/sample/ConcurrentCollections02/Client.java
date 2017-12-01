package com.thread.sample.ConcurrentCollections02;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
	private LinkedBlockingDeque<String> requestList;
	public Client(LinkedBlockingDeque<String> requestList){
		this.requestList = requestList;
	}
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			for(int j=0;j<5;j++){
				StringBuilder request = new StringBuilder();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					requestList.put(request.toString());//��������Ѳ�����Ӧ��Ԫ�ز��뵽������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Client:"+request+" at "+new Date());
			}
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Client:end");
	}

}
