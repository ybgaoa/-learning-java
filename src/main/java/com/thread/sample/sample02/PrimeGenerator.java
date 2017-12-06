package com.thread.sample.sample02;
/**

1.Thread类中的isInterrupted()方法

2.Thread类的静态方法interrupted()方法

isInterrupted()方法和interrupted()方法的区别是：isInterrupted()方法不能改变interrupted属性的值，但是interrupted()方法能设置interrupted属性为false。因为interrupted()方法是一个静态方法，更推荐使用isInterrupted()方法。
 * @author ybgaoa
 *
 */
public class PrimeGenerator extends Thread {
	//覆盖run()方法。并在方法体内包含一个无限循环。在每次循环中，我们将处理从1开始的连续数。
	//对每个数字，我们将计算它是不是一个质数，如果是的话就打印到控制台。
	@Override
	public void run() {
		long number = 1L;
		while(true){
			//判断是否质数
			if(isPrime(number)){
				System.out.println("Number "+number+" is prime");
			}
			//调用isInterrupted()方法来检查线程是否被中断
			if(isInterrupted()){
				System.out.println("the prime generator has been interrupted");
				return;
			}
			number++;
		}
	}
	private boolean isPrime(long number){
		if(number<=2){
			return true;
		}
		for(long i=2;i<number;i++){
			if((number % i)==0){
				return false;
			}
		}
		return true;
	}
}
