package com.behavioral.model.commandmodel;

import com.behavioral.model.commandmodel.command.Command;
/*请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。*/
public class Keypad {
	private Command command;
	public Keypad(Command command){
		this.command = command;
	}
//	private Command playCommand;
//    private Command rewindCommand;
//    private Command stopCommand;
//    
//    public void setPlayCommand(Command playCommand) {
//        this.playCommand = playCommand;
//    }
//    public void setRewindCommand(Command rewindCommand) {
//        this.rewindCommand = rewindCommand;
//    }
//    public void setStopCommand(Command stopCommand) {
//        this.stopCommand = stopCommand;
//    }
//    /**
//     * 执行播放方法
//     */
//    public void play(){
//        playCommand.execute();
//    }
//    /**
//     * 执行倒带方法
//     */
//    public void rewind(){
//        rewindCommand.execute();
//    }
//    /**
//     * 执行播放方法
//     */
//    public void stop(){
//        stopCommand.execute();
//    }
	
	public void exec(){
		command.execute();
	}
}
