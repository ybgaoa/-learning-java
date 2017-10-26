package com.behavioral.model.iterativesubmodel.example01;

import com.behavioral.model.iterativesubmodel.Iterator;
/*具体迭代子(ConcreteIterator)角色：此角色实现了Iterator接口，并保持迭代过程中的游标位置。*/
public class ConcreteIterator implements Iterator{
	//持有被迭代的具体的聚合对象
    private ConcreteAggregate agg;
    //内部索引，记录当前迭代到的索引位置
    private int index = 0;
    //记录当前聚集对象的大小
    private int size = 0;
    
    public ConcreteIterator(ConcreteAggregate agg){
        this.agg = agg;
        this.size = agg.size();
        index = 0;
    }
    /**
     * 迭代方法：返还当前元素
     */
    public Object currentItem() {
        return agg.getElement(index);
    }
    /**
     * 迭代方法：移动到第一个元素
     */
    public void first() {
        
        index = 0;
    }
    /**
     * 迭代方法：是否为最后一个元素
     */
    public boolean isDone() {
        return (index >= size);
    }
    /**
     * 迭代方法：移动到下一个元素
     */
    public void next() {

        if(index < size)
        {
            index ++;
        }
    }
}
