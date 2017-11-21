package com.thread.sample.sample02;
/**

1.Thread类中的isInterrupted()方法

2.Thread类的静态方法interrupted()方法

isInterrupted()方法和interrupted()方法的区别是：isInterrupted()方法不能改变interrupted属性的值，但是interrupted()方法能设置interrupted属性为false。因为interrupted()方法是一个静态方法，更推荐使用isInterrupted()方法。
 * @author ybgaoa
 *
 */
public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		while(true){
			if(isPrime(number)){
				System.out.println("Number "+number+" is prime");
			}
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
