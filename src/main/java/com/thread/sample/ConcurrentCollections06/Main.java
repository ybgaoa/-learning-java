package com.thread.sample.ConcurrentCollections06;
//���ɲ��������
/**
 * ThreadLocalRandom��
java api�ṩ��һ�������������ڲ�������������α���������ThreadLocalRandom�ࡣ�����̱߳��ر�����ÿ��������������̶߳���һ����ͬ�������������Ƕ���ͬһ�����б������Գ���Ա������͸���ġ�
�����ʹ�ù����Random����Ϊ�����߳���������������ֻ��ƾ��и��õ����ܡ�
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		Thread threads[] = new Thread[3];
		for(int i=0;i<3;i++){
			TaskLocalRandom task = new TaskLocalRandom();
			threads[i] = new Thread(task);
			threads[i].start();
		}

	}

}
