package com.creation.model.abstractfactorymodel.mainboard;

import java.io.Serializable;
//简单工厂模式-主板的工厂类
public class MainboardFactory implements Serializable {
	public static Mainboard createMainboard(int type){
        Mainboard mainboard = null;
        if(type == 1){
            mainboard = new IntelMainboard(755);
        }else if(type == 2){
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
