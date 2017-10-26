package com.behavioral.model.observermodel.subject;

import java.util.ArrayList;
import java.util.List;

import com.behavioral.model.observermodel.observer.Observer;

public abstract class Subject {
	/**
     * ��������ע��Ĺ۲��߶���
     */
    private    List<Observer> list = new ArrayList<Observer>();
    /**
     * ע��۲��߶���
     * @param observer    �۲��߶���
     */
    public void attach(Observer observer){
        
        list.add(observer);
        System.out.println("Attached an observer");
    }
    /**
     * ɾ���۲��߶���
     * @param observer    �۲��߶���
     */
    public void detach(Observer observer){
        
        list.remove(observer);
    }
    /**
     * ֪ͨ����ע��Ĺ۲��߶���
     */
    public void nodifyObservers(String newState){
        
        for(Observer observer : list){
            observer.update(newState);
        }
    }
}
