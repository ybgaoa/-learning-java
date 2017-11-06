package com.behavioral.model.interpretermodel;

import com.behavioral.model.interpretermodel.expression.And;
import com.behavioral.model.interpretermodel.expression.Constant;
import com.behavioral.model.interpretermodel.expression.Expression;
import com.behavioral.model.interpretermodel.expression.Not;
import com.behavioral.model.interpretermodel.expression.Or;
import com.behavioral.model.interpretermodel.expression.Variable;

public class Client {
	public static void main(String[] args) {
        Context ctx = new Context();
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Constant c = new Constant(true);
        ctx.assign(x, false);
        ctx.assign(y, true);
        
        Expression exp = new Or(new And(c,x) , new And(y,new Not(x)));
        System.out.println("x=" + x.interpret(ctx));
        System.out.println("y=" + y.interpret(ctx));
        System.out.println(exp.toString() + "=" + exp.interpret(ctx));
	}
}
