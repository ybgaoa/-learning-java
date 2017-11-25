package com.thread.sample.sample16;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	//声明ThreadPoolExecutor类对象
	private ThreadPoolExecutor executor;
	public Server(){
		//通过Executors类来初始化ThreadPoolExecutor类的对象，创建执行器线程池
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public void executeTask(Task task){
		System.out.println("server:a new task has arrived");
		//一旦创建了执行器，就可以使用执行器的execute()方法来发送Runnable或者Callable类型的任务
		executor.execute(task);
		System.out.println("server:pool size:"+executor.getPoolSize());//返回执行器线程池中实际的线程数
		System.out.println("server:active count:"+executor.getActiveCount());//返回执行器中正在执行任务的线程数
		System.out.println("server:completed tasks:"+executor.getCompletedTaskCount());//返回执行器已经完成的任务数
	}
	
	public void endServer(){
		//执行器以及ThreadPoolExecutor类一个重要的特性是，通常需要显示的去结束它。
		//如果不这样做，那么执行器将继续执行，程序也不会结束。如果执行器没有任务可执行了，它将继续等待新任务的到来，而不会结束执行。
		//java应用程序不会结束直到所有非守护线程结束它们的运行，因此，如果没有终止执行器，应用程序将永远不会结束。
		executor.shutdown();
	}
}
