package com.thread.sample.sample01;
/**
 * thread类有一些保存信息的属性，这些属性可以用来标识线程，显示线程的状态或者控制线程的优先级。

1.ID：保存了线程的唯一标识符

2.Name：保存了线程的名称

3.Priority：保存了线程对象的优先级。线程的优先级是从1到10，其中1是最低优先级，10是最高优先级。

4.Status：保存了线程的状态。线程的状态有6种：new、runnable、blocked、waiting、time waiting或者terminated。
 * @author ybgaoa
 *
 */
public class Caluculator implements Runnable {
	private int number;
	public Caluculator(int number){
		this.number = number;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			System.out.printf("%s: %d*%d = %d\n",Thread.currentThread().getName(),number,i,i*number);
		}

	}

}
