package com.thread.sample.ConcurrentCollections03;
//ʵ��Comparable�ӿڵ�compareTo()�������Ƚϱ������Ͳ�������֮������ȼ�
public class Event implements Comparable<Event> {
	public int getThread() {
		return thread;
	}

	public int getPriorty() {
		return priorty;
	}

	private int thread;
	private int priorty;
	public Event(int thread,int priorty){
		this.thread = thread;
		this.priorty = priorty;
	}
	/**
	 * ���event��������ȼ�ֵ������Ϊ������event�����ȼ�ֵ���������-1��
	 * ���event��������ȼ�ֵ������Ϊ������event�����ȼ�ֵ���������1��
	 * ���event��������ȼ�ֵ������Ϊ������event�����ȼ�ֵ���������0��
	 * �ڷ���ֵΪ0������£�PriorityBlockingQueue�಻��֤Ԫ�صĴ���
	 */
	@Override
	public int compareTo(Event o) {
		if(this.priorty>o.getPriorty()){
			return -1;
		}else if(this.priorty<o.getPriorty()){
			return 1;
		}else{
			return 0;
		}
	}

}
