package com.behavioral.model.templatemethodmodel;
/*����ģ��(Abstract Template)��ɫ���������Σ�
������һ����������������Ա�������ʵ�֡���Щ���������������������������һ�������߼�����ɲ��衣
���岢ʵ����һ��ģ�巽�������ģ�巽��һ����һ�����巽������������һ�������߼��ĹǼܣ����߼�����ɲ�������Ӧ�ĳ�������У��Ƴٵ�����ʵ�֡������߼�Ҳ�п��ܵ���һЩ���巽����*/
public abstract class Account {
	 /**
     * ģ�巽����������Ϣ����
     * @return    ������Ϣ����
     */
    public final double calculateInterest(){
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType);
        return amount * interestRate;
    }
    
    /**
     * ���󷽷���һ�����󷽷��ɳ������������ɾ�������ʵ�֡���Java��������󷽷���abstract�ؼ��ֱ�ʾ��
     * ����������������ʵ��
     */
    protected abstract String doCalculateAccountType();
    /**
     * ���󷽷���һ�����󷽷��ɳ������������ɾ�������ʵ�֡���Java��������󷽷���abstract�ؼ��ֱ�ʾ��
     * ����������������ʵ��
     */
    protected abstract double doCalculateInterestRate();
    /**
     * ���巽����һ�����巽���ɳ�����������ʵ�֣������ಢ��ʵ�ֻ��û���
     * �����������Ѿ�ʵ��
     */
    private double calculateAmount(String accountType){
        /**
         * ʡ����ص�ҵ���߼�
         */
        return 7243.00;
    }
    
    /**
     * ���ӷ�����һ�����ӷ����ɳ�����������ʵ�֣�������������չ��ͨ�������������ʵ����һ����ʵ�֣���Ϊ������Ĭ��ʵ�֡�
     * ��������(�շ���)
     */
    protected void hookMethod(){}
}
