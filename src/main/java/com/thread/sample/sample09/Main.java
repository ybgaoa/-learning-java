package com.thread.sample.sample09;
/**
 * 使用锁实现同步
 * 
 * ReentrantLock类是一个可重入的互斥锁，重入锁是一种递归无阻塞的同步机制。ReentrantLock由最近成功获取锁，还没有释放的线程所拥有，当锁被另一个线程拥有时，调用lock的线程可以成功获取锁。如果锁已经被当前线程拥有，当前线程会立即返回。
1、防止重复执行（忽略重复触发）
ReentrantLock lock = new ReentrantLock(); 
public void getObject(){
	//如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
	if (lock.tryLock()) {  
        try {  
            //操作  
        } finally {  
            lock.unlock();  
        }  
    }
}    

2、同步执行，类似synchronized
ReentrantLock lock = new ReentrantLock(); //参数默认false，不公平锁  
//ReentrantLock lock = new ReentrantLock(true); //公平锁  
public void getObject(){
	//如果被其它资源锁定，会在此等待锁释放，达到暂停的效果  
	lock.lock(); 
	try {  
		//操作  
	} finally {  
		lock.unlock();  
	}
}
3、尝试等待执行
ReentrantLock lock = new ReentrantLock(true); //公平锁  
public void getObject(){
	try {  
		if (lock.tryLock(5, TimeUnit.SECONDS)) {      
			//如果已经被lock，尝试等待5s，看是否可以获得锁，如果5s后仍然无法获得锁则返回false继续执行  
			try {  
				//操作  
			} finally {  
				lock.unlock();  
			}  
		}  
	} catch (InterruptedException e) {  
		e.printStackTrace(); //当前线程被中断时(interrupt)，会抛InterruptedException                   
	} 
}

4、可中断锁的同步执行
ReentrantLock lock = new ReentrantLock(true); //公平锁  
public void getObject(){
    lock.lockInterruptibly();  
    try {  
        //操作  
    } catch (InterruptedException e) {  
        e.printStackTrace();  
    } finally {  
        lock.unlock();  
    }
}
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread thread[] = new Thread[10];
		for(int i=0;i<10;i++){
			thread[i] = new Thread(new Job(printQueue),"Thread-"+i);
		}
		for(int i=0;i<10;i++){
			thread[i].start();
		}
	}
}
