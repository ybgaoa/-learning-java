package com.creation.model.singletonmodel;

import java.io.Serializable;
//Lazy initialization holder classģʽ
//��getInstance������һ�α����õ�ʱ������һ�ζ�ȡSingletonHolder.instance������SingletonHolder��õ���ʼ�������������װ�ز�����ʼ����ʱ�򣬻��ʼ�����ľ�̬�򣬴Ӷ�����Singleton��ʵ���������Ǿ�̬�������ֻ���������װ�����ʱ���ʼ��һ�Σ��������������֤�����̰߳�ȫ�ԡ�
//���ģʽ���������ڣ�getInstance������û�б�ͬ��������ֻ��ִ��һ����ķ��ʣ�����ӳٳ�ʼ����û�������κη��ʳɱ���
public class SingletonInner implements Serializable {
	private SingletonInner(){}
    /**
     *    �༶���ڲ��࣬Ҳ���Ǿ�̬�ĳ�Աʽ�ڲ��࣬���ڲ����ʵ�����ⲿ���ʵ��
     *    û�а󶨹�ϵ������ֻ�б����õ�ʱ�Ż�װ�أ��Ӷ�ʵ�����ӳټ��ء�
     */
    private static class SingletonHolder{
        /**
         * ��̬��ʼ��������JVM����֤�̰߳�ȫ
         */
        private static SingletonInner instance = new SingletonInner();
    }
    
    public static SingletonInner getInstance(){
        return SingletonHolder.instance;
    }
}
