package com.behavioral.model.strategymodel;
/*�������(ConcreteStrategy)��ɫ����װ����ص��㷨����Ϊ��*/
public class AdvancedMemberStrategy implements MemberStrategy{
	public double calcPrice(double booksPrice) {
        System.out.println("���ڸ߼���Ա���ۿ�Ϊ20%");
        return booksPrice * 0.8;
    }
}
