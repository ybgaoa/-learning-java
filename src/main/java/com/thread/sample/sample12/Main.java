package com.thread.sample.sample12;
/**
 * CountDownLatch��
java����API�ṩ��CountDownLatch�࣬����һ��ͬ�������ࡣ�����һ�����������߳���ִ�еĲ���֮ǰ���������߳�һֱ�ȴ���
�����ʹ��һ���������г�ʼ����������������߳�Ҫ�ȴ���ɵĲ�������Ŀ����һ���߳�Ҫ�ȴ�ĳЩ������ִ����ʱ����Ҫ����await()������
����������߳̽�������ֱ���ȴ������в�������ɡ���ĳһ��������ɺ���������countDown()������CountDownLatch����ڲ���������1.�����������0��ʱ��
CountDownLatch�ཫ�������е���await()�������������ߵ��̡߳�
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		//��������
		Videoconference videoconference = new Videoconference(10);
		Thread thread = new Thread(videoconference);
		thread.start();
		//��������μ���Ա
		for(int i=0;i<10;i++){
			Participant p = new Participant(videoconference,"Participant-"+i);
			Thread t = new Thread(p);
			t.start();
		}
	}
}
