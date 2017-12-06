package com.thread.sample.Customizing10;
//实行自己的原子对象
public class Main {
	public static void main(String[] args) {
		ParkingCounter counter = new ParkingCounter(5);
		Sensor1 sensor1 = new Sensor1(counter);
		Sensor2 sensor2 = new Sensor2(counter);
		
		Thread thread1 = new Thread(sensor1);
		Thread thread2 = new Thread(sensor2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main:number of cars:"+counter.get());
		System.out.println("main:end of the program");
	}

}
