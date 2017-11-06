package com.behavioral.model.interpretermodel.expression;

import com.behavioral.model.interpretermodel.Context;
/*�ս�����ʽ(Terminal Expression)��ɫ��ʵ���˳�����ʽ��ɫ��Ҫ��Ľӿڣ���Ҫ��һ��interpret()������
�ķ��е�ÿһ���ս������һ�������ս���ʽ��֮���Ӧ��
������һ���򵥵Ĺ�ʽR=R1+R2��������R1��R2�����ս������Ӧ�Ľ���R1��R2�Ľ����������ս�����ʽ�� */
public class Not extends Expression {
	private Expression exp;
    
    public Not(Expression exp){
        this.exp = exp;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Not)
        {
            return exp.equals(
                    ((Not)obj).exp);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        return !exp.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(Not " + exp.toString() + ")";
    }


}
