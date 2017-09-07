package com.creation.model.singletonmodel;

import java.io.Serializable;
//����ʽ������
//����ʽ�ǵ��͵Ŀռ任ʱ�䣬����װ�ص�ʱ��ͻᴴ�����ʵ�����������ò��ã��ȴ���������Ȼ��ÿ�ε��õ�ʱ�򣬾Ͳ���Ҫ���жϣ���ʡ������ʱ�䡣
public class EagerSingleton implements Serializable {
	private static EagerSingleton instance = new EagerSingleton();
    /**
     * ˽��Ĭ�Ϲ�����
     */
    private EagerSingleton(){}
    /**
     * ��̬��������
     */
    public static EagerSingleton getInstance(){
        return instance;
    }
}
