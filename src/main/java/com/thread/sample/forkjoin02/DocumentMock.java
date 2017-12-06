package com.thread.sample.forkjoin02;

import java.util.Random;
//创建一个名为DocumentMock的类。它将生成一个字符串矩阵来模拟一个文档
public class DocumentMock {
	//用一些词来创建一个字符串数组。这个数组将被用来生成字符串矩阵
	private String words[] = {"the","hello","goodby","school","pencil","java","thread","radom","main","class","package","pool","bag"};
	//实现generateDocument()方法。它接收3个参数，分别是行数numLines，每一行词的个数numWords和准备查找的词word。然后返回一个字符串矩阵
	public String[][] generateDocument(int numLines,int numWords,String word){
		int counter = 0;
		String document[][] = new String[numLines][numWords];
		Random random = new Random();
		for(int i=0;i<numLines;i++){
			for(int j=0;j<numWords;j++){
				int index = random.nextInt(words.length);
				document[i][j] = words[index];
				if(document[i][j].equals(word)){
					counter++;
				}
			}
		}
		System.out.println("documentMock:the word appears "+counter+" times in the document");
		return document;
	}
}
