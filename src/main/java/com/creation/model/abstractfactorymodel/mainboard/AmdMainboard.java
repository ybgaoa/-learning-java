package com.creation.model.abstractfactorymodel.mainboard;

public class AmdMainboard implements Mainboard {
	//CPU��۵Ŀ���
    private int cpuHoles = 0;
    public AmdMainboard(int cpuHoles){
    	this.cpuHoles = cpuHoles;	
    }
	public void installCPU() {
		// TODO Auto-generated method stub
		System.out.println("AMD�����CPU��ۿ����ǣ�" + cpuHoles);
	}

}
