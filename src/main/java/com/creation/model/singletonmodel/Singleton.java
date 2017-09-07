package com.creation.model.singletonmodel;

import java.io.Serializable;
//˫�ؼ�����
//��˫�ؼ����������Ƶ�ʵ�ֻ�ʹ�ùؼ���volatile��������˼�ǣ���volatile���εı�����ֵ�������ᱻ�����̻߳��棬���жԸñ����Ķ�д����ֱ�Ӳ��������ڴ棬�Ӷ�ȷ������߳�����ȷ�Ĵ���ñ�����
//����volatile�ؼ��ֿ��ܻ����ε��������һЩ��Ҫ�Ĵ����Ż�����������Ч�ʲ����Ǻܸߡ����һ�㽨�飬û���ر����Ҫ����Ҫʹ�á�Ҳ����˵����Ȼ����ʹ�á�˫�ؼ�������������ʵ���̰߳�ȫ�ĵ���������������������ã����Ը��������ѡ�á�
public class Singleton implements Serializable {
	private volatile static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        //�ȼ��ʵ���Ƿ���ڣ���������ڲŽ��������ͬ����
        if(instance == null){
            //ͬ���飬�̰߳�ȫ�Ĵ���ʵ��
            synchronized (Singleton.class) {
                //�ٴμ��ʵ���Ƿ���ڣ���������ڲ������Ĵ���ʵ��
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
