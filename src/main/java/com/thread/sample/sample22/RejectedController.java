package com.thread.sample.sample22;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("RejectedController:the task "+r.toString()+" has been rejected");
		System.out.println("RejectedController:executor: "+executor.toString());
		System.out.println("RejectedController:terminating: "+executor.isTerminating());
		System.out.println("RejectedController:terminated: "+executor.isShutdown());
	}

}
