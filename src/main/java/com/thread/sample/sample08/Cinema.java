package com.thread.sample.sample08;
//创建一个电影院类Cinema
public class Cinema {
	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}

	private long vacanciesCinema1;
	private long vacanciesCinema2;
	private final Object controlCinema1, controlCinema2;
	
	public Cinema(){
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}
	//实现sellTickets1()方法，当第一个电影院有票卖出的时候将调用这个方法。它使用controlCinema1对象控制同步代码块的访问
	public boolean sellTickets1(int number){
		synchronized(controlCinema1){
			if(number<vacanciesCinema1){
				vacanciesCinema1 -= number;
				return true;
			}else{
				return false;
			}
		}
	}
	//实现sellTickets2()方法，当第一个电影院有票卖出的时候将调用这个方法。它使用controlCinema2对象控制同步代码块的访问
	public boolean sellTickets2(int number){
		synchronized(controlCinema2){
			if(number<vacanciesCinema2){
				vacanciesCinema2 -= number;
				return true;
			}else{
				return false;
			}
		}
	}
	//返回电影院1的票数
	public boolean returnTickets1(int number){
		synchronized(controlCinema1){
			vacanciesCinema1 += number;
			return true;
		}
	}
	//返回电影院2的票数
	public boolean returnTickets2(int number){
		synchronized(controlCinema2){
			vacanciesCinema2 += number;
			return true;
		}
	}

}
