package com.thread.sample.sample14;

import java.util.concurrent.Phaser;
/**
 * �����׶����������
 * 
 * Phaser��
java����API���ṩ��һ�������ӡ���ǿ���ͬ�������࣬��Phaser��������ִ�в�����׶����񡣵������в�����������Ҫ�ֽ�ɼ���ִ��ʱ�����ֻ��ƾͷǳ����á�Phaser���������ÿһ��������λ�ö��߳̽���ͬ���������е��̶߳��������һ����������ִ����һ����
���÷�����
arriveAndDeregister()����������Phaser�����arriveAndDeregister()������֪ͨPhaser����ǰ�߳��Ѿ���������׶Σ����ҽ����ٲ���������Ľ׶β������൱��ȡ�����̵߳�ע�ᡣ
arriveAndAwaitAdvance()����������Phaser�����arriveAndAwaitAdvance()��������֪ͨPhaser����ǰ�߳��Ѿ�����˵�ǰ�׶Σ���Ҫ������ֱ�������߳�Ҳ����ɵ�ǰ�׶Ρ�
isTerminated()������������phaser�����isTerminated()��������phaser���󲻴��ڲ���ͬ�����߳�ʱ��phaser����ֹ�ģ��÷���������true����ȡ�������̵߳�ע��ʱ��phaser����ͻ�����ֹ״̬��
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		//ָ������׶�ͬ�����߳���3��
		Phaser phaser = new Phaser(3);
		FileSearch system = new FileSearch("c:\\Windows","log",phaser);
		FileSearch apps = new FileSearch("c:\\Program Files","log",phaser);
		FileSearch documents = new FileSearch("c:\\Documents And Settings","log",phaser);
		
		Thread systemThread = new Thread(system,"system");
		systemThread.start();
		Thread appsThread = new Thread(apps,"apps");
		appsThread.start();
		Thread documentsThread = new Thread(documents,"documents");
		documentsThread.start();
		
		try {
			systemThread.join();
			appsThread.join();
			documentsThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����̶߳���ɺ󣬵�����phaser�����isTerminated()������
		//��phaser���󲻴��ڲ���ͬ�����߳�ʱ��phaser����ֹ�ģ��÷���������true����ȡ�������̵߳�ע��ʱ��phaser����ͻ�����ֹ״̬��
		System.out.println("Terminated:"+phaser.isTerminated());
	}
}
