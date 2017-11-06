package com.behavioral.model.interpretermodel.expression;

import com.behavioral.model.interpretermodel.Context;
/*�ս�����ʽ(Terminal Expression)��ɫ��ʵ���˳�����ʽ��ɫ��Ҫ��Ľӿڣ���Ҫ��һ��interpret()������
�ķ��е�ÿһ���ս������һ�������ս���ʽ��֮���Ӧ��
������һ���򵥵Ĺ�ʽR=R1+R2��������R1��R2�����ս������Ӧ�Ľ���R1��R2�Ľ����������ս�����ʽ�� */
public class Constant extends Expression {
	private boolean value;

    public Constant(boolean value){
        this.value = value;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(obj != null && obj instanceof Constant){
            return this.value == ((Constant)obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        
        return value;
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }

}
