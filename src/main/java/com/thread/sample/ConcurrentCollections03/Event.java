package com.thread.sample.ConcurrentCollections03;
//实现Comparable接口的compareTo()方法，比较本身对象和参数对象之间的优先级
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
	 * 如果event本身的优先级值高于作为参数的event的优先级值，结果返回-1；
	 * 如果event本身的优先级值低于作为参数的event的优先级值，结果返回1；
	 * 如果event本身的优先级值等于作为参数的event的优先级值，结果返回0；
	 * 在返回值为0的情况下，PriorityBlockingQueue类不保证元素的次序。
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
