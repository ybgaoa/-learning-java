package com.creation.model.abstractfactorymodel.cpu;

public class IntelCpu implements Cpu {
	//cpu�������
	private int pins = 0;
	public IntelCpu(int pins){
		this.pins = pins;
	}
	public void calculate() {
		// TODO Auto-generated method stub
		System.out.println("Intel CPU���������" + pins);
	}

}
