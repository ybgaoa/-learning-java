package com.structural.model.decorationmodel;
/*具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。*/
//具体装饰角色“鱼儿”
public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void move() {
        // 代码
		super.move();
        System.out.println("Fish Move");
    }
}
