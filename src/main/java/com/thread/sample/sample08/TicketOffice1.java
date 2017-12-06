package com.thread.sample.sample08;
//实现售票处类TicketOffice1
public class TicketOffice1 implements Runnable {
	private Cinema cinema;
	public TicketOffice1(Cinema cinema){
		this.cinema =cinema;
	}
	//实现run()方法，它模拟了对两个电影院的操作
	@Override
	public void run() {
		cinema.sellTickets1(2);
		cinema.sellTickets1(4);
		cinema.sellTickets2(3);
		cinema.sellTickets2(1);
		cinema.sellTickets1(5);
		cinema.sellTickets2(3);
	}

}
