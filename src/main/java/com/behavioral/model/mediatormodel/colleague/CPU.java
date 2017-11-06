package com.behavioral.model.mediatormodel.colleague;

import com.behavioral.model.mediatormodel.mediator.Mediator;
/*����ͬ����(ConcreteColleague)��ɫ�����еľ���ͬ������ӳ���ͬ����̳ж�����
ʵ���Լ���ҵ������Ҫ������ͬ��ͨ�ŵ�ʱ�򣬾�����еĵ�ͣ��ͨ�ţ�
��ͣ�߻Ḻ����������ͬ�½�����*/
public class CPU extends Colleague {
	//�ֽ��������Ƶ����
    private String videoData = "";
    //�ֽ��������������
    private String soundData = "";
    /**
     * ���캯��
     */
    public CPU(Mediator mediator) {
        super(mediator);
    }
    /**
     * ��ȡ�ֽ��������Ƶ����
     */
    public String getVideoData() {
        return videoData;
    }
    /**
     * ��ȡ�ֽ��������������
     */
    public String getSoundData() {
        return soundData;
    }
    /**
     * �������ݣ������ݷֳ���Ƶ����Ƶ������
     */
    public void executeData(String data){
        //�����ݷֽ⿪��ǰ������Ƶ���ݣ���������Ƶ����
        String[] array = data.split(",");
        this.videoData = array[0];
        this.soundData = array[1];
        //֪ͨ���壬CPU��ɹ���
        getMediator().changed(this);
    }
}
