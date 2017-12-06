package com.thread.sample.sample13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//实现查找类，它在随机数矩阵指定的行中查找某个数
public class Searcher implements Runnable {
	//属性firstRow、lastRow将决定查找的子集范围
	private int firstRow;
	private int lastRow;
	private MatrixMock mock;
	private Results results;
	private int number;
	private final CyclicBarrier barrier;
	
	public Searcher(int firstRow,int lastRow,MatrixMock mock,Results results,int number,CyclicBarrier barrier){
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.mock = mock;
		this.results = results;
		this.number = number;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		int counter;
		System.out.println(Thread.currentThread().getName()+":processing lines from "+firstRow+" to "+lastRow);
		//在要查找的所有的行中进行查找。对每一行查找指定的数字，并将查找到的次数保存到对应的result对象的相应位置
		for(int i=firstRow;i<lastRow;i++){
			int row[] = mock.getRow(i);
			counter = 0;
			for(int j=0;j<row.length;j++){
				if(row[j]==number){
					counter++;
				}
			}
			results.setData(i, counter);
		}
		System.out.println(Thread.currentThread().getName()+":lines processed");
		try {
			//调用await()方法等待其他的线程
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
