package com.thread.sample.sample13;

import java.util.concurrent.CyclicBarrier;
/**
 * �ڼ��ϵ��ͬ��
 * 
 * CyclicBarrier��
 * CyclicBarrier����һ���ڲ������������Կ���ָ����Ŀ�ļ����̱߳��붼���Ｏ�ϵ㡣
 * ÿһ���̵߳��Ｏ�ϵ��ͻ����await()����֪ͨCyclicBarrier����CyclicBarrier�����������߳�����ֱ���������е��̶߳����Ｏ�ϵ㡣
 * �������̶߳����Ｏ�ϵ��CyclicBarrier����ͻ���������await()������ȴ����̣߳�ͬʱ���������Թ����������Runnable���󴴽�һ���µ��̣߳���ִ����������
 * 
java����API�ṩ��CyclicBarrier�࣬����һ��ͬ�������ࡣ�������������߶���߳���ĳ�����Ͻ���ͬ����
CyclicBarrier��ʹ����һ�����������г�ʼ�������������Ҫ��ĳ������ͬ�����߳�������һ���̵߳���ָ���ĵ����������await()�����ȴ��������̡߳����̵߳���await()������CyclicBarrier�ཫ��������̲߳�ʹ֮����ֱ�����������̵߳�������һ���̵߳���CyclicBarrier���await()����ʱ��CyclicBarrier���󽫻��������ڵȴ����̣߳�Ȼ����Щ�߳̽�����ִ�С�
CyclicBarrier���ṩ��getNumberWaiting()������getparties()������ǰ�߽�������await()���������̵߳���Ŀ�����߷��ر�CyclicBarrier����ͬ������������
CyclicBarrier��������ã���ͨ��CyclicBarrier���ṩ��reset()������ɵġ������÷�������awai()�����еȴ����߳̽��յ�һ��BrokenBarrierException�쳣��
CyclicBarrier���ṩ��isBroken()���������������״̬����true�����򷵻�false.
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICHIPANIS = 5;
		final int LINES_PARTICIPANT = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS,NUMBERS,SEARCH);
		Results results = new Results(ROWS);
		Grouper grouper = new Grouper(results);
		//ʹ��CyclicBarrier����ͬ��5���̣߳�ִ��Grouper�����������������Ҽ������յĽ��
		CyclicBarrier barrier = new CyclicBarrier(PARTICHIPANIS,grouper);
		Searcher searchers[] = new Searcher[PARTICHIPANIS];
		for(int i=0;i<PARTICHIPANIS;i++){
			searchers[i] = new Searcher(i*LINES_PARTICIPANT,(i*LINES_PARTICIPANT)+LINES_PARTICIPANT,mock,results,5,barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		System.out.println("Main:the main thread has finished");
	}

}
