package com.thread.sample.sample07;
/**
 * ͬ������
����synchronized�ؼ������εķ�����
����java��ÿ��������һ�������������ô˹ؼ������η���ʱ���������ᱣ�������������ڵ��ø÷���ǰ����Ҫ���������������ʹ�������״̬��
�����磺
public synchronized void save(){}
����ʵ����ͬ��������ʹ��this����ǰʵ������
���ھ�̬��ͬ��������ʹ�õ�ǰ����ֽ������
ע�� synchronized�ؼ���Ҳ�������ξ�̬��������ʱ������øþ�̬������������ס�����ࡣ

 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		System.out.println("Account:initial Balance:"+account.getBalance());
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			System.out.println("Account:Final Balance:"+account.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
