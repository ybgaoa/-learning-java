package com.thread.sample.forkjoin01;

import java.util.List;
import java.util.concurrent.RecursiveAction;
//����Task��̳���RecursiveAction�࣬��˲����ؽ��
public class Task extends RecursiveAction {
	private List<Product> products;
	//��������int���ԣ����������Խ���������ִ��ʱ�Բ�Ʒ�ķֿ�
	private int first;
	private int last;
	//��Ʒ�۸�����Ӷ�
	private double increment;
	
	public Task(List<Product> products,int first,int last,double increment){
		this.products = products;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}
	
	@Override
	protected void compute() {
		//���������Ҫ���´���10����Ʒ���������ЩԪ��Ϊ�����֣������������񣬲�����ֵĲ�����Ӧ�ط�����´���������
		if(last-first<10){
			updatePrices();
		}else{
			int middle = (last+first)/2;
			System.out.println("task:pending tasks:"+getQueuedTaskCount());
			Task t1 = new Task(products,first,middle+1,increment);
			Task t2 = new Task(products,middle+1,last,increment);
			//����invokeAll()������ִ��һ���������������Ķ��������
			//����һ��ͬ�����ã�������񽫵ȴ���������ɣ�Ȼ�����ִ��
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
