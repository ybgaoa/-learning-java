package com.structural.model.decorationmodel;
/*����װ��(ConcreteDecorator)��ɫ������������������ϡ����ӵ����Ρ�*/
//����װ�ν�ɫ�������
public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void move() {
        // ����
		super.move();
        System.out.println("Fish Move");
    }
}
