package com.thread.sample.sample10;
//创建写入类，这个类将修改价格信息PricesInfo类的属性值
public class Writer implements Runnable {
	private PricesInfo pricesInfo;
	public Writer(PricesInfo pricesInfo){
		this.pricesInfo = pricesInfo;
	}
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("writer:Attempt to modify the prices");
			pricesInfo.setPrices(Math.random()*10, Math.random()*8);
			System.out.println("writer:Prices have bean modified");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
