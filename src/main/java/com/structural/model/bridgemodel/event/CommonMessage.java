package com.structural.model.bridgemodel.event;

import com.structural.model.bridgemodel.message.MessageImplementor;
/*修正抽象化(RefinedAbstraction)角色：扩展抽象化角色，改变和修正父类对抽象化的定义。*/
public class CommonMessage extends AbstractMessage {
	public CommonMessage(MessageImplementor impl) {
        super(impl);
    }
    @Override
    public void sendMessage(String message, String toUser) {
        // 对于普通消息，直接调用父类方法，发送消息即可
        super.sendMessage(message, toUser);
    }
}
