package com.behavioral.model.commandmodel.command;

import com.behavioral.model.commandmodel.AudioPlayer;
/*具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。
execute()方法通常叫做执行方法。*/
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
