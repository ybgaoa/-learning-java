package com.thread.sample.forkjoin01;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
/**
 * Fork/Join框架
java 5开始引入了Executor和ExecutorService接口以及实现这两个接口的类之后，使得java在并发支持上得到了进一步的提升。
执行器框架(Executor Framework)将任务的创建和执行进行了分离，通过这个框架，只需要实现Runnable接口的对象和使用Executor对象，然后将Runnable对象发送给执行器。执行器再负责运行这些任务所需要的线程，包括线程的创建，线程的管理以及线程的结束。

java 7则更进一步，它包括了ExecutorService接口的另一种实现，用来解决特殊类型的问题，它就是Fork/Join框架，有时也称分解/合并框架。
Fork/Join框架是用来解决能够通过分治技术将问题拆分成小任务的问题。
在一个任务中，先检查将要解决的问题的大小，如果大于一个设定的大小，那就将问题拆分成可以通过框架来执行的小任务。如果问题的大小比设定的大小要小，就可以直接在任务里面解决这个问题，然后根据需要返回任务的结果。
没有固定的公式来决定问题的参考大小，从而决定一个任务是需要进行拆分或者不需要拆分，拆分与否是依赖于任务本身的特性。

将ForkJoinPool类看作一个特殊的Executor执行器类型，这个框架基于以下两种操作：
1.分解(Fork)操作：当需要将一个任务拆分成更小的多个任务时，在框架中执行这些任务。
2.合并(Join)操作：当一个主任务等待其创建的多个子任务的完成执行。

Fork/Join框架和执行器框架(Executor Framework)主要区别在于：工作窃取算法(Work-Stealing Algorithm)。
与执行器框架不同，使用Join操作让一个主任务等待它所创建的子任务的完成，执行这个任务的线程称之为工作者线程(Work Thread)。工作者线程寻找其他仍未被执行的任务，然后开始执行。通过这种方式，这些线程在运行时拥有所有的优点，进而提升应用程序的性能。
为了达到这个目标，通过Fork/Join框架执行的任务有以下限制：
1.任务只能使用fork()和join()操作当同步机制。如果使用其他的同步机制，工作者线程就不能执行其他任务，当然这任务是在同步操作里时。比如，如果Fork/Join框架中将一个任务休眠，正在执行这个任务的工作者线程在休眠期内不能执行另一个任务。
2.任务不能执行I/O操作，比如文件数据的读取与写入。
3.任务不能抛出非运行时异常，必须在代码中处理掉这些异常。

Fork/Join框架的核心是由以下两个类组成的：
1.ForkJoinPool：这个类实现了ExecutorService接口和工作窃取算法。它管理工作者线程，并提供任务的状态信息，以及任务的执行信息。
2.ForkJoinTask：这个类是一个将在ForkJoinPool中执行的任务的基类。

Fork/Join框架提供了再一个任务里执行fork()和join()操作的机制和控制任务状态的方法。
通常，为了实现Fork/Join任务，需要实现一个以下两个类之一的子类：
1.RecursiveAction：用于任务没有返回结果的场景。
2.RecursiveTask：用于任务有返回结果的场景。
 * @author ybgaoa
 *
 */
//实现任务没有返回结果
public class Main {
	public static void main(String[] args) {
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> products = generator.generate(1000);
		Task task = new Task(products,0,products.size(),0.20);
		//通过无参的类构造器创建一个ForkJoinPool对象
		ForkJoinPool pool = new ForkJoinPool();
		//调用execute()方法执行任务，更新所有产品的列表，它是一个同步调用，主线程一直等待调用的执行
		pool.execute(task);
		do{
			System.out.println("Main:Thread count:"+pool.getActiveThreadCount());
			System.out.println("Main:Thread steal:"+pool.getStealCount());
			System.out.println("Main:parallelism:"+pool.getParallelism());
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!task.isDone());
		//关闭线程池
		pool.shutdown();
		//调用isCompletedNormally()方法，检查任务是否已经完成并且没有错误
		if(task.isCompletedNormally()){
			System.out.println("Main:the process has completed normally");
		}
		
		for(int i=0;i<products.size();i++){
			Product product = products.get(i);
			//期望价格是12元
			if(product.getPrice()!=12){
				System.out.println("Main:product name:"+product.getName()+" value:"+product.getPrice());
			}
		}
		System.out.println("Main:end of the program");
	}

}
