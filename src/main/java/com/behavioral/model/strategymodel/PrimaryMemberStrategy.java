package com.behavioral.model.strategymodel;
/*�������(ConcreteStrategy)��ɫ����װ����ص��㷨����Ϊ��*/
public class PrimaryMemberStrategy implements MemberStrategy{
	public double calcPrice(double booksPrice) {
        System.out.println("���ڳ�����Ա��û���ۿ�");
        return booksPrice;
    }
}
