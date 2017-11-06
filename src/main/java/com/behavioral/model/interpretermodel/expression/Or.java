package com.behavioral.model.interpretermodel.expression;

import com.behavioral.model.interpretermodel.Context;
/*�ս�����ʽ(Terminal Expression)��ɫ��ʵ���˳�����ʽ��ɫ��Ҫ��Ľӿڣ���Ҫ��һ��interpret()������
�ķ��е�ÿһ���ս������һ�������ս���ʽ��֮���Ӧ��
������һ���򵥵Ĺ�ʽR=R1+R2��������R1��R2�����ս������Ӧ�Ľ���R1��R2�Ľ����������ս�����ʽ�� */
public class Or extends Expression {
	private Expression left,right;

    public Or(Expression left , Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Or)
        {
            return this.left.equals(((Or)obj).left) && this.right.equals(((Or)obj).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        return left.interpret(ctx) || right.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " OR " + right.toString() + ")";
    }
}
