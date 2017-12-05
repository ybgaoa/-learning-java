package com.thread.sample.Customizing05;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//���������ڶ�ʱ�̳߳��е�����
//1.����MyScheduledTask�࣬�̳�FutureTask�࣬��ʵ��RunnableScheduledFuture�ӿ�
public class MyScheduledTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
	//2.����һ������Ϊtask��˽��RunnableScheduledFuture��������
	private RunnableScheduledFuture<V> task;
	//3.����һ������Ϊexecutor��˽��ScheduledThreadPoolExecutor��������
	private ScheduledThreadPoolExecutor executor;
	//4.����һ����Ϊperiod��˽��long����
	private long period;
	//5.����һ����ΪstartDate��˽��long����
	private long startDate;
	//6.ʵ�ֹ�����
	public MyScheduledTask(Runnable runnable, V result,RunnableScheduledFuture<V> task,ScheduledThreadPoolExecutor executor) {
		super(runnable, result);
		this.task = task;
		this.executor = executor;
	}
	//7.ʵ��getDelay()�����������������������startDate����ֵ������0�������startDate���Ժ͵�ǰʱ���ʱ�����Ϊ����ֵ��
	//���򷵻ش����task�����е��ӳ�ֵ��
	@Override
	public long getDelay(TimeUnit unit) {
		if(!isPeriodic()){
			return task.getDelay(unit);
		}else{
			if(startDate==0){
				return task.getDelay(unit);
			}else{
				Date now = new Date();
				long delay = startDate - now.getTime();
				return unit.convert(delay, TimeUnit.MILLISECONDS);
			}
		}
	}
	//8.ʵ��compareTo()����
	@Override
	public int compareTo(Delayed o) {
		return task.compareTo(o);
	}
	//9.ʵ��isPeriodic()����
	@Override
	public boolean isPeriodic() {
		return task.isPeriodic();
	}
	//10.ʵ��setPeriod()�������������������
	public void setPeriod(long period){
		this.period = period;
	}
	
	//11.ʵ��run()�������������������������Ҫ��������һ��ִ�еĿ�ʼʱ���������startDate���ԣ�
	//���õ�ǰʱ��������ڼ����Ϊ��һ��ִ�еĿ�ʼʱ�䡣Ȼ���ٴ���������ScheduledThreadPoolExecutor����Ķ����С�
	@Override
	public void run() {
		if(isPeriodic()&&(!executor.isShutdown())){
			Date now = new Date();
			startDate = now.getTime()+period;
			executor.getQueue().add(this);
		}
		System.out.println("Pre-MyScheduledTask:"+new Date());
		System.out.println("MyScheduledTask:is periodic:"+isPeriodic());
		super.runAndReset();
		System.out.println("Post-MyScheduledTask:"+new Date());
	}
}
