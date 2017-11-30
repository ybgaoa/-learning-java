package com.thread.sample.forkjoin01;

import java.util.List;
import java.util.concurrent.RecursiveAction;
//由于Task类继承了RecursiveAction类，因此不返回结果
public class Task extends RecursiveAction {
	private List<Product> products;
	//声明两个int属性，这两个属性将决定任务执行时对产品的分块
	private int first;
	private int last;
	//产品价格的增加额
	private double increment;
	
	public Task(List<Product> products,int first,int last,double increment){
		this.products = products;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}
	
	@Override
	protected void compute() {
		//如果任务需要更新大于10个产品，将拆分这些元素为两部分，创建两个任务，并将拆分的部分相应地分配给新创建的任务
		if(last-first<10){
			updatePrices();
		}else{
			int middle = (last+first)/2;
			System.out.println("task:pending tasks:"+getQueuedTaskCount());
			Task t1 = new Task(products,first,middle+1,increment);
			Task t2 = new Task(products,middle+1,last,increment);
			//调用invokeAll()方法来执行一个主任务所创建的多个子任务
			//这是一个同步调用，这个任务将等待子任务完成，然后继续执行
			invokeAll(t1,t2);
		}

	}
	
	private void updatePrices(){
		for(int i=first;i<last;i++){
			Product product = products.get(i);
			product.setPrice(product.getPrice()*(1+increment));
		}
	}

}
