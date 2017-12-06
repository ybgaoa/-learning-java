package com.thread.sample.sample08;
/**
 * ʹ�÷���������ʵ��ͬ��
 * 
 * ͬ�������
����synchronized�ؼ������ε����顣
���ùؼ������ε�������Զ����������������Ӷ�ʵ��ͬ��
�����磺
synchronized(object){}
Java������Ķ��󶼿�����Ϊһ��������(monitor)�����������Ա������ͽ��������߳�ͬ���г�Ϊͬ��������ͬ������ͬһʱ��ֻ�ܱ�һ���߳������С������obj�������һ��ͬ����������һ����������ִ�й��̣�
1).һ���߳�ִ�е�synchronized����飬���ȼ��obj�����objΪ�գ��׳�NullPointerExpression�쳣��
2).���obj��Ϊ�գ��̳߳��Ը�����������������������Ѿ����������̲߳��ܻ�ȡ�������߳̾ͱ�������
3).���������û���������߳̽����������������ҳ��и�����Ȼ��ִ�д���飻
4).���������ִ�н������߷����������������������Զ�������

�߳�ͬ�����Զ���̱߳����ǻ���ģ�������߳���Ҫʹ��ͬһ��ͬ������������obj���󱻶���̹߳����ܹ�ʵ��ͬ����
ע��ͬ����һ�ָ߿����Ĳ��������Ӧ�þ�������ͬ�������ݡ�
ͨ��û�б�Ҫͬ������������ʹ��synchronized�����ͬ���ؼ����뼴�ɡ� 

���ߵ�������Ҫ������ͬ�������档����ʵ����ͬ����������Ϊֻ��ʹ��this����Ϊͬ���������һ��������Ҫʹ�õ��������Ϊ�˱������ĳ�ͻ����Ȼ��Ҫʹ�ò�ͬ�Ķ�����ʱ��ͬ������������������ֻ��ʹ��ͬ�������(ͬ���������Դ����������)�����߶��������Ҫʹ�õ�ͬһ��������ʱ�������ʵ��this��Ȼ�ǲ�ͬ�ģ�Ҳֻ��ʹ��ͬ������飬����ͬһ������
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1,"ticketOffice1");
		
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2,"ticketOffice2");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Room 1 Vacancies:"+cinema.getVacanciesCinema1());
		System.out.println("Room 2 Vacancies:"+cinema.getVacanciesCinema2());
	}

}
