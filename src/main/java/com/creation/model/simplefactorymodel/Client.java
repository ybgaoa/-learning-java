package com.creation.model.simplefactorymodel;

import com.creation.model.simplefactorymodel.login.Login;
import com.creation.model.simplefactorymodel.login.LoginManager;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String loginType = "password";
        String name = "name";
        String password = "password";
        Login login = LoginManager.factory(loginType);
        boolean bool = login.verify(name, password);
        if (bool) {
            /**
             * 业务逻辑
             */
        } else {
            /**
             * 业务逻辑
             */
        }
	}

}
