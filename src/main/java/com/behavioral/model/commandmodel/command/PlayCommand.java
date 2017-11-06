package com.behavioral.model.commandmodel.command;

import com.behavioral.model.commandmodel.AudioPlayer;
/*��������(ConcreteCommand)��ɫ������һ�������ߺ���Ϊ֮�������ϣ�ʵ��execute()������������ý����ߵ���Ӧ������
execute()����ͨ������ִ�з�����*/
public class PlayCommand implements Command {
	private AudioPlayer myAudio;
    
    public PlayCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    /**
     * ִ�з���
     */
    @Override
    public void execute() {
        myAudio.play();
    }
}
