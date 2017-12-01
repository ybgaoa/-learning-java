package com.thread.sample.ConcurrentCollections04;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
//ʹ�ô����ӳ�Ԫ�ص��̰߳�ȫ�б�
/**
 * DelayQueue��
java api�ṩ��һ�����ڲ���Ӧ�õ���Ȥ�����ݽṹ����DelayQueue�ࡣ�������Դ�Ŵ��м������ڵ�Ԫ�ء������÷����Ӷ����з��ػ���ȡԪ��ʱ��δ����Ԫ�����ڽ������ԡ���ЩԪ�ض�����Щ�����ǲ��ɼ��ġ�
Ϊ�˾���������Ϊ����ŵ�DelayQueue���е�Ԫ�ر���̳�Delayed�ӿڡ�delayed�ӿ�ʹ�����Ϊ�ӳٶ�����ʹ�����DelayQueue���еĶ�������˼������ڣ������������ڵ�ʱ�䡣�ýӿ�ǿ��ִ����������������
1.compareTo(Delayed o)��Delayed�ӿڼ̳���Comparable�ӿڣ����������������������ǰ������ӳ�ֵС�ڲ��������ֵ��������һ��С��0��ֵ�������ǰ������ӳ�ֵ���ڲ��������ֵ��������һ������0��ֵ��������ߵ��ӳ�ֵ����򷵻�0.
2.getDelay(TimeUnit unit)������������ص��������ڵ�ʣ��ʱ�䣬��λ�ɵ�λ����ָ����

DelayQueue���ṩ�ĳ��÷�����
1.clear()���Ƴ������е�����Ԫ�ء�
2.offer(E e)��E��DelayQueue�ķ��Ͳ�������ʾ������������͡���������Ѳ�����Ӧ��Ԫ�ز��뵽�����С�
3.peek()�����ض����еĵ�һ��Ԫ�أ����������Ƴ���
4.take()�����ض����еĵ�һ��Ԫ�أ��������Ƴ����������Ϊ�գ��߳̽�������ֱ���������п��õ�Ԫ�ء�
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Event> queue = new DelayQueue<>();
		Thread threads[] = new Thread[5];
		for(int i=0;i<threads.length;i++){
			Task task = new Task(i+1,queue);
			threads[i] = new Thread(task);
		}
		for(int i=0;i<threads.length;i++){
			threads[i].start();
		}
		
		for(int i=0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		do{
			int counter = 0;
			Event event;
			do{
				event = queue.poll();
				if(event!=null) counter++;
			}while(event!=null);
			System.out.println("at "+new Date()+" you have read "+counter+" events");
			TimeUnit.MILLISECONDS.sleep(500);
		}while(queue.size()>0);
	}

}
