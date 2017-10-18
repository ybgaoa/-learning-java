package com.structural.model.proxymodel;
/*代理对象角色：代理对象内部含有目标对象的引用，从而可以在任何时候操作目标对象；
 * 代理对象提供一个与目标对象相同的接口，以便可以在任何时候替代目标对象。
 * 代理对象通常在客户端调用传递给目标对象之前或之后，执行某个操作，
 * 而不是单纯地将调用传递给目标对象。*/
public class ProxyObject extends AbstractObject{
	RealObject realObject = new RealObject();
	@Override
	public void operation() {
		//调用目标对象之前可以做相关操作
        System.out.println("before");        
        realObject.operation();        
        //调用目标对象之后可以做相关操作
        System.out.println("after");
	}

}
