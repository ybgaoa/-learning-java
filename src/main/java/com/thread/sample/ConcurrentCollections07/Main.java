package com.thread.sample.ConcurrentCollections07;
/**
 * AtomicLong��
ԭ�ӱ���(Atomic Variable)�Ǵ�java5��ʼ����ģ����ṩ�˵��������ϵ�ԭ�Ӳ������ڱ������ʱ��java�����е�ÿ��������ÿ������������ת���ɻ�����������ָ�
���磬����һ��������ֵʱ����java������ֻʹ��һ��ָ����Ǳ����������ʱ��ָ�ת����JVM�����еĲ�ָͬ�������̹߳���ͬһ������ʱ���ͻᷢ�����ݲ�һ�µĴ���
Ϊ�˱����������java������ԭ�ӱ�������һ���߳��ڶ�ԭ�ӱ�������ʱ����������߳�Ҳ��ͼ��ͬһԭ�ӱ���ִ�в�����ԭ�ӱ�����ʵ�����ṩ��һ�׻������������Ƿ���һ������ɡ�һ����˵����������Ȼ�ȡ����ֵ��Ȼ���ڱ��ظı������ֵ��Ȼ����ͼ������ı��ֵȥ�滻֮ǰ��ֵ�����֮ǰ��ֵû�б������̸߳ı䣬�Ϳ���ִ������滻���������򣬷������ٴ�ִ��������������ֲ�����ΪCASԭ�Ӳ�����
ԭ�ӱ�����ʹ����������ͬ����������������ֵ�Ĳ������ʡ����в������ǻ���CASԭ�Ӳ����ġ�����֤�˶��߳���ͬһʱ�����һ��ԭ�ӱ���������������ݲ�һ�µĴ��󣬲���������������ʹ��ͬ�����Ʊ�������ͨ������
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		//��ʼ���˻����Ϊ1000
		Account account = new Account();
		account.setBalance(1000);
		//��˾ʵ���˻���Ǯ
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		//����ʵ���˻�ȡǮ
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		//�˻���ʼʱ��Ľ��
		System.out.println("Account:Initial Balance:"+account.getBalance());
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			//�˻����յĽ��
			System.out.println("Account:Final Balance:"+account.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
