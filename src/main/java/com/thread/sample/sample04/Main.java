package com.thread.sample.sample04;

import java.util.concurrent.TimeUnit;
/**
 * �ֲ߳̾�������ʹ��

ThreadLocalΪÿ��ʹ�øñ������̷߳���һ�������ı�������������ÿһ���̶߳����Զ����ظı��Լ��ĸ�����������Ӱ�������߳�����Ӧ�ĸ�����
1��ThreadLocal�����̣߳����̵߳�һ��������������ȼ����Ϊ�߳�������Ա�����
2��ThreadLocal������ͨ������Ϊ��̬������
3��ÿ���߳����Լ���һ��ThreadLocal�����Ǳ�����һ�������������޸�����Ӱ�������̡߳�
ThreadLocal��������Դ��������Ҫά��״̬�������Ҳ����һ���̶߳���Դ���޸ģ���Ӱ����һ���̵߳����У���������ǡ��ռ任ʱ�䡯��synchronized˳��ִ���ǡ�ʱ�任ȡ�ռ䡯��
�ĸ����ķ���˵�����£�
T get()�����ش��ֲ߳̾������ĵ�ǰ�̸߳����е�ֵ��
protected T initialValue()�����ش��ֲ߳̾������ĵ�ǰ�̵߳ġ���ʼֵ����
void remove()���Ƴ����ֲ߳̾�������ǰ�̵߳�ֵ��
void set(T value)�������ֲ߳̾������ĵ�ǰ�̸߳����е�ֵ����Ϊָ��ֵ��
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
//		System.out.println("java�ֲ���������");
//		UnsafeTask ust = new UnsafeTask();
//		for(int i=0;i<10;i++){
//			Thread t = new Thread(ust);
//			t.start();
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.out.println("java�ֲ߳̾���������");
		SafeTask st = new SafeTask();
		for(int i=0;i<10;i++){
			Thread t = new Thread(st);
			t.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
