package com.thread.sample.sample08;
//ʵ����Ʊ����TicketOffice2
public class TicketOffice2 implements Runnable {
	private Cinema cinema;
	public TicketOffice2(Cinema cinema){
		this.cinema =cinema;
	}
	//ʵ��run()��������ģ���˶�������ӰԺ�Ĳ���
	@Override
	public void run() {
		cinema.sellTickets1(4);
		cinema.sellTickets1(3);
		cinema.sellTickets2(6);
		cinema.sellTickets2(2);
		cinema.sellTickets1(2);
		cinema.sellTickets2(4);
	}

}
