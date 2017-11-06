package com.behavioral.model.mediatormodel.colleague;

import com.behavioral.model.mediatormodel.mediator.Mediator;
/*����ͬ����(Colleague)��ɫ���������ͣ�ߵ�ͬ�¶���Ľӿڡ�
ͬ�¶���ֻ֪����ͣ�߶���֪�������ͬ�¶���*/
public abstract class Colleague {
	//����һ����ͣ�߶���
    private Mediator mediator;
    /**
     * ���캯��
     */
    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
    /**
     * ��ȡ��ǰͬ�����Ӧ�ĵ�ͣ�߶���
     */
    public Mediator getMediator() {
        return mediator;
    }
}
