package com.thread.sample.sample08;

public class TicketOffice2 implements Runnable {
	private Cinema cinema;
	public TicketOffice2(Cinema cinema){
		this.cinema =cinema;
	}

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
