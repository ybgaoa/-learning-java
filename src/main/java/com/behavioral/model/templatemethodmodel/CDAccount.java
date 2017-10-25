package com.behavioral.model.templatemethodmodel;
/*����ģ��(Concrete Template)��ɫ���������Σ�
ʵ�ָ����������һ���������󷽷���������һ�������߼�����ɲ��衣
ÿһ������ģ���ɫ������������������ģ���ɫ��֮��Ӧ����ÿһ������ģ���ɫ�����Ը�����Щ���󷽷���Ҳ���Ƕ����߼�����ɲ��裩�Ĳ�ͬʵ�֣��Ӷ�ʹ�ö����߼���ʵ�ָ�����ͬ��*/
public class CDAccount extends Account{
	@Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }
}
