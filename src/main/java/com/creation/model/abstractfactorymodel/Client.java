package com.creation.model.abstractfactorymodel;

import com.creation.model.abstractfactorymodel.factory.AbstractFactory;
import com.creation.model.abstractfactorymodel.factory.IntelFactory;

public class Client {

	public static void main(String[] args) {
		//����װ������ʦ����
        ComputerEngineer cf = new ComputerEngineer();
        //�ͻ�ѡ�񲢴�����Ҫʹ�õĲ�Ʒ����
        AbstractFactory af = new IntelFactory();
        //����װ������ʦ�Լ�ѡ��Ĳ�Ʒ����װ������ʦ��װ����
        cf.makeComputer(af);
	}

}
