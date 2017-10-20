package com.structural.model.facademodel;
/*子系统(SubSystem)角色 ：可以同时有一个或者多个子系统。
每个子系统都不是一个单独的类，而是一个类的集合（如上面的子系统就是由ModuleA、ModuleB、ModuleC三个类组合而成）。每个子系统都可以被客户端直接调用，或者被门面角色调用。
子系统并不知道门面的存在，对于子系统而言，门面仅仅是另外一个客户端而已。*/
public class ModuleA {
	//示意方法
    public void testA(){
        System.out.println("调用ModuleA中的testA方法");
    }
}
