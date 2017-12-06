package com.thread.sample.sample17;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {
	private Integer number;
	public FactorialCalculator(Integer number){
		this.number = number;
	}
	//实现call()方法，这个方法返回FactorialCalculator类的number属性的阶乘
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if((number==0) || (number==1)){
			result = 1;
		}else{
			for(int i=2;i<=number;i++){
				result *=i;
				TimeUnit.SECONDS.sleep(20);
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+result);
		return result;
	}

}
