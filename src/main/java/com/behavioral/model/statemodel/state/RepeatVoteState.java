package com.behavioral.model.statemodel.state;

import com.behavioral.model.statemodel.VoteManager;
/*����״̬(ConcreteState)��ɫ��ÿһ������״̬�඼ʵ���˻�����Context����һ��״̬����Ӧ����Ϊ��*/
public class RepeatVoteState implements VoteState {
	@Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //�ظ�ͶƱ����ʱ��������
        System.out.println("�벻Ҫ�ظ�ͶƱ");
    }
}
