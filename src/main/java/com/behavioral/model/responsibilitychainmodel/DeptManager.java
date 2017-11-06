package com.behavioral.model.responsibilitychainmodel;
/*���崦����(ConcreteHandler)��ɫ�����崦���߽ӵ�����󣬿���ѡ��������������߽����󴫸��¼ҡ�
 * ���ھ��崦���߳��ж��¼ҵ����ã���ˣ������Ҫ�����崦���߿��Է����¼ҡ�*/
public class DeptManager extends Handler {

	@Override
	public String handleFeeRequest(String user, double fee) {
		String str = "";
        //���ž����Ȩ��ֻ����1000����
        if(fee < 1000)
        {
            //Ϊ�˲��ԣ��򵥵㣬ֻͬ������������
            if("����".equals(user))
            {
                str = "�ɹ������ž���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";    
            }else
            {
                //������һ�ɲ�ͬ��
                str = "ʧ�ܣ����ž���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";
            }
        }else
        {
            //����1000���������ݸ�������ߵ��˴���
            if(getSuccessor() != null)
            {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
	}

}
