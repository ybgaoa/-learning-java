package com.behavioral.model.templatemethodmodel;
/*����ģ��(Concrete Template)��ɫ���������Σ�
ʵ�ָ����������һ���������󷽷���������һ�������߼�����ɲ��衣
ÿһ������ģ���ɫ������������������ģ���ɫ��֮��Ӧ����ÿһ������ģ���ɫ�����Ը�����Щ���󷽷���Ҳ���Ƕ����߼�����ɲ��裩�Ĳ�ͬʵ�֣��Ӷ�ʹ�ö����߼���ʵ�ָ�����ͬ��*/
public class MoneyMarketAccount extends Account{
	@Override
    protected String doCalculateAccountType() {
        
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        
        return 0.045;
    }
}
