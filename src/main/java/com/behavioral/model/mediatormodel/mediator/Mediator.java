package com.behavioral.model.mediatormodel.mediator;

import com.behavioral.model.mediatormodel.colleague.Colleague;
/*抽象调停者(Mediator)角色：定义出同事对象到调停者对象的接口，其中主要方法是一个（或多个）事件方法。*/
public interface Mediator {
	/**
     * 同事对象在自身改变的时候来通知调停者方法
     * 让调停者去负责相应的与其他同事对象的交互
     */
    public void changed(Colleague c);
}
