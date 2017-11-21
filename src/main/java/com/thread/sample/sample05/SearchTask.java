package com.thread.sample.sample05;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * 线程的分组

Java Concurrent API中提供了对线程进行分组管理的ThreadGroup，使得我们可以将多个线程看作一个单元，对这些线程执行操作，如中断一组线程等。

ThreadGroup类有很多方法，它的API文档提供了所有的方法的完整解释。




 * @author ybgaoa
 *
 */
public class SearchTask implements Runnable {
	@Override  
    public void run() {  
        String name = Thread.currentThread().getName();  
        System.out.printf("Thread_%s: Start\n", name);  
        try {  
            doTask();  
        } catch (InterruptedException e) {  
            System.out.printf("Thread %s: Interrupted\n", name);  
        }  
        System.out.printf("Thread %s: End\n", name);  
    }  
  
    private void doTask() throws InterruptedException {  
        Random random = new Random((new Date()).getTime());  
        int value = (int) (random.nextDouble() * 100);  
        System.out.printf("Thread_%s: %d\n", Thread.currentThread().getName(), value);  
        TimeUnit.SECONDS.sleep(value);  
    }  
  
    public static void main(String[] args) {  
        ThreadGroup threadGroup = new ThreadGroup("Searcher");  
        SearchTask searchTask=new SearchTask();  
        for (int i = 0; i < 10; i++) {  
            Thread thread = new Thread(threadGroup,searchTask);  
            thread.start();  
            try {  
                TimeUnit.SECONDS.sleep(1);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
  
        System.out.printf("Number of Threads:%d\n", threadGroup.activeCount());  
        System.out.printf("Information of the Thread Group\n");  
        threadGroup.list();  
        Thread[] threads = new Thread[threadGroup.activeCount()];  
        threadGroup.enumerate(threads);  
        for (Thread thread : threads) {  
            System.out.printf("Thread ====%s: %s\n", thread.getName(), thread.getState());  
        }  
  
        // Wait unit one of the threads fo ThreadGroup objects ends.  
        waitFinish(threadGroup);  
  
        threadGroup.interrupt();  
  
    }  
  
    private static void waitFinish(ThreadGroup threadGroup) {  
        while (threadGroup.activeCount() > 9) {  
            try {  
                TimeUnit.SECONDS.sleep(1);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  

}
