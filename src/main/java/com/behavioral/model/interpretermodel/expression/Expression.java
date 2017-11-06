package com.behavioral.model.interpretermodel.expression;

import com.behavioral.model.interpretermodel.Context;
/*抽象表达式(Expression)角色：声明一个所有的具体表达式角色都需要实现的抽象接口。
这个接口主要是一个interpret()方法，称做解释操作。*/
public abstract class Expression {
	/**
     * 以环境为准，本方法解释给定的任何一个表达式
     */
    public abstract boolean interpret(Context ctx);
    /**
     * 检验两个表达式在结构上是否相同
     */
    public abstract boolean equals(Object obj);
    /**
     * 返回表达式的hash code
     */
    public abstract int hashCode();
    /**
     * 将表达式转换成字符串
     */
    public abstract String toString();
}
