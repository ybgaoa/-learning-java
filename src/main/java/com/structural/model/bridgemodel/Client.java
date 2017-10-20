package com.structural.model.bridgemodel;

import com.structural.model.bridgemodel.event.AbstractMessage;
import com.structural.model.bridgemodel.event.CommonMessage;
import com.structural.model.bridgemodel.event.UrgencyMessage;
import com.structural.model.bridgemodel.message.MessageEmail;
import com.structural.model.bridgemodel.message.MessageImplementor;
import com.structural.model.bridgemodel.message.MessageSMS;

public class Client {
	public static void main(String[] args) {
        //创建具体的实现对象
        MessageImplementor impl = new MessageSMS();
        //创建普通消息对象
        AbstractMessage message = new  CommonMessage(impl);
        message.sendMessage("加班申请速批","李总");
        
        //将实现方式切换成邮件，再次发送
        impl = new MessageEmail();
        //创建加急消息对象
        message = new UrgencyMessage(impl);
        message.sendMessage("加班申请速批","李总");
    }
}
