package com.structural.model.facademodel;
/*����(Facade)��ɫ ���ͻ��˿��Ե��������ɫ�ķ������˽�ɫ֪����صģ�һ�����߶������ϵͳ�Ĺ��ܺ����Ρ�
����������£�����ɫ�Ὣ���дӿͻ��˷���������ί�ɵ���Ӧ����ϵͳȥ��*/
public class Facade {
	//ʾ�ⷽ��������ͻ�����Ҫ�Ĺ���
    public void test(){
        ModuleA a = new ModuleA();
        a.testA();
        ModuleB b = new ModuleB();
        b.testB();
        ModuleC c = new ModuleC();
        c.testC();
    }
}
