package com.creation.model.buildermodel;

import com.creation.model.buildermodel.builder.Builder;
import com.creation.model.buildermodel.builder.ConcreteBuilder;
import com.creation.model.buildermodel.director.Director;
import com.creation.model.buildermodel.model.Product;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
	}
}
