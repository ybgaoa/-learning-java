package com.creation.model.abstractfactorymodel.cpu;

public class AmdCpu implements Cpu {
	//cpu�������
	private int pins = 0;
	public AmdCpu(int pins){
		this.pins = pins;
	}
	public void calculate() {
		// TODO Auto-generated method stub
		System.out.println("AMD CPU���������" + pins);
	}

}
