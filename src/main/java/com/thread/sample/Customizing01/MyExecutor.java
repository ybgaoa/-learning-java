package com.thread.sample.Customizing01;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//����ThreadPoolExecutor��
//1.����MyExecutor�࣬���̳�ThreadPoolExecutor��
public class MyExecutor extends ThreadPoolExecutor {
	//2.����һ��˽��ConcurrentHashMap���ԣ�����ΪstartTimes
	private ConcurrentHashMap<String, Date> startTimes;
	//3.ʵ�ֹ�������ʹ��super�ؼ��ֵ��ø���Ĺ�������Ȼ���ʼ��startTimes����
	public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		startTimes = new ConcurrentHashMap();
	}
	//4.����shutdown()����������ִ�й�����������ִ�е�����͵ȴ�ִ�е��������Ϣ���������̨��
	//��������ʹ��super�ؼ��ֵ��ø����shutdown()������
	@Override
	public void shutdown() {
		System.out.println("*****************shutdown()*****************");
		System.out.println("myExecutor:going to shutdown");
		System.out.println("myExecutor:executed tasks:"+getCompletedTaskCount());
		System.out.println("myExecutor:running tasks:"+getActiveCount());
		System.out.println("myExecutor:pending tasks:"+getQueue().size());
		super.shutdown();
	}
	//5.����shutdownNow()���������Ѿ�ִ�й�����������ִ�е�����͵ȴ�ִ�е��������Ϣ���������̨��
	//��������ʹ��super�ؼ��ֵ��ø����shutdownNow()������
	@Override
	public List<Runnable> shutdownNow() {
		System.out.println("*****************shutdownNow()*****************");
		System.out.println("myExecutor:going to immediately shutdown");
		System.out.println("myExecutor:executed tasks:"+getCompletedTaskCount());
		System.out.println("myExecutor:running tasks:"+getActiveCount());
		System.out.println("myExecutor:pending tasks:"+getQueue().size());
		return super.shutdownNow();
	}
	//6.����beforeExecute()�����������Ҫִ�е��̵߳����֡�����Ĺ�ϣ�롢��ʼ���ڴ�ŵ�HashMap�У�����������Ĺ�ϣ��ֵ��Ϊ�����ġ�
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("*****************beforeExecute()*****************");
		System.out.println("myExecutor:A task is beginning:"+t.getName()+":"+r.hashCode());
		startTimes.put(String.valueOf(r.hashCode()), new Date());
	}
	//7.����afterExecute()�������������ִ�н�����������̨���õ�ǰʱ���ȥ����ڲ���HashMap�е���ʼ�������������������ʱ�䡣
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("*****************afterExecute()*****************");
		Future<?> result = (Future<?>) r;
		System.out.println("myExecutor:A task is fininshing");
		try {
			System.out.println("myExecutor:result:"+result.get());
			Date startDate = startTimes.remove(String.valueOf(r.hashCode()));
			Date finishDate = new Date();
			long diff = finishDate.getTime()-startDate.getTime();
			System.out.println("myExecutor:duration:"+diff);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
