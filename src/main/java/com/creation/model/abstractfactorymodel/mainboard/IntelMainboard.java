package com.creation.model.abstractfactorymodel.mainboard;

public class IntelMainboard implements Mainboard {
	//CPU插槽的孔数
    private int cpuHoles = 0;
    public IntelMainboard(int cpuHoles){
    	this.cpuHoles = cpuHoles;	
    }
	public void installCPU() {
		// TODO Auto-generated method stub
		System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
	}

}
