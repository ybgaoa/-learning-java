package com.behavioral.model.mementomodel;
/*管理者对象:负责备忘录权限管理，不能对备忘录对象的内容进行访问或者操作。 */
public class MemoManager {
	MemoBean memento;

    public MemoBean getMemento() {
        return memento;
    }

    public void setMemento(MemoBean memento) {
        this.memento = memento;
    }
}
