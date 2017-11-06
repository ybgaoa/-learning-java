package com.behavioral.model.statemodel.state;

import com.behavioral.model.statemodel.VoteManager;
/*����״̬(ConcreteState)��ɫ��ÿһ������״̬�඼ʵ���˻�����Context����һ��״̬����Ӧ����Ϊ��*/
public class SpiteVoteState implements VoteState {
	@Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // ����ͶƱ��ȡ���û���ͶƱ�ʸ񣬲�ȡ��ͶƱ��¼
        String str = voteManager.getMapVote().get(user);
        if(str != null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("���ж���ˢ����Ϊ��ȡ��ͶƱ�ʸ�");
    }
}
