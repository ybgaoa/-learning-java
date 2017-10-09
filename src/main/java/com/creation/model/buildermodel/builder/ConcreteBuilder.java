package com.creation.model.buildermodel.builder;

import com.creation.model.buildermodel.model.Product;
/*具体建造者（ConcreteBuilder）角色：担任这个角色的是与应用程序紧密相关的一些类，
 * 它们在应用程序调用下创建产品的实例。这个角色要完成的任务包括：
 * 1.实现抽象建造者Builder所声明的接口，给出一步一步地完成创建产品实例的操作。
 * 2.在建造过程完成后，提供产品的实例。*/
public class ConcreteBuilder implements Builder {
	private Product product = new Product();
	public void buildPart1() {
		// TODO Auto-generated method stub
		product.setPart1("编号：001");
	}

	public void buildPart2() {
		// TODO Auto-generated method stub
		product.setPart2("编号：002");
	}

	public Product retrieveResult() {
		// TODO Auto-generated method stub
		return product;
	}

}
