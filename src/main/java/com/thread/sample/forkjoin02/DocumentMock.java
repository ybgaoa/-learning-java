package com.thread.sample.forkjoin02;

import java.util.Random;
//����һ����ΪDocumentMock���ࡣ��������һ���ַ���������ģ��һ���ĵ�
public class DocumentMock {
	//��һЩ��������һ���ַ������顣������齫�����������ַ�������
	private String words[] = {"the","hello","goodby","school","pencil","java","thread","radom","main","class","package","pool","bag"};
	//ʵ��generateDocument()������������3���������ֱ�������numLines��ÿһ�дʵĸ���numWords��׼�����ҵĴ�word��Ȼ�󷵻�һ���ַ�������
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
