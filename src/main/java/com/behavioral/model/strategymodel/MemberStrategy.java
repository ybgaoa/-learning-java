package com.behavioral.model.strategymodel;
/*�������(Strategy)��ɫ������һ�������ɫ��ͨ����һ���ӿڻ������ʵ�֡�
�˽�ɫ�������еľ������������Ľӿڡ�*/
public interface MemberStrategy {
	 /**
     * ����ͼ��ļ۸�
     * @param booksPrice    ͼ���ԭ��
     * @return    ��������ۺ�ļ۸�
     */
    public double calcPrice(double booksPrice);
}
