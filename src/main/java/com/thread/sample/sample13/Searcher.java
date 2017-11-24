package com.thread.sample.sample13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
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
