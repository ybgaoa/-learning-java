package com.creation.model.abstractfactorymodel.cpu;

import java.io.Serializable;
//简单工厂模式-cpu的工厂类
public class CpuFactory implements Serializable {
	 public static Cpu createCpu(int type){
	        Cpu cpu = null;
	        if(type == 1){
	            cpu = new IntelCpu(755);
	        }else if(type == 2){
	            cpu = new AmdCpu(938);
	        }
	        return cpu;
	    }
}
