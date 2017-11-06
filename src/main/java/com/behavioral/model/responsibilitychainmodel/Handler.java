package com.behavioral.model.responsibilitychainmodel;
/*��������(Handler)��ɫ�������һ����������Ľӿڡ�
 * �����Ҫ���ӿڿ��Զ��� ��һ���������趨�ͷ��ض��¼ҵ����á�
 * �����ɫͨ����һ��Java���������Java�ӿ�ʵ�֡�*/
public abstract class Handler {
	/**
     * ������һ����������Ķ���
     */
    protected Handler successor = null;
    /**
     * ȡֵ����
     */
    public Handler getSuccessor() {
        return successor;
    }
    /**
     * ������һ����������Ķ���
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    /**
     * ����۲ͷ��õ�����
     * @param user    ������
     * @param fee    �����Ǯ��
     * @return        �ɹ���ʧ�ܵľ���֪ͨ
     */
    public abstract String handleFeeRequest(String user , double fee);
}
