package com.behavioral.model.commandmodel;

import com.behavioral.model.commandmodel.command.Command;
/*������(Invoker)��ɫ����������������ִ��������صķ��������ж�������*/
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
//     * ִ�в��ŷ���
//     */
//    public void play(){
//        playCommand.execute();
//    }
//    /**
//     * ִ�е�������
//     */
//    public void rewind(){
//        rewindCommand.execute();
//    }
//    /**
//     * ִ�в��ŷ���
//     */
//    public void stop(){
//        stopCommand.execute();
//    }
	
	public void exec(){
		command.execute();
	}
}
