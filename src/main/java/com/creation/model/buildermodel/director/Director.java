package com.creation.model.buildermodel.director;

import com.creation.model.buildermodel.builder.Builder;

/*�����ߣ�Director����ɫ�����������ɫ������þ��彨���߽�ɫ�Դ�����Ʒ����
 * Ӧ��ָ�����ǣ������߽�ɫ��û�в�Ʒ��ľ���֪ʶ��
 * ����ӵ�в�Ʒ��ľ���֪ʶ���Ǿ��彨���߽�ɫ��*/
public class Director {
	/**
     * ���е�ǰ��Ҫʹ�õĽ���������
     */
    private Builder builder;
    /**
     * ���췽�������뽨��������
     * @param builder ����������
     */
    public Director(Builder builder){
        this.builder = builder;
    }
    /**
     * ��Ʒ���췽����������ø���������췽��
     */
    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }
}
