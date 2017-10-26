package com.behavioral.model.iterativesubmodel.example02;

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
    
    @Override
    public Iterator createIterator() {

        return new ConcreteIterator();
    }
    /**
     * ���������(ConcreteIterator)��ɫ���˽�ɫʵ����Iterator�ӿڣ������ֵ��������е��α�λ�á�
     * �ڲ���Ա�࣬�����������
     */
    private class ConcreteIterator implements Iterator
    {
        //�ڲ���������¼��ǰ������������λ��
        private int index = 0;
        //��¼��ǰ�ۼ�����Ĵ�С
        private int size = 0;
        /**
         * ���캯��
         */
        public ConcreteIterator(){
            
            this.size = objArray.length;
            index = 0;
        }
        /**
         * ����������������ǰԪ��
         */
        @Override
        public Object currentItem() {
            return objArray[index];
        }
        /**
         * �����������ƶ�����һ��Ԫ��
         */
        @Override
        public void first() {
            
            index = 0;
        }
        /**
         * �����������Ƿ�Ϊ���һ��Ԫ��
         */
        @Override
        public boolean isDone() {
            return (index >= size);
        }
        /**
         * �����������ƶ�����һ��Ԫ��
         */
        @Override
        public void next() {

            if(index < size)
            {
                index ++;
            }
        }
    }
}
