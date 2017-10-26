package com.behavioral.model.iterativesubmodel.example02;

import com.behavioral.model.iterativesubmodel.Aggregate;
import com.behavioral.model.iterativesubmodel.Iterator;
/*�ͻ���(Client)��ɫ�����жԾۼ���������Ӷ�������ã����õ����Ӷ���ĵ����ӿڣ�Ҳ�п���ͨ�������Ӳ����ۼ�Ԫ�ص����Ӻ�ɾ����*/
public class Client {
	public void operation(){
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};
        //�����ۺ϶���
        Aggregate agg = new ConcreteAggregate(objArray);
        //ѭ������ۺ϶����е�ֵ
        Iterator it = agg.createIterator();
        while(!it.isDone()){
            System.out.println(it.currentItem());
            it.next();
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.operation();
    }
}
