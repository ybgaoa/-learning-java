package com.creation.model.abstractfactorymodel;

import java.io.Serializable;

import com.creation.model.abstractfactorymodel.cpu.Cpu;
import com.creation.model.abstractfactorymodel.mainboard.Mainboard;
/**
 * 抽象工厂类
 * 创建CPU对象和主板对象
 * @author ybgaoa
 *
 */
public interface AbstractFactory extends Serializable {
	/**
     * 创建CPU对象
     * @return CPU对象
     */
    public Cpu createCpu();
    /**
     * 创建主板对象
     * @return 主板对象
     */
    public Mainboard createMainboard();
}
