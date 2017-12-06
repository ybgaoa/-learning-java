package com.thread.sample.sample15;

import java.util.List;
import java.util.concurrent.Exchanger;
//创建消费者类
public class Consumer implements Runnable {
	private List<String> buffer;
	//声明Exchanger<List<String>>型对象exchanger，用于同步生产者和消费者的交换对象
	private final Exchanger<List<String>> exchanger;
	
	public Consumer(List<String> buffer,Exchanger<List<String>> exchanger){
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		int cycle = 1;
		for(int i=0;i<10;i++){
			System.out.println("Consumer:cycle "+ cycle);
			try {
				//调用exchange()方法与消费者进行数据交换
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//将生产者放入消费者buffer列表中的10个字符串打印到控制台，并且从buffer列表中删除，保持为一个空的列表
			System.out.println("Consumer:"+buffer.size());
			for(int j=0;j<10;j++){
				String message = buffer.get(0);
				System.out.println("Consumer:"+message);
				buffer.remove(0);
			}
			cycle++;
		}
	}

}
