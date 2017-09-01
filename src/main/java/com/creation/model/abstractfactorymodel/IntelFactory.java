package com.creation.model.abstractfactorymodel;

import com.creation.model.abstractfactorymodel.cpu.Cpu;
import com.creation.model.abstractfactorymodel.cpu.IntelCpu;
import com.creation.model.abstractfactorymodel.mainboard.IntelMainboard;
import com.creation.model.abstractfactorymodel.mainboard.Mainboard;

public class IntelFactory implements AbstractFactory {

	public Cpu createCpu() {
		// TODO Auto-generated method stub
		return new IntelCpu(755);
	}

	public Mainboard createMainboard() {
		// TODO Auto-generated method stub
		return new IntelMainboard(755);
	}

}
