package com.thread.sample.sample15;

import java.util.List;
import java.util.concurrent.Exchanger;
//������������
public class Consumer implements Runnable {
	private List<String> buffer;
	//����Exchanger<List<String>>�Ͷ���exchanger������ͬ�������ߺ������ߵĽ�������
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
				//����exchange()�����������߽������ݽ���
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�������߷���������buffer�б��е�10���ַ�����ӡ������̨�����Ҵ�buffer�б���ɾ��������Ϊһ���յ��б�
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
