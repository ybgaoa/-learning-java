package com.thread.sample.Customizing01;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
//创建SleepTwoSecondsTask类，实现Callable接口。
public class SleepTwoSecondsTask implements Callable<String> {
	//实现call()方法，使当前线程休眠2秒，然后将当前日期转换为字符串，并返回。
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		return new Date().toString();
	}

}
