package com.thread.sample.Customizing09;

public class Consumer implements Runnable {
	private MyPriorityTransferQueue<Event> buffer;
	public Consumer(MyPriorityTransferQueue<Event> buffer){
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for(int i=0;i<1002;i++){
			try {
				Event event = buffer.take();
				System.out.println("consumer:"+event.getThread()+":"+event.getPriority());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
