package com.behavioral.model.mediatormodel.mediator;

import com.behavioral.model.mediatormodel.colleague.CDDriver;
import com.behavioral.model.mediatormodel.colleague.CPU;
import com.behavioral.model.mediatormodel.colleague.Colleague;
import com.behavioral.model.mediatormodel.colleague.SoundCard;
import com.behavioral.model.mediatormodel.colleague.VideoCard;
/*�����ͣ��(ConcreteMediator)��ɫ��ʵ���˳����ͣ�����������¼�������
�����ͣ��֪�����еľ���ͬ���࣬����������Э����ͬ�¶���Ľ�����ϵ��*/
public class MainBoard implements Mediator {
	//��Ҫ֪��Ҫ������ͬ���ࡪ��������
    private CDDriver cdDriver = null;
    //��Ҫ֪��Ҫ������ͬ���ࡪ��CPU��
    private CPU cpu = null;
    //��Ҫ֪��Ҫ������ͬ���ࡪ���Կ���
    private VideoCard videoCard = null;
    //��Ҫ֪��Ҫ������ͬ���ࡪ��������
    private SoundCard soundCard = null;
    
    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    @Override
    public void changed(Colleague c) {
    	System.out.println("..............");
        if(c instanceof CDDriver){
            //��ʾ������ȡ������
            this.opeCDDriverReadData((CDDriver)c);
        }else if(c instanceof CPU){
            this.opeCPU((CPU)c);
        }
    }
    /**
     * ���������ȡ�����Ժ�����������Ľ���
     */
    private void opeCDDriverReadData(CDDriver cd){
        //�Ȼ�ȡ������ȡ������
        String data = cd.getData();
        //����Щ���ݴ��ݸ�CPU���д���
        cpu.executeData(data);
    }
    /**
     * ����CPU���������ݺ�����������Ľ���
     */
    private void opeCPU(CPU cpu){
        //�Ȼ�ȡCPU����������
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();
        //����Щ���ݴ��ݸ��Կ�������չʾ����
        videoCard.showData(videoData);
        soundCard.soundData(soundData);
    }
}
