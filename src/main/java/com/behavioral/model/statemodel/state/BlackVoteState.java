package com.behavioral.model.statemodel.state;

import com.behavioral.model.statemodel.VoteManager;
/*����״̬(ConcreteState)��ɫ��ÿһ������״̬�඼ʵ���˻�����Context����һ��״̬����Ӧ����Ϊ��*/
public class BlackVoteState implements VoteState {
	@Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //��¼�������У���ֹ��¼ϵͳ
        System.out.println("���������������ֹ��¼��ʹ�ñ�ϵͳ");
    }
}
