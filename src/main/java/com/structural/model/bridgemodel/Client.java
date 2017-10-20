package com.structural.model.bridgemodel;

import com.structural.model.bridgemodel.event.AbstractMessage;
import com.structural.model.bridgemodel.event.CommonMessage;
import com.structural.model.bridgemodel.event.UrgencyMessage;
import com.structural.model.bridgemodel.message.MessageEmail;
import com.structural.model.bridgemodel.message.MessageImplementor;
import com.structural.model.bridgemodel.message.MessageSMS;

public class Client {
	public static void main(String[] args) {
        //���������ʵ�ֶ���
        MessageImplementor impl = new MessageSMS();
        //������ͨ��Ϣ����
        AbstractMessage message = new  CommonMessage(impl);
        message.sendMessage("�Ӱ���������","����");
        
        //��ʵ�ַ�ʽ�л����ʼ����ٴη���
        impl = new MessageEmail();
        //�����Ӽ���Ϣ����
        message = new UrgencyMessage(impl);
        message.sendMessage("�Ӱ���������","����");
    }
}
