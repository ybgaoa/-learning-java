package com.behavioral.model.interpretermodel;

import java.util.HashMap;
import java.util.Map;

import com.behavioral.model.interpretermodel.expression.Variable;
/*����(Context)��ɫ�������ɫ������һ������������ķ��и����ս������Ӧ�ľ���ֵ��
����R=R1+R2�����Ǹ�R1��ֵ100����R2��ֵ200��
��Щ��Ϣ��Ҫ��ŵ�������ɫ�У��ܶ����������ʹ��Map���䵱������ɫ���㹻�ˡ�*/
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
