package com.thread.sample.sample06;

/**
 * ʹ�ù����ഴ���߳�
 * 
 * ����ģʽ��������������ʹ�õ�ģʽ֮һ������һ��������ģʽ��ʹ��һ����Ϊ������һ�����߶���ഴ�����󡣵�����ҪΪ��Щ�ഴ������ʱ��������ʹ��new����������ʹ�ù����ࡣ
ʹ�ù����࣬���Խ�����Ĵ������л��������������µĺô���
1���������޸��࣬���߸ı䴴������ķ�ʽ��
2��������Ϊ������Դ���ƴ����������Ŀ�����磬���ǿ�������һ�����͵Ķ��󲻶���n����
3��������Ϊ�����Ķ�������ͳ�����ݡ�
Java�ṩ��ThreadFactory�ӿڣ�����ӿ�ʵ�����̶߳��󹤳���Java����API�ĸ߼�������Ҳʹ�����̹߳��������̡߳�
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		//����һ���Զ���Ĺ�����
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread t;
        System.out.println("Starting the Threads");
        //ʹ�ù����ഴ��10���̶߳���
        for(int i=0;i<10;i++){
        	//ʹ�ù����ഴ���߳�
            t = factory.newThread(task);
            t.start();
        }
        System.out.println("Factory stats:");
        System.out.println(factory.getStats());
    }
}
