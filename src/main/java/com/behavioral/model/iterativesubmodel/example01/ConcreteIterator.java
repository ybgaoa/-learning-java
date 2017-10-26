package com.behavioral.model.iterativesubmodel.example01;

import com.behavioral.model.iterativesubmodel.Iterator;
/*���������(ConcreteIterator)��ɫ���˽�ɫʵ����Iterator�ӿڣ������ֵ��������е��α�λ�á�*/
public class ConcreteIterator implements Iterator{
	//���б������ľ���ľۺ϶���
    private ConcreteAggregate agg;
    //�ڲ���������¼��ǰ������������λ��
    private int index = 0;
    //��¼��ǰ�ۼ�����Ĵ�С
    private int size = 0;
    
    public ConcreteIterator(ConcreteAggregate agg){
        this.agg = agg;
        this.size = agg.size();
        index = 0;
    }
    /**
     * ����������������ǰԪ��
     */
    public Object currentItem() {
        return agg.getElement(index);
    }
    /**
     * �����������ƶ�����һ��Ԫ��
     */
    public void first() {
        
        index = 0;
    }
    /**
     * �����������Ƿ�Ϊ���һ��Ԫ��
     */
    public boolean isDone() {
        return (index >= size);
    }
    /**
     * �����������ƶ�����һ��Ԫ��
     */
    public void next() {

        if(index < size)
        {
            index ++;
        }
    }
}
