package com.thread.sample.sample12;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
	private Videoconference videoconference;
	private String name;
	public Participant(Videoconference videoconference,String name){
		this.videoconference = videoconference;
		this.name = name;
	}
	@Override
	public void run() {
		long duration = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		videoconference.arrive(name);
	}

}
