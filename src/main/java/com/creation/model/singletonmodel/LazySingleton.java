package com.creation.model.singletonmodel;

import java.io.Serializable;
//����ʽ������
//����ʽ�ǵ��͵�ʱ�任�ռ�,����ÿ�λ�ȡʵ����������жϣ����Ƿ���Ҫ����ʵ�����˷��жϵ�ʱ�䡣��Ȼ�����һֱû����ʹ�õĻ����ǾͲ��ᴴ��ʵ�������Լ�ڴ�ռ�
public class LazySingleton implements Serializable {
	private static LazySingleton instance = null;
    /**
     * ˽��Ĭ�Ϲ�����
     */
    private LazySingleton(){}
    /**
     * ��̬��������
     */
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
