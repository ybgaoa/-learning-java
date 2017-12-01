package com.thread.sample.ConcurrentCollections05;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
//ʹ���̰߳�ȫ�ɱ���ӳ��
/**
 * ConcurrentSkipListMap��
java api�ṩ��һ�����ڲ���Ӧ�ó����е���Ȥ���ݽṹ����ConcurrentNavigableMap�ӿڼ���ʵ���ࡣʵ������ӿڵ��������������ִ��Ԫ�أ�
1.һ����ֵ(Key)������Ԫ�صı�ʶ������Ψһ�ġ�
2.Ԫ�������������ݡ�
ÿһ����ɲ��ֱ����ڲ�ͬ������ʵ�֡�
java apiҲ�ṩ��һ��ʵ��ConcurrentSkipListMap�ӿڵ��࣬ConcurrentSkipListMap�ӿ�ʵ������ConcurrentNavigableMap�ӿ�����ͬ��Ϊ��һ��������ʽ�б����ڲ�ʵ�ֻ�����������ʹ����һ��Skip List��������ݡ�Skip List�ǻ��ڲ����б�����ݽṹ��Ч��������������
������Ԫ�ص�ӳ����ʱ��ConcurrentSkipListMap�ӿ���ʹ�ü�ֵ����������Ԫ�ء������ṩ����һ������Ԫ�صķ����⣬�����Ҳ�ṩ��ȡ��ӳ��ķ�����

ConcurrentSkipListMap���ṩ�ĳ��÷�����
1.headMap(K toKey)��K����ConcurrentSkipListMap����� ���Ͳ������õ��ļ��������������ӳ�������м�ֵС�ڲ���ֵtoKey����ӳ�䡣
2.tailMap(K fromKey)��K����ConcurrentSkipListMap����� ���Ͳ������õ��ļ��������������ӳ�������м�ֵ���ڲ���ֵfromKey����ӳ�䡣
3.putIfAbsent(K key,V value)�����ӳ���в����ڼ�key����ô�ͽ�key��value���浽ӳ���С�
4.pollLastEntry()�����ز��Ƴ�ӳ���е����һ��Map.Entry����
5.replace(K key,V value)�����ӳ�����Ѿ����ڼ�key�����ò����е�value�滻���е�ֵ��

 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		ConcurrentSkipListMap<String, Contact> map;
		map = new ConcurrentSkipListMap<>();
		Thread threads[] = new Thread[25];
		int counter = 0;
		for(char i='A';i<'Z';i++){
			Task task = new Task(map,String.valueOf(i));
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}
		
		for(int i=0;i<25;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:size of the map:"+map.size());
		Map.Entry<String, Contact> element;
		Contact contact;
		element = map.firstEntry();
		contact = element.getValue();
		System.out.println("main:first entry:"+contact.getName()+":"+contact.getPhone());
		
		element = map.lastEntry();
		contact = element.getValue();
		System.out.println("main:last entry:"+contact.getName()+":"+contact.getPhone());
		
		System.out.println("main:submap from A1996 to B1002:");
		//��ȡConcurrentSkipListMap�Ķ�������м����ڡ�A1996���͡�B1002���Ĳ��ֶ��У�������еĶ���ΪConcurrentNavigableMap��
		ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
		do{
			element = submap.pollFirstEntry();
			if(element!=null){
				contact = element.getValue();
				System.out.println(contact.getName()+":"+contact.getPhone());
			}
		}while(element!=null);
		
	}

}
