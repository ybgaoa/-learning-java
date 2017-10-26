package com.behavioral.model.observermodel;

import com.behavioral.model.observermodel.observer.ConcreteObserver;
import com.behavioral.model.observermodel.observer.Observer;
import com.behavioral.model.observermodel.subject.ConcreteSubject;

public class Client {
	public static void main(String[] args) {
        //�����������
        ConcreteSubject subject = new ConcreteSubject();
        //�����۲��߶���
        Observer observer = new ConcreteObserver();
        //���۲��߶���Ǽǵ����������
        subject.attach(observer);
        //�ı���������״̬
        subject.change("new state");
    }
}
