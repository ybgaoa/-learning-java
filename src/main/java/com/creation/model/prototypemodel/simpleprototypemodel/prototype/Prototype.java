package com.creation.model.prototypemodel.simpleprototypemodel.prototype;
/*����ԭ��(Prototype)��ɫ������һ�������ɫ��ͨ����һ��Java�ӿڻ�Java������ʵ�֡�
 * �˽�ɫ�������еľ���ԭ��������Ľӿڡ�*/
public interface Prototype {
	 /**
     * ��¡����ķ���
     * @return һ���������¡�����Ķ���
     */
    public Prototype clone();
}
