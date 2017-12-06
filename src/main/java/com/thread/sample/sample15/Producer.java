package com.thread.sample.sample15;

import java.util.List;
import java.util.concurrent.Exchanger;
//实现生产者类
public class Producer implements Runnable{
	private List<String> buffer;
	//声明Exchanger<List<String>>型对象exchanger，用于同步生产者和消费者的交换对象
	private final Exchanger<List<String>> exchanger;
	
	public Producer(List<String> buffer,Exchanger<List<String>> exchanger){
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		int cycle = 1;
		for(int i=0;i<10;i++){
			System.out.println("Producer:cycle "+cycle);
			for(int j=0;j<10;j++){
				String message = "Event "+ ((i*10)+j);
				System.out.println("Producer:"+message);
				buffer.add(message);
			}
			try {
				//调用exchange()方法与消费者进行数据交换
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Producer:"+buffer.size());
			cycle++;
		}
		
	}

}
