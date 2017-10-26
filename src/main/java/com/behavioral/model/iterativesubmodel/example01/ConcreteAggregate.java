package com.behavioral.model.iterativesubmodel.example01;

import com.behavioral.model.iterativesubmodel.Aggregate;
import com.behavioral.model.iterativesubmodel.Iterator;
/*����ۼ�(ConcreteAggregate)��ɫ��ʵ���˴���������(Iterator)����Ľӿڣ�����һ�����ʵľ��������ʵ����*/
public class ConcreteAggregate extends Aggregate{
	private Object[] objArray = null;
    /**
     * ���췽��������ۺ϶���ľ�������
     */
    public ConcreteAggregate(Object[] objArray){
        this.objArray = objArray;
    }
    
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
    /**
     * ȡֵ������������ṩ�ۼ�Ԫ��
     */
    public Object getElement(int index){
        
        if(index < objArray.length){
            return objArray[index];
        }else{
            return null;
        }
    }
    /**
     * ȡֵ������������ṩ�ۼ��Ĵ�С
     */
    public int size(){
        return objArray.length;
    }
}
