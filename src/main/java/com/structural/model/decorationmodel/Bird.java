package com.structural.model.decorationmodel;
/*����װ��(ConcreteDecorator)��ɫ������������������ϡ����ӵ����Ρ�*/
//����װ�ν�ɫ�������
public class Bird extends Change {

	public Bird(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void move() {
        // ����
		super.move();
        System.out.println("Bird Move");
    }
}
