package com.thread.sample.Customizing01;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
//����SleepTwoSecondsTask�࣬ʵ��Callable�ӿڡ�
public class SleepTwoSecondsTask implements Callable<String> {
	//ʵ��call()������ʹ��ǰ�߳�����2�룬Ȼ�󽫵�ǰ����ת��Ϊ�ַ����������ء�
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		return new Date().toString();
	}

}
