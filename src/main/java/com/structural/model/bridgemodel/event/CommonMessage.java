package com.structural.model.bridgemodel.event;

import com.structural.model.bridgemodel.message.MessageImplementor;
/*��������(RefinedAbstraction)��ɫ����չ���󻯽�ɫ���ı����������Գ��󻯵Ķ��塣*/
public class CommonMessage extends AbstractMessage {
	public CommonMessage(MessageImplementor impl) {
        super(impl);
    }
    @Override
    public void sendMessage(String message, String toUser) {
        // ������ͨ��Ϣ��ֱ�ӵ��ø��෽����������Ϣ����
        super.sendMessage(message, toUser);
    }
}
