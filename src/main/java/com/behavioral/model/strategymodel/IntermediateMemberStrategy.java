package com.behavioral.model.strategymodel;
/*�������(ConcreteStrategy)��ɫ����װ����ص��㷨����Ϊ��*/
public class IntermediateMemberStrategy implements MemberStrategy{
	public double calcPrice(double booksPrice) {
        System.out.println("�����м���Ա���ۿ�Ϊ10%");
        return booksPrice * 0.9;
    }
}
