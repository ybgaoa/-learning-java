package com.thread.sample.sample08;
//实现售票处类TicketOffice2
public class TicketOffice2 implements Runnable {
	private Cinema cinema;
	public TicketOffice2(Cinema cinema){
		this.cinema =cinema;
	}
	//实现run()方法，它模拟了对两个电影院的操作
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
