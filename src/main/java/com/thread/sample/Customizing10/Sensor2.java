package com.thread.sample.Customizing10;

public class Sensor2 implements Runnable {
	private ParkingCounter counter;
	public Sensor2(ParkingCounter counter){
		this.counter = counter;
	}
	@Override
	public void run() {
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carOut();
		counter.carOut();
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carOut();
		counter.carOut();
		

	}

}
