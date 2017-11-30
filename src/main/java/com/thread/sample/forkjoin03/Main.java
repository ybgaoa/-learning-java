package com.thread.sample.forkjoin03;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
//异步运行任务
public class Main {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		FolderProcessor system = new FolderProcessor("c:\\Windows","log");
		FolderProcessor apps = new FolderProcessor("c:\\Program Files","log");
		FolderProcessor documents = new FolderProcessor("c:\\Documents and Settings","log");
		//调用execute()方法发送3个初始任务到线程池中
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);
		
		do{
			/**
			 * ForkJoinPool类中的以下方法：
			    getPoolSize(): 此方法返回 int 值，它是ForkJoinPool内部线程池的worker线程们的数量。
			    getParallelism(): 此方法返回池的并行的级别。
			    getActiveThreadCount(): 此方法返回当前执行任务的线程的数量。
			    getRunningThreadCount():此方法返回没有被任何同步机制阻塞的正在工作的线程。
			    getQueuedSubmissionCount(): 此方法返回已经提交给池还没有开始他们的执行的任务数。
			    getQueuedTaskCount(): 此方法返回已经提交给池已经开始他们的执行的任务数。
			    hasQueuedSubmissions(): 此方法返回 Boolean 值，表明这个池是否有queued任务还没有开始他们的执行。
			    getStealCount(): 此方法返回 long 值，worker 线程已经从另一个线程偷取到的时间数。
			    isTerminated(): 此方法返回 Boolean 值，表明 fork/join 池是否已经完成执行。
			 */
			System.out.println("**************************************");
			System.out.println("main:parallelism:"+pool.getParallelism());
			System.out.println("main:active threads:"+pool.getActiveThreadCount());
			System.out.println("main:task count:"+pool.getQueuedTaskCount());
			System.out.println("main:steal count:"+pool.getStealCount());
			System.out.println("***************************************");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while((!system.isDone())||(!apps.isDone())||(!documents.isDone()));
		//关闭线程池
		pool.shutdown();
		
		List<String> results;
		//调用Join()方法等待发送到线程池中的所有子任务执行完成。
		results = system.join();
		System.out.println("main:system:"+results.size()+" files found");
		results = apps.join();
		System.out.println("main:apps:"+results.size()+" files found");
		results = documents.join();
		System.out.println("main:documents:"+results.size()+" files found");
	}

}
