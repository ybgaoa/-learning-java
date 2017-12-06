package com.thread.sample.sample09;
/**
 * ʹ����ʵ��ͬ��
 * 
 * ReentrantLock����һ��������Ļ���������������һ�ֵݹ���������ͬ�����ơ�ReentrantLock������ɹ���ȡ������û���ͷŵ��߳���ӵ�У���������һ���߳�ӵ��ʱ������lock���߳̿��Գɹ���ȡ����������Ѿ�����ǰ�߳�ӵ�У���ǰ�̻߳��������ء�
1����ֹ�ظ�ִ�У������ظ�������
ReentrantLock lock = new ReentrantLock(); 
public void getObject(){
	//����Ѿ���lock������������false����ȴ����ﵽ���Բ�����Ч��
	if (lock.tryLock()) {  
        try {  
            //����  
        } finally {  
            lock.unlock();  
        }  
    }
}    

2��ͬ��ִ�У�����synchronized
ReentrantLock lock = new ReentrantLock(); //����Ĭ��false������ƽ��  
//ReentrantLock lock = new ReentrantLock(true); //��ƽ��  
public void getObject(){
	//�����������Դ���������ڴ˵ȴ����ͷţ��ﵽ��ͣ��Ч��  
	lock.lock(); 
	try {  
		//����  
	} finally {  
		lock.unlock();  
	}
}
3�����Եȴ�ִ��
ReentrantLock lock = new ReentrantLock(true); //��ƽ��  
public void getObject(){
	try {  
		if (lock.tryLock(5, TimeUnit.SECONDS)) {      
			//����Ѿ���lock�����Եȴ�5s�����Ƿ���Ի���������5s����Ȼ�޷�������򷵻�false����ִ��  
			try {  
				//����  
			} finally {  
				lock.unlock();  
			}  
		}  
	} catch (InterruptedException e) {  
		e.printStackTrace(); //��ǰ�̱߳��ж�ʱ(interrupt)������InterruptedException                   
	} 
}

4�����ж�����ͬ��ִ��
ReentrantLock lock = new ReentrantLock(true); //��ƽ��  
public void getObject(){
    lock.lockInterruptibly();  
    try {  
        //����  
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
