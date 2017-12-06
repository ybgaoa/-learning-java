package com.thread.sample.forkjoin01;

import java.util.ArrayList;
import java.util.List;
//创建一个名为ProductListGenerator的类，用来生成一个随机产品列表
public class ProductListGenerator {
	//接收一个表示列表大小的int参数，并返回一个生成产品的List<Product>列表
	public List<Product> generate(int size){
		List<Product> ret = new ArrayList<Product>();
		for(int i=0;i<size;i++){
			Product product = new Product();
			product.setName("product-"+i);
			product.setPrice(10);
			ret.add(product);
		}
		
		return ret;
	}
}
