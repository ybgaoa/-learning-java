package com.behavioral.model.statemodel.state;

import com.behavioral.model.statemodel.VoteManager;
/*����״̬(ConcreteState)��ɫ��ÿһ������״̬�඼ʵ���˻�����Context����һ��״̬����Ӧ����Ϊ��*/
public class NormalVoteState implements VoteState {
	@Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //����ͶƱ����¼��ͶƱ��¼��
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("��ϲͶƱ�ɹ�");
    }
}
