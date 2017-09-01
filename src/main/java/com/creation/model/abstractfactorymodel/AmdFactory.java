package com.creation.model.abstractfactorymodel;

import com.creation.model.abstractfactorymodel.cpu.AmdCpu;
import com.creation.model.abstractfactorymodel.cpu.Cpu;
import com.creation.model.abstractfactorymodel.mainboard.AmdMainboard;
import com.creation.model.abstractfactorymodel.mainboard.Mainboard;

public class AmdFactory implements AbstractFactory {

	public Cpu createCpu() {
		// TODO Auto-generated method stub
		return new AmdCpu(938);
	}

	public Mainboard createMainboard() {
		// TODO Auto-generated method stub
		return new AmdMainboard(938);
	}

}
