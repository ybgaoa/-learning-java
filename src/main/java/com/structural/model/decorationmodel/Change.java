package com.structural.model.decorationmodel;
/*װ��(Decorator)��ɫ������һ������(Component)�����ʵ����������һ������󹹼��ӿ�һ�µĽӿڡ�*/
//����װ�ν�ɫ����ʮ���䡱
public class Change implements TheGreatestSage {
	private TheGreatestSage sage;
    
    public Change(TheGreatestSage sage){
        this.sage = sage;
    }
	public void move() {
		sage.move();
	}

}
