package com.thread.sample.sample22;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
//创建一个名为RejectedController的类，并实现RejectedExecutionHandler接口，然后实现接口的rejectedExecution()方法，
//在控制台输出已被拒绝的任务的名称和执行器的状态
public class RejectedController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("RejectedController:the task "+r.toString()+" has been rejected");
		System.out.println("RejectedController:executor: "+executor.toString());
		System.out.println("RejectedController:terminating: "+executor.isTerminating());
		System.out.println("RejectedController:terminated: "+executor.isShutdown());
	}

}
