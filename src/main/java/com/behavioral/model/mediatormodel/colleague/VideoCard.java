package com.behavioral.model.mediatormodel.colleague;

import com.behavioral.model.mediatormodel.mediator.Mediator;
/*具体同事类(ConcreteColleague)角色：所有的具体同事类均从抽象同事类继承而来。
实现自己的业务，在需要与其他同事通信的时候，就与持有的调停者通信，
调停者会负责与其他的同事交互。*/
public class VideoCard extends Colleague {
	/**
     * 构造函数
     */
    public VideoCard(Mediator mediator) {
        super(mediator);
    }
    /**
     * 显示视频数据
     */
    public void showData(String data){
        System.out.println("您正在观看的是：" + data);
    }
}
