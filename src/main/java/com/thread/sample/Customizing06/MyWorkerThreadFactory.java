package com.thread.sample.Customizing06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;
//����MyWorkerThreadFactory�࣬ʵ��ForkJoinWorkerThreadFactory�ӿ�
public class MyWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
	//ʵ��newThread()��������������������һ��MyWorkThread����
	@Override
	public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
		return new MyWorkThread(pool);
	}

}
