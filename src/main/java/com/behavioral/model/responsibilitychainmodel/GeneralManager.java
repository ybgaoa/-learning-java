package com.behavioral.model.responsibilitychainmodel;
/*���崦����(ConcreteHandler)��ɫ�����崦���߽ӵ�����󣬿���ѡ��������������߽����󴫸��¼ҡ�
 * ���ھ��崦���߳��ж��¼ҵ����ã���ˣ������Ҫ�����崦���߿��Է����¼ҡ�*/
public class GeneralManager extends Handler {

	@Override
	public String handleFeeRequest(String user, double fee) {
		String str = "";
        //�ܾ����Ȩ�޺ܴ�ֻҪ����������������Դ���
        if(fee >= 1000)
        {
            //Ϊ�˲��ԣ��򵥵㣬ֻͬ������������
            if("����".equals(user))
            {
                str = "�ɹ����ܾ���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";    
            }else
            {
                //������һ�ɲ�ͬ��
                str = "ʧ�ܣ��ܾ���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";
            }
        }else
        {
            //������к�̵Ĵ�����󣬼�������
            if(getSuccessor() != null)
            {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
	}

}
