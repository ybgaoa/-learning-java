package com.thread.sample.forkjoin04;

import java.util.Random;
//����һ����ΪArrayGenerator���ࡣ����ཫ����һ��ָ����С������������顣
public class ArrayGenerator {
	//ʵ��generateArray()���������������������飬����һ��int������ʾ����Ĵ�С
	public int[] generateArray(int size){
		int array[] = new int[size];
		Random random = new Random();
		for(int i=0;i<size;i++){
			array[i] = random.nextInt(10);
		}
		return array;
	}
}
