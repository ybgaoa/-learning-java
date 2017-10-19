package com.structural.model.enjoymentmodel.sample02;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.structural.model.enjoymentmodel.ConcreteFlyweight;
import com.structural.model.enjoymentmodel.Flyweight;
public class FlyweightFactory {
	 private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
	    /**
	     * ������Ԫ��������
	     */
	    public Flyweight factory(List<Character> compositeState){
	        ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
	        
	        for(Character state : compositeState){
	            compositeFly.add(state,this.factory(state));
	        }
	        
	        return compositeFly;
	    }
	    /**
	     * ������Ԫ��������
	     */
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
