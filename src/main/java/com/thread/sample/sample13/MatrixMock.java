package com.thread.sample.sample13;

import java.util.Random;
//����һ�������࣬��������һ��1~10��ɵ���������߳̽�����������в���ָ��������
public class MatrixMock {
	private int data[][];
	//����������ÿ�г��ȣ�ҪѰ�ҵ�����
	public MatrixMock(int size,int length,int number){
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		//���������Ϊ����ֵ��ÿ����һ�����֣���������Ҫ���ҵ����ֽ��бȽϡ����һ�£��ͽ�������counter��1
		for(int i=0;i<size;i++){
			for(int j=0;j<length;j++){
				data[i][j] = random.nextInt(10);
				if(data[i][j]==number){
					counter++;
				}
			}
		}
		System.out.println("Mock:there are "+counter+" ocurrences of number in generated data " +number);
	} 
	//��������Ĵ��������int�͵ľ�������ţ���������д�������У��ͷ��������ݣ���������ھͷ���null
	public int[] getRow(int row){
		if((row>=0)&&(row<data.length)){
			return data[row];
		}
		return null;
	}
}
