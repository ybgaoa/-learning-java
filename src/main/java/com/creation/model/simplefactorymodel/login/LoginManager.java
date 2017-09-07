package com.creation.model.simplefactorymodel.login;

import java.io.Serializable;

public class LoginManager implements Serializable {
	public static Login factory(String type){
        if(type.equals("password")){            
            return new PasswordLogin();           
        }else if(type.equals("passcode")){         
            return new DomainLogin();          
        }else{
            /**
             * �����׳�һ���Զ����쳣���ǡ��
             */
            throw new RuntimeException("û���ҵ���¼����");
        }
    }
}
