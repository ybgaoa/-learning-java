package com.structural.model.proxymodel;
/*��������ɫ����������ڲ�����Ŀ���������ã��Ӷ��������κ�ʱ�����Ŀ�����
 * ��������ṩһ����Ŀ�������ͬ�Ľӿڣ��Ա�������κ�ʱ�����Ŀ�����
 * �������ͨ���ڿͻ��˵��ô��ݸ�Ŀ�����֮ǰ��֮��ִ��ĳ��������
 * �����ǵ����ؽ����ô��ݸ�Ŀ�����*/
public class ProxyObject extends AbstractObject{
	RealObject realObject = new RealObject();
	@Override
	public void operation() {
		//����Ŀ�����֮ǰ��������ز���
        System.out.println("before");        
        realObject.operation();        
        //����Ŀ�����֮���������ز���
        System.out.println("after");
	}

}
