package com.behavioral.model.commandmodel.command;

import com.behavioral.model.commandmodel.AudioPlayer;
/*��������(ConcreteCommand)��ɫ������һ�������ߺ���Ϊ֮�������ϣ�ʵ��execute()������������ý����ߵ���Ӧ������
execute()����ͨ������ִ�з�����*/
public class RewindCommand implements Command {
	private AudioPlayer myAudio;
    
    public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.rewind();
    }

}
