package com.creation.model.abstractfactorymodel.cpu;

public class IntelCpu implements Cpu {
	//cpu的针脚数
	private int pins = 0;
	public IntelCpu(int pins){
		this.pins = pins;
	}
	public void calculate() {
		// TODO Auto-generated method stub
		System.out.println("Intel CPU的针脚数：" + pins);
	}

}
