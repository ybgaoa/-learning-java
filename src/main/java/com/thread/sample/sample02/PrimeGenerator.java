package com.thread.sample.sample02;
/**

1.Thread���е�isInterrupted()����

2.Thread��ľ�̬����interrupted()����

isInterrupted()������interrupted()�����������ǣ�isInterrupted()�������ܸı�interrupted���Ե�ֵ������interrupted()����������interrupted����Ϊfalse����Ϊinterrupted()������һ����̬���������Ƽ�ʹ��isInterrupted()������
 * @author ybgaoa
 *
 */
public class PrimeGenerator extends Thread {
	//����run()���������ڷ������ڰ���һ������ѭ������ÿ��ѭ���У����ǽ������1��ʼ����������
	//��ÿ�����֣����ǽ��������ǲ���һ������������ǵĻ��ʹ�ӡ������̨��
	@Override
	public void run() {
		long number = 1L;
		while(true){
			//�ж��Ƿ�����
			if(isPrime(number)){
				System.out.println("Number "+number+" is prime");
			}
			//����isInterrupted()����������߳��Ƿ��ж�
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
