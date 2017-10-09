package com.creation.model.buildermodel.builder;

import com.creation.model.buildermodel.model.Product;
/*抽象建造者（Builder）角色：给 出一个抽象接口，以规范产品对象的各个组成成分的建造。
 * 一般而言，此接口独立于应用程序的商业逻辑。
 * 模式中直接创建产品对象的是具体建造者 (ConcreteBuilder)角色。
 * 具体建造者类必须实现这个接口所要求的两种方法：一种是建造方法(buildPart1和 buildPart2)，
 * 另一种是返还结构方法(retrieveResult)。*/
public interface  Builder {
	public void buildPart1();
    public void buildPart2();
    public Product retrieveResult();
}
