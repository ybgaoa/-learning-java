package com.behavioral.model.statemodel.state;

import com.behavioral.model.statemodel.VoteManager;
/*具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。*/
public class RepeatVoteState implements VoteState {
	@Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //重复投票，暂时不做处理
        System.out.println("请不要重复投票");
    }
}
