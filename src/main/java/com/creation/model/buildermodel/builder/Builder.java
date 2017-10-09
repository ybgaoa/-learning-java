package com.creation.model.buildermodel.builder;

import com.creation.model.buildermodel.model.Product;
/*�������ߣ�Builder����ɫ���� ��һ������ӿڣ��Թ淶��Ʒ����ĸ�����ɳɷֵĽ��졣
 * һ����ԣ��˽ӿڶ�����Ӧ�ó������ҵ�߼���
 * ģʽ��ֱ�Ӵ�����Ʒ������Ǿ��彨���� (ConcreteBuilder)��ɫ��
 * ���彨���������ʵ������ӿ���Ҫ������ַ�����һ���ǽ��췽��(buildPart1�� buildPart2)��
 * ��һ���Ƿ����ṹ����(retrieveResult)��*/
public interface  Builder {
	public void buildPart1();
    public void buildPart2();
    public Product retrieveResult();
}
