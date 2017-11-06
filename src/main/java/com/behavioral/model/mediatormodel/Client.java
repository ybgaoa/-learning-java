package com.behavioral.model.mediatormodel;

import com.behavioral.model.mediatormodel.colleague.CDDriver;
import com.behavioral.model.mediatormodel.colleague.CPU;
import com.behavioral.model.mediatormodel.colleague.SoundCard;
import com.behavioral.model.mediatormodel.colleague.VideoCard;
import com.behavioral.model.mediatormodel.mediator.MainBoard;

public class Client {
	 public static void main(String[] args) {
	        //������ͣ�ߡ�������
	        MainBoard mediator = new MainBoard();
	        //����ͬ����
	        CDDriver cd = new CDDriver(mediator);
	        CPU cpu = new CPU(mediator);
	        VideoCard vc = new VideoCard(mediator);
	        SoundCard sc = new SoundCard(mediator);
	        //�õ�ͣ��֪������ͬ��
	        mediator.setCdDriver(cd);
	        mediator.setCpu(cpu);
	        mediator.setVideoCard(vc);
	        mediator.setSoundCard(sc);
	        //��ʼ����Ӱ���ѹ��̷��������������ʼ����
	        cd.readCD();
	        
	    }
}
