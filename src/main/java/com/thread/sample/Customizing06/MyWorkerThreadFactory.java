package com.thread.sample.Customizing06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;
//创建MyWorkerThreadFactory类，实现ForkJoinWorkerThreadFactory接口
public class MyWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
	//实现newThread()方法。用来创建并返回一个MyWorkThread对象
	@Override
	public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
		return new MyWorkThread(pool);
	}

}
