package com.behavioral.model.commandmodel;

import com.behavioral.model.commandmodel.command.Command;
import com.behavioral.model.commandmodel.command.PlayCommand;
import com.behavioral.model.commandmodel.command.RewindCommand;
import com.behavioral.model.commandmodel.command.StopCommand;
/*客户端(Client)角色：创建一个具体命令(ConcreteCommand)对象并确定其接收者。*/
public class Julia {
	public static void main(String[]args){
        //创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        //创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
//        //创建请求者对象
//        Keypad keypad = new Keypad();
//        keypad.setPlayCommand(playCommand);
//        keypad.setRewindCommand(rewindCommand);
//        keypad.setStopCommand(stopCommand);
//        //测试
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
