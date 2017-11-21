package com.thread.sample.sample06;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	//仅仅是让线程休眠1秒
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
