package com.creation.model.abstractfactorymodel;

import java.io.Serializable;

import com.creation.model.abstractfactorymodel.cpu.Cpu;
import com.creation.model.abstractfactorymodel.cpu.CpuFactory;
import com.creation.model.abstractfactorymodel.mainboard.Mainboard;
import com.creation.model.abstractfactorymodel.mainboard.MainboardFactory;
//cpu��������װ
public class ComputerEngineer implements Serializable {
	//������װ����Ҫ��CPU
	private Cpu cpu = null;
	//������װ����Ҫ������
	private Mainboard mainboard = null;
	public void makeComputer(AbstractFactory af){
        /**
         * ��װ�����Ļ�������
         */
        //1:����׼����װ������Ҫ�����
        prepareHardwares(af);
        //2:��װ����
        //3:���Ի���
        //4�������ͻ�
    }
	
    private void prepareHardwares(AbstractFactory af){
        //����Ҫȥ׼��CPU������ľ���ʵ�֣�Ϊ��ʾ���򵥣�����ֻ׼��������
        //���ǣ�װ������ʦ����֪�����ȥ��������ô���أ�
        
        //ֱ������Ӧ�Ĺ�����ȡ
    	this.cpu = af.createCpu();
        this.mainboard = af.createMainboard();
        
        //��������Ƿ����
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
