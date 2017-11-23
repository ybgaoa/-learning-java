package com.thread.sample.sample08;

public class TicketOffice1 implements Runnable {
	private Cinema cinema;
	public TicketOffice1(Cinema cinema){
		this.cinema =cinema;
	}

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
