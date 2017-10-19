package com.structural.model.enjoymentmodel.sample01;

import java.util.HashMap;
import java.util.Map;

import com.structural.model.enjoymentmodel.ConcreteFlyweight;
import com.structural.model.enjoymentmodel.Flyweight;
/*��Ԫ����(FlyweightFactory)��ɫ ������ɫ���𴴽��͹�����Ԫ��ɫ��
����ɫ���뱣֤��Ԫ������Ա�ϵͳ�ʵ��ع���
��һ���ͻ��˶������һ����Ԫ�����ʱ����Ԫ������ɫ����ϵͳ���Ƿ��Ѿ���һ������Ҫ�����Ԫ����
����Ѿ����ˣ���Ԫ������ɫ��Ӧ���ṩ������е���Ԫ�������ϵͳ��û��һ���ʵ�����Ԫ����Ļ���
��Ԫ������ɫ��Ӧ������һ�����ʵ���Ԫ����*/
public class FlyweightFactory {
	private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
    public Flyweight factory(Character state){
        //�ȴӻ����в��Ҷ���
        Flyweight fly = files.get(state);
        if(fly == null){
            //������󲻴����򴴽�һ���µ�Flyweight����
            fly = new ConcreteFlyweight(state);
            //������µ�Flyweight������ӵ�������
            files.put(state, fly);
        }
        return fly;
    }
}
