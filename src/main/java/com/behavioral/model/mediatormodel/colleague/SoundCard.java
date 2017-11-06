package com.behavioral.model.mediatormodel.colleague;

import com.behavioral.model.mediatormodel.mediator.Mediator;
/*����ͬ����(ConcreteColleague)��ɫ�����еľ���ͬ������ӳ���ͬ����̳ж�����
ʵ���Լ���ҵ������Ҫ������ͬ��ͨ�ŵ�ʱ�򣬾�����еĵ�ͣ��ͨ�ţ�
��ͣ�߻Ḻ����������ͬ�½�����*/
public class SoundCard extends Colleague {
	/**
     * ���캯��
     */
    public SoundCard(Mediator mediator) {
        super(mediator);
    }
    /**
     * ������Ƶ���ݷ�������
     */
    public void soundData(String data){
        System.out.println("��������" + data);
    }
}
