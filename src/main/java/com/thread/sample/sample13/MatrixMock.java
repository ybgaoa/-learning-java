package com.thread.sample.sample13;

import java.util.Random;
//创建一个矩阵类，用来生成一个1~10组成的随机矩阵，线程将从这个矩阵中查找指定的数字
public class MatrixMock {
	private int data[][];
	//矩阵行数，每行长度，要寻找的数字
	public MatrixMock(int size,int length,int number){
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		//用随机数字为矩阵赋值。每生成一个数字，就用它跟要查找的数字进行比较。如果一致，就将计数器counter加1
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
	//这个方法的传入参数是int型的矩阵行序号，如果矩阵中存在这个行，就返回行数据，如果不存在就返回null
	public int[] getRow(int row){
		if((row>=0)&&(row<data.length)){
			return data[row];
		}
		return null;
	}
}
