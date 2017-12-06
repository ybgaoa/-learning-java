package com.thread.sample.sample15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
/**
 * �������������ݽ���
 * 
 * Exchanger��
java����API���ṩ��һ��ͬ�������࣬������Exchanger���������ڲ�������֮�佻�����ݡ�
������˵��Exchanger�������������߳�֮�䶨��ͬ���㡣�������̶߳�����ͬ����ʱ�����ǽ������ݽṹ��
��˵�һ���̵߳����ݽṹ���뵽�ڶ����߳��У�ͬʱ�ڶ����̵߳����ݽṹ���뵽��һ���߳��С�
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();
		
		Exchanger<List<String>> exchanger = new Exchanger<>();
		Producer producer = new Producer(buffer1,exchanger);
		Consumer consumer = new Consumer(buffer2,exchanger);
		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);
		threadProducer.start();
		threadConsumer.start();
	}
}
