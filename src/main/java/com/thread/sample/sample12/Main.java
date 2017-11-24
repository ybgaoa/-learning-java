package com.thread.sample.sample12;
/**
 * CountDownLatch类
java并发API提供了CountDownLatch类，它是一个同步辅助类。在完成一组正在其他线程中执行的操作之前，它允许线程一直等待。
这个类使用一个整数进行初始化，这个整数就是线程要等待完成的操作的数目。当一个线程要等待某些操作先执行完时，需要调用await()方法，
这个方法让线程进入休眠直到等待的所有操作都完成。当某一个操作完成后，它将调用countDown()方法将CountDownLatch类的内部计数器减1.当计数器变成0的时候，
CountDownLatch类将唤醒所有调用await()方法而进入休眠的线程。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		//启动会议
		Videoconference videoconference = new Videoconference(10);
		Thread thread = new Thread(videoconference);
		thread.start();
		//启动会议参加人员
		for(int i=0;i<10;i++){
			Participant p = new Participant(videoconference,"Participant-"+i);
			Thread t = new Thread(p);
			t.start();
		}
	}
}
