package com.behavioral.model.observermodel.subject;
/*��������(ConcreteSubject)��ɫ�����й�״̬�������۲��߶���
�ھ���������ڲ�״̬�ı�ʱ�������еǼǹ��Ĺ۲��߷���֪ͨ��
���������ɫ�ֽ������屻�۲���(Concrete Observable)��ɫ��*/
public class ConcreteSubject extends Subject {
	private String state;
    
    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("����״̬Ϊ��" + state);
        //״̬�����ı䣬֪ͨ�����۲���
        this.nodifyObservers(state);
    }
}
