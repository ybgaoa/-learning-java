package com.thread.sample.forkjoin01;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
/**
 * Fork/Join���
java 5��ʼ������Executor��ExecutorService�ӿ��Լ�ʵ���������ӿڵ���֮��ʹ��java�ڲ���֧���ϵõ��˽�һ����������
ִ�������(Executor Framework)������Ĵ�����ִ�н����˷��룬ͨ�������ܣ�ֻ��Ҫʵ��Runnable�ӿڵĶ����ʹ��Executor����Ȼ��Runnable�����͸�ִ������ִ�����ٸ���������Щ��������Ҫ���̣߳������̵߳Ĵ������̵߳Ĺ����Լ��̵߳Ľ�����

java 7�����һ������������ExecutorService�ӿڵ���һ��ʵ�֣���������������͵����⣬������Fork/Join��ܣ���ʱҲ�Ʒֽ�/�ϲ���ܡ�
Fork/Join�������������ܹ�ͨ�����μ����������ֳ�С��������⡣
��һ�������У��ȼ�齫Ҫ���������Ĵ�С���������һ���趨�Ĵ�С���Ǿͽ������ֳɿ���ͨ�������ִ�е�С�����������Ĵ�С���趨�Ĵ�СҪС���Ϳ���ֱ��������������������⣬Ȼ�������Ҫ��������Ľ����
û�й̶��Ĺ�ʽ����������Ĳο���С���Ӷ�����һ����������Ҫ���в�ֻ��߲���Ҫ��֣�������������������������ԡ�

��ForkJoinPool�࿴��һ�������Executorִ�������ͣ������ܻ����������ֲ�����
1.�ֽ�(Fork)����������Ҫ��һ�������ֳɸ�С�Ķ������ʱ���ڿ����ִ����Щ����
2.�ϲ�(Join)��������һ��������ȴ��䴴���Ķ������������ִ�С�

Fork/Join��ܺ�ִ�������(Executor Framework)��Ҫ�������ڣ�������ȡ�㷨(Work-Stealing Algorithm)��
��ִ������ܲ�ͬ��ʹ��Join������һ��������ȴ��������������������ɣ�ִ�����������̳߳�֮Ϊ�������߳�(Work Thread)���������߳�Ѱ��������δ��ִ�е�����Ȼ��ʼִ�С�ͨ�����ַ�ʽ����Щ�߳�������ʱӵ�����е��ŵ㣬��������Ӧ�ó�������ܡ�
Ϊ�˴ﵽ���Ŀ�꣬ͨ��Fork/Join���ִ�е��������������ƣ�
1.����ֻ��ʹ��fork()��join()������ͬ�����ơ����ʹ��������ͬ�����ƣ��������߳̾Ͳ���ִ���������񣬵�Ȼ����������ͬ��������ʱ�����磬���Fork/Join����н�һ���������ߣ�����ִ���������Ĺ������߳����������ڲ���ִ����һ������
2.������ִ��I/O�����������ļ����ݵĶ�ȡ��д�롣
3.�������׳�������ʱ�쳣�������ڴ����д������Щ�쳣��

Fork/Join��ܵĺ�������������������ɵģ�
1.ForkJoinPool�������ʵ����ExecutorService�ӿں͹�����ȡ�㷨�������������̣߳����ṩ�����״̬��Ϣ���Լ������ִ����Ϣ��
2.ForkJoinTask���������һ������ForkJoinPool��ִ�е�����Ļ��ࡣ

Fork/Join����ṩ����һ��������ִ��fork()��join()�����Ļ��ƺͿ�������״̬�ķ�����
ͨ����Ϊ��ʵ��Fork/Join������Ҫʵ��һ������������֮һ�����ࣺ
1.RecursiveAction����������û�з��ؽ���ĳ�����
2.RecursiveTask�����������з��ؽ���ĳ�����
 * @author ybgaoa
 *
 */
//ʵ������û�з��ؽ��
public class Main {
	public static void main(String[] args) {
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> products = generator.generate(1000);
		Task task = new Task(products,0,products.size(),0.20);
		//ͨ���޲ε��๹��������һ��ForkJoinPool����
		ForkJoinPool pool = new ForkJoinPool();
		//����execute()����ִ�����񣬸������в�Ʒ���б�����һ��ͬ�����ã����߳�һֱ�ȴ����õ�ִ��
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
		//�ر��̳߳�
		pool.shutdown();
		//����isCompletedNormally()��������������Ƿ��Ѿ���ɲ���û�д���
		if(task.isCompletedNormally()){
			System.out.println("Main:the process has completed normally");
		}
		
		for(int i=0;i<products.size();i++){
			Product product = products.get(i);
			//�����۸���12Ԫ
			if(product.getPrice()!=12){
				System.out.println("Main:product name:"+product.getName()+" value:"+product.getPrice());
			}
		}
		System.out.println("Main:end of the program");
	}

}
