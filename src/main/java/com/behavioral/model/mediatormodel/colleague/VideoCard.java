package com.behavioral.model.mediatormodel.colleague;

import com.behavioral.model.mediatormodel.mediator.Mediator;
/*����ͬ����(ConcreteColleague)��ɫ�����еľ���ͬ������ӳ���ͬ����̳ж�����
ʵ���Լ���ҵ������Ҫ������ͬ��ͨ�ŵ�ʱ�򣬾�����еĵ�ͣ��ͨ�ţ�
��ͣ�߻Ḻ����������ͬ�½�����*/
public class VideoCard extends Colleague {
	/**
     * ���캯��
     */
    public VideoCard(Mediator mediator) {
        super(mediator);
    }
    /**
     * ��ʾ��Ƶ����
     */
    public void showData(String data){
        System.out.println("�����ڹۿ����ǣ�" + data);
    }
}
