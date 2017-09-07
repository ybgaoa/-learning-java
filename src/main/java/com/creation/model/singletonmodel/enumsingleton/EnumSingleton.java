package com.creation.model.singletonmodel.enumsingleton;
//ö�ٵ���ģʽ
//ʹ��ö����ʵ�ֵ�ʵ�����ƻ���Ӽ�࣬�����޳����ṩ�����л����ƣ�����JVM�Ӹ������ṩ���ϣ����Է�ֹ���ʵ�������Ǹ���ࡢ��Ч����ȫ��ʵ�ֵ����ķ�ʽ��
public enum EnumSingleton {
	INSTANCE;
	private MySingleton my = null;
	private EnumSingleton(){
		System.out.println("EnumSingleton..........");
		my = new MySingleton();
	}
	
	public MySingleton getInstance(){
		return my;
	}
}
