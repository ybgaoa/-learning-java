package com.thread.sample.sample02;
/**

1.Thread���е�isInterrupted()����

2.Thread��ľ�̬����interrupted()����

isInterrupted()������interrupted()�����������ǣ�isInterrupted()�������ܸı�interrupted���Ե�ֵ������interrupted()����������interrupted����Ϊfalse����Ϊinterrupted()������һ����̬���������Ƽ�ʹ��isInterrupted()������
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
