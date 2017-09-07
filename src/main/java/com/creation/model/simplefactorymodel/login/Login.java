package com.creation.model.simplefactorymodel.login;

import java.io.Serializable;

public interface Login extends Serializable{
	//µÇÂ¼ÑéÖ¤
    public boolean verify(String name , String password);
}
