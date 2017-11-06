package com.behavioral.model.statemodel.state;

import com.behavioral.model.statemodel.VoteManager;
/*����״̬(State)��ɫ������һ���ӿڣ����Է�װ������Context�������һ���ض���״̬����Ӧ����Ϊ��*/
public interface VoteState {
	/**
     * ����״̬��Ӧ����Ϊ
     * @param user    ͶƱ��
     * @param voteItem    ͶƱ��
     * @param voteManager    ͶƱ�����ģ�������ʵ��״̬��Ӧ�Ĺ��ܴ����ʱ��
     *                         ���Իص������ĵ�����
     */
    public void vote(String user,String voteItem,VoteManager voteManager);
}
