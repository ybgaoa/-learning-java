package com.creation.model.prototypemodel.registrationprototypemodel;

import java.util.HashMap;
import java.util.Map;

import com.creation.model.prototypemodel.registrationprototypemodel.prototype.Prototype;

/*ԭ�͹�������ɫ����һ���ۼ�����Ϊ������ԭ�Ͷ���ĵǼǣ������ɫ�ṩ��Ҫ�ķ���������������µ�ԭ�Ͷ����ȡ���Ѿ��Ǽǹ���ԭ�Ͷ���*/
public class PrototypeManager {
	/**
     * ������¼ԭ�͵ı�ź�ԭ��ʵ���Ķ�Ӧ��ϵ
     */
    private static Map<String,Prototype> map = new HashMap<String,Prototype>();
    /**
     * ˽�л����췽���������ⲿ����ʵ��
     */
    private PrototypeManager(){}
    /**
     * ��ԭ�͹�����������ӻ����޸�ĳ��ԭ��ע��
     * @param prototypeId ԭ�ͱ��
     * @param prototype    ԭ��ʵ��
     */
    public synchronized static void setPrototype(String prototypeId , Prototype prototype){
        map.put(prototypeId, prototype);
    }
    /**
     * ��ԭ�͹���������ɾ��ĳ��ԭ��ע��
     * @param prototypeId ԭ�ͱ��
     */
    public synchronized static void removePrototype(String prototypeId){
        map.remove(prototypeId);
    }
    /**
     * ��ȡĳ��ԭ�ͱ�Ŷ�Ӧ��ԭ��ʵ��
     * @param prototypeId    ԭ�ͱ��
     * @return    ԭ�ͱ�Ŷ�Ӧ��ԭ��ʵ��
     * @throws Exception    ���ԭ�ͱ�Ŷ�Ӧ��ʵ�������ڣ����׳��쳣
     */
    public synchronized static Prototype getPrototype(String prototypeId) throws Exception{
        Prototype prototype = map.get(prototypeId);
        if(prototype == null){
            throw new Exception("��ϣ����ȡ��ԭ�ͻ�û��ע����ѱ�����");
        }
        return prototype;
    }
}
