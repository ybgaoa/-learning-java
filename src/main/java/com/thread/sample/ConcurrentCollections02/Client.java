package com.thread.sample.ConcurrentCollections02;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
//创建一个名为Client的类
public class Client implements Runnable {
	//声明一个私有的LinkedBlockingDeque类属性requestList
	private LinkedBlockingDeque<String> requestList;
	
	public Client(LinkedBlockingDeque<String> requestList){
		this.requestList = requestList;
	}
	//实现run()方法。使用requestList对象的put()方法，每两秒向列表requestList中插入5个字符串。重复3次
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			for(int j=0;j<5;j++){
				StringBuilder request = new StringBuilder();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					requestList.put(request.toString());//这个方法把参数对应的元素插入到队列中
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
