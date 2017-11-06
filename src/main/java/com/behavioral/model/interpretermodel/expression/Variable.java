package com.behavioral.model.interpretermodel.expression;

import com.behavioral.model.interpretermodel.Context;
/*���ս�����ʽ(Nonterminal Expression)��ɫ���ķ��е�ÿһ��������Ҫһ������ķ��ս�����ʽ�����ս�����ʽһ�����ķ��е���������������ؼ��֣�
���繫ʽR=R1+R2�У���+"���Ƿ��ս����������+���Ľ���������һ�����ս�����ʽ��
*/
public class Variable extends Expression {
	private String name;

    public Variable(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        
        if(obj != null && obj instanceof Variable)
        {
            return this.name.equals(
                    ((Variable)obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean interpret(Context ctx) {
        return ctx.lookup(this);
    }
}
