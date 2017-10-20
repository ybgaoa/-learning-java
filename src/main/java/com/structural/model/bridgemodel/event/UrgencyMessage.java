package com.structural.model.bridgemodel.event;

import com.structural.model.bridgemodel.message.MessageImplementor;
/*��������(RefinedAbstraction)��ɫ����չ���󻯽�ɫ���ı����������Գ��󻯵Ķ��塣*/
public class UrgencyMessage extends AbstractMessage {
	public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }
    @Override
    public void sendMessage(String message, String toUser) {
        message = "�Ӽ���" + message;
        super.sendMessage(message, toUser);
    }
    /**
     * ��չ�Լ����¹��ܣ����ĳ��Ϣ�Ĵ���״̬
     * @param messageId    ����ص���Ϣ���
     * @return    ��ص�����Ϣ�Ĵ���״̬
     */
    public Object watch(String messageId) {
        // ������Ϣid��ȡ��Ϣ��״̬����֯�ɼ�ص����ݶ���Ȼ�󷵻�
        return null;
    }
}
