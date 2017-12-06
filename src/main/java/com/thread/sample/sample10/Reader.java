package com.thread.sample.sample10;
//创建读取类，这个类将读取价格信息PricesInfo类的属性
public class Reader implements Runnable {
	private PricesInfo pricesInfo;
	public Reader(PricesInfo pricesInfo){
		this.pricesInfo = pricesInfo;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+":Price 1:"+pricesInfo.getPrice1());
			System.out.println(Thread.currentThread().getName()+":Price 2:"+pricesInfo.getPrice2());
		}
	}

}
