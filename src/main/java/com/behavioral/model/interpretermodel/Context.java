package com.behavioral.model.interpretermodel;

import java.util.HashMap;
import java.util.Map;

import com.behavioral.model.interpretermodel.expression.Variable;

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
