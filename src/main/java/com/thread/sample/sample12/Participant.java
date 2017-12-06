package com.thread.sample.sample12;

import java.util.concurrent.TimeUnit;
//创建与会者类，这个类表示的是视频会议的与会者
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
		//使用视频会议对象videoconference的arrive()方法来表明一个与会者的到来
		videoconference.arrive(name);
	}

}
