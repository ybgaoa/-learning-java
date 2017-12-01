package com.thread.sample.ConcurrentCollections02;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
//ʹ������ʽ�̰߳�ȫ�б�
/**
 * LinkedBlockingDeque���ṩ�ĳ��÷�����
1.takeFirst��takeLast()���ֱ𷵻��б��е�һ�������һ��Ԫ�أ����ص�Ԫ�ػ���б����Ƴ�������б�Ϊ�գ����÷������߳̽�������ֱ���б����п��õ�Ԫ�س��֡�
2.getFirst()��getLast()���ֱ𷵻��б��е�һ�������һ��Ԫ�أ����ص�Ԫ�ز�����б����Ƴ�������б�Ϊ�գ����׳�NoSuchElementException�쳣��
3.peek()��peekFirst()��peekLast()���ֱ𷵻��б��е�һ�������һ��Ԫ�أ����ص�Ԫ�ز�����б����Ƴ�������б�Ϊ�գ�����null��
4.poll()��pollFirst()��pollLast()���ֱ𷵻��б��е�һ�������һ��Ԫ�أ����ص�Ԫ�ؽ�����б����Ƴ�������б�Ϊ�գ�����null��
5.add()��addFirst()��addLast()���ֱ�Ԫ�� ��ӵ��б��е�һλ�����һλ������б��Ѿ����ˣ���Щ�������׳�ILLegalStateException�쳣��
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(40);
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		
		for(int i=0;i<3;i++){
			System.out.println("===========");
			for(int j=0;j<5;j++){
				String request = list.take();//take()���������ض����еĵ�һ��Ԫ�ز������Ƴ����������Ϊ�գ��߳�����ֱ���������п��õ�Ԫ��
				System.out.println("main:request:"+request+" at "+new Date()+":size:"+list.size());
			}
			TimeUnit.SECONDS.sleep(10);
			System.out.println("************");
		}
		System.out.println("main:end of the program");
	}

}
