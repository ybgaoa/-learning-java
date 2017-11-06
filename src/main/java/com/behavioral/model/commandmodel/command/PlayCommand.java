package com.behavioral.model.commandmodel.command;

import com.behavioral.model.commandmodel.AudioPlayer;
/*具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。
execute()方法通常叫做执行方法。*/
public class PlayCommand implements Command {
	private AudioPlayer myAudio;
    
    public PlayCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    /**
     * 执行方法
     */
    @Override
    public void execute() {
        myAudio.play();
    }
}
