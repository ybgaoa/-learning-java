package com.thread.sample.sample01;
/**
 * thread����һЩ������Ϣ�����ԣ���Щ���Կ���������ʶ�̣߳���ʾ�̵߳�״̬���߿����̵߳����ȼ���

1.ID���������̵߳�Ψһ��ʶ��

2.Name���������̵߳�����

3.Priority���������̶߳�������ȼ����̵߳����ȼ��Ǵ�1��10������1��������ȼ���10��������ȼ���

4.Status���������̵߳�״̬���̵߳�״̬��6�֣�new��runnable��blocked��waiting��time waiting����terminated��
 * @author ybgaoa
 *
 */
public class Caluculator implements Runnable {
	private int number;
	public Caluculator(int number){
		this.number = number;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			System.out.printf("%s: %d*%d = %d\n",Thread.currentThread().getName(),number,i,i*number);
		}

	}

}
