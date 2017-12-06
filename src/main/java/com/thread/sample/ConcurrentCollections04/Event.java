package com.thread.sample.ConcurrentCollections04;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
//创建Event类，实现Delayed接口
public class Event implements Delayed {
	private Date startDate;
	public Event(Date startDate){
		this.startDate = startDate;
	}
	//实现compareTo()方法。它接收一个Delayed对象作为参数，并比较两者延迟值的大小
	@Override
	public int compareTo(Delayed o) {
		long result = this.getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS);
		if(result<0){
			return -1;
		}else if(result>0){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public long getDelay(TimeUnit unit) {
		Date now = new Date();
		long diff = startDate.getTime()-now.getTime();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

}
