package com.thread.sample.ConcurrentCollections08;

import java.util.concurrent.atomic.AtomicIntegerArray;
//ʹ��ԭ������
/**
 * AtomicIntegerArray��
��ʵ��һ������Ӧ��ʱ�������ɱ���ػ��ж��̹߳���һ���������������Ϊ�˱������ݲ�һ�´�����Ҫʹ��ͬ����������������Щ�������Եķ��ʡ�������Щͬ�����ƴ����������⡣
1.������һ���̱߳�������������ͼ��õ������������߳�ʹ�ã��������߳���Զ�����ͷ���������������ʹ��Ӧ�ò������ִ�У�������Զ���������
2.��ʹֻ��һ���̷߳��ʹ����������Ȼ��Ҫִ�б���Ĵ�������ȡ���ͷ�����
������������Ϊ���ṩ���ŵ����ܣ�java���������˱ȽϺͽ����������������ʹ��һ�������޸ı�����ֵ��
1.ȡ�ñ���ֵ���������ľ�ֵ��
2.��һ����ʱ�������޸ı���ֵ������������ֵ��
3.��������õı�����ֵ�뵱ǰ����ֵ��ȣ�������ֵ�滻��ֵ��������������߳��޸������������ֵ�������õı����ľ�ֵ�Ϳ����뵱ǰ����ֵ��ͬ��
���ñȽϺͽ������Ʋ���Ҫʹ��ͬ�����ƣ��������Ա��������������ܸ��á�
java��ԭ�ӱ�����ʵ�������ֻ��ơ���Щ�����ṩ��ʵ�ֱȽϺͽ���������compareAndSet()��������������Ҳ������չ����
javaҲ������ԭ������(Atomic Array)�ṩ��integer��long���������ԭ�Ӳ�����
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		final int THREADS = 100;
		AtomicIntegerArray vector = new AtomicIntegerArray(1000);
		Incrementer incrementer = new Incrementer(vector);
		Decrementer decrementer = new Decrementer(vector);
		Thread thread_incrementer[] = new Thread[THREADS];
		Thread thread_decrementer[] = new Thread[THREADS];
		
		for(int i=0;i<THREADS;i++){
			thread_incrementer[i] = new Thread(incrementer);
			thread_decrementer[i] = new Thread(decrementer);
			
			thread_incrementer[i].start();
			thread_decrementer[i].start();
		}
		
		for(int i=0;i<100;i++){
			try {
				thread_incrementer[i].join();
				thread_decrementer[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<vector.length();i++){
			if(vector.get(i)!=0){
				System.out.println("vector["+i+"]:"+vector.get(i));
			}
		}
		
		System.out.println("main:end of zhe example");
	}

}
