package com.structural.model.enjoymentmodel.sample02;

import java.util.HashMap;
import java.util.Map;

import com.structural.model.enjoymentmodel.Flyweight;
/*������Ԫ(ConcreteCompositeFlyweight)��ɫ ��������Ԫ��ɫ������Ķ����ǲ����Թ���ģ�����һ��������Ԫ������Էֽ��Ϊ��������ǵ�����Ԫ�������ϡ�
������Ԫ��ɫ�ֳ������ɹ������Ԫ����*/
public class ConcreteCompositeFlyweight implements Flyweight{
	private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
    /**
     * ����һ���µĵ�����Ԫ���󵽾ۼ���
     */
    public void add(Character key , Flyweight fly){
        files.put(key,fly);
    }
    /**
     * ����״̬��Ϊ�������뵽������
     */
    public void operation(String state) {
        Flyweight fly = null;
        for(Object o : files.keySet()){
            fly = files.get(o);
            fly.operation(state);
        }
    }
}
