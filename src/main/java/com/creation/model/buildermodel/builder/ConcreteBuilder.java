package com.creation.model.buildermodel.builder;

import com.creation.model.buildermodel.model.Product;
/*���彨���ߣ�ConcreteBuilder����ɫ�����������ɫ������Ӧ�ó��������ص�һЩ�࣬
 * ������Ӧ�ó�������´�����Ʒ��ʵ���������ɫҪ��ɵ����������
 * 1.ʵ�ֳ�������Builder�������Ľӿڣ�����һ��һ������ɴ�����Ʒʵ���Ĳ�����
 * 2.�ڽ��������ɺ��ṩ��Ʒ��ʵ����*/
public class ConcreteBuilder implements Builder {
	private Product product = new Product();
	public void buildPart1() {
		// TODO Auto-generated method stub
		product.setPart1("��ţ�001");
	}

	public void buildPart2() {
		// TODO Auto-generated method stub
		product.setPart2("��ţ�002");
	}

	public Product retrieveResult() {
		// TODO Auto-generated method stub
		return product;
	}

}
