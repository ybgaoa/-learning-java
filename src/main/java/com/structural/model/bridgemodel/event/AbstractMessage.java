package com.structural.model.bridgemodel.event;

import com.structural.model.bridgemodel.message.MessageImplementor;
/*抽象化(Abstraction)角色：抽象化给出的定义，并保存一个对实现化对象的引用。*/
public abstract class AbstractMessage {
	//持有一个实现部分的对象
    MessageImplementor impl;
    /**
     * 构造方法，传入实现部分的对象
     * @param impl  实现部分的对象
     */
    public AbstractMessage(MessageImplementor impl){
        this.impl = impl;
    }
    /**
     * 发送消息，委派给实现部分的方法
     * @param message    要发送消息的内容
     * @param toUser    消息的接受者
     */
    public void sendMessage(String message , String toUser){
        this.impl.send(message, toUser);
    }
}
