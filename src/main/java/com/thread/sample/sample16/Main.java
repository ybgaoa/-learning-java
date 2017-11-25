package com.thread.sample.sample16;
//创建执行器线程
/**
 * 线程执行器
自从java 5开始，java并发API提供了一套机制，这套机制称之为执行器框架(Executor Framework)，围绕着Executor接口和它的子接口ExecutorService，以及实现这两个接口ThreadPoolExecutor类展开。
这套机制分离了任务的创建和执行。通过使用执行器，仅需要实现Runnable接口的对象，然后将这些对象发送给执行器即可。
执行器通过创建所需的线程，来负责这些Runnable对象的创建、实例化以及运行。
但是执行器功能不限于此，它使用了线程池来提高应用程序的性能。当发送一个任务给执行器时，执行器会尝试使用线程池中的线程来执行这个任务，避免了不断地创建和销毁线程而导致系统性能下降。
执行器框架另外一个重要的优势是Callable接口。它类似于Runnable接口，但是却提供了两方面的增强：
1).这个接口的主方法名称为call()，可以返回结果。
2).当发送一个Callable对象给执行器时，将获得一个实现Future接口的对象，可以使用这个对象来控制Callable对象的状态和结果。

创建线程执行器的基本步骤：
1).通过Executors类来创建线程执行器的线程池，例如；
ThreadPoolExecutor executor = Executors.newCachedThreadPool();
注：Executors类可以创建多种类型的线程池，如：
Executors.newCachedThreadPool()：是一个会根据需要创建新线程的线程池。
Executors.newSingleThreadExecutor()：是使用单个worker线程的Executor。
Executors.newFixedThreadPool()：被称为可重用固定线程数的线程池
2).通过线程池对象执行任务
executor.execute(task);//该方法执行后没有返回值
或者
executor.submit(task);//该方法执行后返回Future接口对象，该接口中声明了一些方法来获取任务对象产生的结果，并管理它们的状态
注：一旦创建了执行器，就可以使用执行器的execute()方法或者submit()方法来发送Runnable或者Callable类型的任务
3).关闭线程执行器
executor.shutdown();
注：执行器以及ThreadPoolExecutor类一个重要的特性是，通常需要显示的去结束它。
如果不这样做，那么执行器将继续执行，程序也不会结束。如果执行器没有任务可执行了，它将继续等待新任务的到来，而不会结束执行。
java应用程序不会结束直到所有非守护线程结束它们的运行，因此，如果没有终止执行器，应用程序将永远不会结束。

ThreadPoolExecutor类：作为java.util.concurrent包对外提供基础实现，以内部线程池的形式对外提供管理任务执行，线程调度，线程池管理等等服务。
ScheduledThreadPoolExecutor类：是线程池执行器的一种，继承ThreadPoolExecutor，在ThreadPoolExecutor的基础上添加了按计划执行线程的功能，如延迟执行、定时执行、周期性执行。
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		for(int i=0;i<10;i++){
			Task task = new Task("task-"+i);
			server.executeTask(task);
		}
		server.endServer();

	}

}
