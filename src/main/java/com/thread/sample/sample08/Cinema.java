package com.thread.sample.sample08;
//����һ����ӰԺ��Cinema
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
	//ʵ��sellTickets1()����������һ����ӰԺ��Ʊ������ʱ�򽫵��������������ʹ��controlCinema1�������ͬ�������ķ���
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
	//ʵ��sellTickets2()����������һ����ӰԺ��Ʊ������ʱ�򽫵��������������ʹ��controlCinema2�������ͬ�������ķ���
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
	//���ص�ӰԺ1��Ʊ��
	public boolean returnTickets1(int number){
		synchronized(controlCinema1){
			vacanciesCinema1 += number;
			return true;
		}
	}
	//���ص�ӰԺ2��Ʊ��
	public boolean returnTickets2(int number){
		synchronized(controlCinema2){
			vacanciesCinema2 += number;
			return true;
		}
	}

}
