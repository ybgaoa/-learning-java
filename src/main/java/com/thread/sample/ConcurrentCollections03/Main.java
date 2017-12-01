package com.thread.sample.ConcurrentCollections03;

import java.util.concurrent.PriorityBlockingQueue;
//ʹ�ð����ȼ����������ʽ�̰߳�ȫ�б�
/**
 * PriorityBlockingQueue��
���ݽṹ�е�һ������������ʵ��һ�������б�java������PriorityBlockingQueue����������������
������ӽ�PriorityBlockingQueue��Ԫ�ر���ʵ��Comparable�ӿڡ�����ӿ��ṩ��compareTo()���������Ĵ��������һ��ͬ���͵Ķ��������������������͵Ķ������໥�Ƚϣ�����һ����ִ����������Ķ�����һ���ǲ�������Ķ�������������뷵��һ������ֵ�������ǰ����С�ڲ�������Ķ�����ô����һ��С��0��ֵ�������ǰ������ڲ�������Ķ�����ô����һ������0��ֵ���������������Ⱦ��Ƿ���0.
������Ԫ��ʱ��PriorityBlockingQueueʹ��compareTo()��������������Ԫ�ص�λ�á�Ԫ��Խ��Խ����
PriorityBlockingQueue����һ����Ҫ�������ǣ���������ʽ���ݽṹ�������ķ��������ò��Ҳ�������ִ��ʱ����������������߳̽�������ֱ������ִ�гɹ���

 * PriorityBlockingQueue���ṩ�ĳ��÷�����
1.clear()���Ƴ������е�����Ԫ��
2.take()�����ض����еĵ�һ��Ԫ�ز������Ƴ����������Ϊ�գ��߳�����ֱ���������п��õ�Ԫ�ء�
3.put(E e)��E��PriorityBlockingQueue�ķ��Ͳ�������ʾ������������͡���������Ѳ�����Ӧ��Ԫ�ز��뵽�����С�
4.peek()�����ض����еĵ�һ��Ԫ�أ����������Ƴ���
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue();
		Thread[] taskThreads = new Thread[5];
		for(int i=0;i<taskThreads.length;i++){
			Task task = new Task(i,queue);
			taskThreads[i] = new Thread(task); 
		}
		for(int i=0;i<taskThreads.length;i++){
			taskThreads[i].start();
		}
		
		for(int i=0;i<taskThreads.length;i++){
			try {
				taskThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:queue size:"+queue.size());
		for(int i=0;i<taskThreads.length*100;i++){
			Event event = queue.poll();//�÷������ض����еĵ�һ��Ԫ�ز������Ƴ�
			System.out.println("thread "+event.getThread()+" priority "+event.getPriorty());
		}
		System.out.println("main:Queue size:"+queue.size());
		System.out.println("main:end of the program");
	}

}
