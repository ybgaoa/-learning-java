package com.behavioral.model.mediatormodel.mediator;

import com.behavioral.model.mediatormodel.colleague.Colleague;
/*�����ͣ��(Mediator)��ɫ�������ͬ�¶��󵽵�ͣ�߶���Ľӿڣ�������Ҫ������һ�����������¼�������*/
public interface Mediator {
	/**
     * ͬ�¶���������ı��ʱ����֪ͨ��ͣ�߷���
     * �õ�ͣ��ȥ������Ӧ��������ͬ�¶���Ľ���
     */
    public void changed(Colleague c);
}
