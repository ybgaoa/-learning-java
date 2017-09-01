package com.creation.model.abstractfactorymodel;

import java.io.Serializable;

import com.creation.model.abstractfactorymodel.cpu.Cpu;
import com.creation.model.abstractfactorymodel.mainboard.Mainboard;
/**
 * ���󹤳���
 * ����CPU������������
 * @author ybgaoa
 *
 */
public interface AbstractFactory extends Serializable {
	/**
     * ����CPU����
     * @return CPU����
     */
    public Cpu createCpu();
    /**
     * �����������
     * @return �������
     */
    public Mainboard createMainboard();
}
