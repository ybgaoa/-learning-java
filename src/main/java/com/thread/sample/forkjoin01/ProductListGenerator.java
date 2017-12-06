package com.thread.sample.forkjoin01;

import java.util.ArrayList;
import java.util.List;
//����һ����ΪProductListGenerator���࣬��������һ�������Ʒ�б�
public class ProductListGenerator {
	//����һ����ʾ�б��С��int������������һ�����ɲ�Ʒ��List<Product>�б�
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
