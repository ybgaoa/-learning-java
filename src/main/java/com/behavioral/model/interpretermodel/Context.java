package com.behavioral.model.interpretermodel;

import java.util.HashMap;
import java.util.Map;

import com.behavioral.model.interpretermodel.expression.Variable;
/*环境(Context)角色：这个角色的任务一般是用来存放文法中各个终结符所对应的具体值，
比如R=R1+R2，我们给R1赋值100，给R2赋值200。
这些信息需要存放到环境角色中，很多情况下我们使用Map来充当环境角色就足够了。*/
public class Context {
	private Map<Variable,Boolean> map = new HashMap<Variable,Boolean>();
    
    public void assign(Variable var , boolean value){
        map.put(var, new Boolean(value));
    }
    
    public boolean lookup(Variable var) throws IllegalArgumentException{
        Boolean value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
