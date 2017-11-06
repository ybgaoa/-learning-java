package com.behavioral.model.commandmodel;

import com.behavioral.model.commandmodel.command.Command;
import com.behavioral.model.commandmodel.command.PlayCommand;
import com.behavioral.model.commandmodel.command.RewindCommand;
import com.behavioral.model.commandmodel.command.StopCommand;
/*�ͻ���(Client)��ɫ������һ����������(ConcreteCommand)����ȷ��������ߡ�*/
public class Julia {
	public static void main(String[]args){
        //���������߶���
        AudioPlayer audioPlayer = new AudioPlayer();
        //�����������
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
//        //���������߶���
//        Keypad keypad = new Keypad();
//        keypad.setPlayCommand(playCommand);
//        keypad.setRewindCommand(rewindCommand);
//        keypad.setStopCommand(stopCommand);
//        //����
//        keypad.play();
//        keypad.rewind();
//        keypad.stop();
//        keypad.play();
//        keypad.stop();
        Keypad keypad_playCommand = new Keypad(playCommand);
        keypad_playCommand.exec();
        
        Keypad keypad_rewindCommand = new Keypad(rewindCommand);
        keypad_rewindCommand.exec();
        
        Keypad keypad_stopCommand = new Keypad(stopCommand);
        keypad_stopCommand.exec();
    }
}
