package com.structural.model.compositemodel;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
	/**
     * �����洢��϶����а��������������
     */
    private List<Component> childComponents = new ArrayList<Component>();

    /**
     * ��϶��������
     */
    private String name;
    /**
     * ���췽����������϶��������
     * @param name    ��϶��������
     */
    public Composite(String name){
        this.name = name;
    }
    
    /**
     * �ۼ�������������һ���ӹ�������
     * @param child �ӹ�������
     */
    public void addChild(Component child){
        childComponents.add(child);
    }
    /**
     * �ۼ���������ɾ��һ���ӹ�������
     * @param index �ӹ���������±�
     */
    public void removeChild(int index){
        childComponents.remove(index);
    }
    /**
     * �ۼ������������������ӹ�������
     */
    public List<Component> getChild(){
        return childComponents;
    }
    
    /**
     * ������������ṹ
     * @param preStr ǰ׺����Ҫ�ǰ��ղ㼶ƴ�ӿո�ʵ���������
     */
    @Override
    public void printStruct(String preStr) {
        // �Ȱ��Լ����
        System.out.println(preStr + "+" + this.name);
        //��������������������ô�������Щ���������
        if(this.childComponents != null){
            //��������ո񣬱�ʾ������������ո�
            preStr += "  ";
            //�����ǰ������Ӷ���
            for(Component c : childComponents){
                //�ݹ����ÿ���Ӷ���
                c.printStruct(preStr);
            }
        }
    }

}
