package com.creation.model.abstractfactorymodel.mainboard;

public class IntelMainboard implements Mainboard {
	//CPU��۵Ŀ���
    private int cpuHoles = 0;
    public IntelMainboard(int cpuHoles){
    	this.cpuHoles = cpuHoles;	
    }
	public void installCPU() {
		// TODO Auto-generated method stub
		System.out.println("Intel�����CPU��ۿ����ǣ�" + cpuHoles);
	}

}
