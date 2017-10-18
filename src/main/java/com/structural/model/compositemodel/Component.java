package com.structural.model.compositemodel;

import java.util.List;
/*抽象构件(Component)角色：这是一个抽象角色，它给参加组合的对象定义出公共的接口及其默认行为，
 * 可以用来管理所有的子对象。合成对象通常把它所包含的子对象当做类型为Component的对象。
在安全式的合成模式里，构件角色并不定义出管理子对象的方法，这一定义由树枝构件对象给出。*/
public abstract class Component {
	/**
     * 输出组建自身的名称
     */
    public abstract void printStruct(String preStr);
    
    /**
     * 聚集管理方法，增加一个子构件对象
     * @param child 子构件对象
     */
    public void addChild(Component child){
        /**
         * 缺省实现，抛出异常，因为叶子对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
    /**
     * 聚集管理方法，删除一个子构件对象
     * @param index 子构件对象的下标
     */
    public void removeChild(int index){
        /**
         * 缺省实现，抛出异常，因为叶子对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
    /**
     * 聚集管理方法，返回所有子构件对象
     */
    public List<Component> getChild(){
        /**
         * 缺省实现，抛出异常，因为叶子对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
}
