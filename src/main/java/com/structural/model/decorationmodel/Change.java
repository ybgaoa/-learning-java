package com.structural.model.decorationmodel;
/*装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。*/
//抽象装饰角色“七十二变”
public class Change implements TheGreatestSage {
	private TheGreatestSage sage;
    
    public Change(TheGreatestSage sage){
        this.sage = sage;
    }
	public void move() {
		sage.move();
	}

}
