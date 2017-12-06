package com.thread.sample.ConcurrentCollections01;

import java.util.concurrent.ConcurrentLinkedDeque;
//ʹ�÷�����ʽ�̰߳�ȫ�б�
/**
 * ��������
���ݽṹ�Ǳ���еĻ���Ԫ�أ�����ÿ������ʹ��һ�ֻ�������ݽṹ���洢�͹������ݡ�java api�ṩ�˰����ӿڡ�����㷨��java���Ͽ�ܣ���ʵ���˿����ڳ����еĴ������ݽṹ��
����Ҫ�ڲ���������ʹ�����ݼ���ʱ������Ҫ������ѡ����Ӧ��ʵ�ַ�ʽ������������಻��ֱ�����ڲ���Ӧ�ã���Ϊ����û�жԱ������ݵĲ������ʽ��п��ơ�
���һЩ������������һ���������ڲ�����������ݽṹ�������������ݲ�һ�µĴ��󣬲���Ӱ������׼ȷ���С��������ݽṹ��һ��������ArrayList�ࡣ
java�ṩ��һЩ�������ڲ��������е����ݼ��ϣ����ǲ��������κ����⡣һ����˵��java�ṩ�����������ڲ���Ӧ�õļ��ϣ�
1.����ʽ����(Blocking Collection)�����༯�ϰ�����Ӻ��Ƴ����ݵķ�������������������Ϊ��ʱ�������õ���ӻ��Ƴ������Ͳ���������ִ�У���ô��������������߳̽���������һֱ���÷������Ա��ɹ�ִ�С�
2.������ʽ����(Non-Blocking Collection)�����༯��Ҳ������Ӻ��Ƴ����ݵķ����������������������ִ�У��򷵻�null�����׳��쳣�����ǵ�������������̲߳��ᱻ������

����Ӧ���г��õ�java�����ࣺ
1.������ʽ�б��Ӧ��ʵ���ࣺConcurrentLinkedDeque��
2.����ʽ�б��Ӧ��ʵ���ࣺLinkedBlockingDeque��
3.�����������ɻ����ѵ�����ʽ�б��Ӧ��ʵ���ࣺLinkedTransferQueue��
4.�����ȼ������б�Ԫ�ص�����ʽ�б��Ӧ��ʵ���ࣺPriorityBlockingQueue��
5.�����ӳ��б�Ԫ�ص�����ʽ�б��Ӧ��ʵ���ࣺDelayQueue��
6.������ʽ�ɱ���ӳ���Ӧ��ʵ���ࣺConcurrentSkipListMap��
7.������ֶ�Ӧ��ʵ���ࣺThreadLocalRandom��
8.ԭ�ӱ�����Ӧ��ʵ���ࣺAtomicLong��AtomicIntegerArray��

һ��ConcurrentLinkedDeque���ṩ�ĳ��÷�����
1.getFirst()��getLast()���ֱ𷵻��б��еĵ�һ�������һ��Ԫ�أ����ص�Ԫ�ز�����б����Ƴ�������б�Ϊ�գ������������׳�NoSuchElementExcpetion�쳣��
2.peek()��peekFirst()��peekLast()���ֱ𷵻��б��е�һ�������һ��Ԫ�أ����ص�Ԫ�ز�����б����Ƴ�������б�Ϊ�գ���Щ��������null��
3.remove(), removeFirst(), removeLast()����Щ���������б�ĵ�һ�������һ��Ԫ�ء����Ǵ��б����Ƴ����ص�Ԫ�ء�����б��ǿյ�,��Щ�����׳�һ�� NoSuchElementException���⡣
4.pollFirst()��pollLast()��pollFirst()�������غ�ɾ���б�ĵ�һ��Ԫ�غ�pollLast()�������غ�ɾ�����һ��Ԫ�ص��б�����б�Ϊ��,��Щ��������һ��nullֵ��
5.size()���÷������ص�ֵ���ܲ�����ʵ��,���䵱���߳��������ݻ����Ƴ�����ʱ�����������Ҫ���������б�������Ԫ���������������������ݿ����Ѿ��ı䡣����û���κ��߳��޸��б�ʱ�����ܱ�֤���صĽ����׼ȷ�ġ�
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		//����ConcurrentLinkedDeque����
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		//�����߳�����
		Thread threads[] = new Thread[100];
		//����AddTask�����Լ����Ӧ�������̣߳�Ȼ�������߳�
		for(int i=0;i<threads.length;i++){
			AddTask task = new AddTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		System.out.println("main:"+threads.length+" AddTask threads have been launched");
		//ʹ��join()�����ȴ��߳����
		for(int i=0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:size of the list:"+list.size());
		//����PollTask�����Լ����Ӧ�������̣߳�Ȼ�������߳�
		for(int i=0;i<threads.length;i++){
			PollTask task = new PollTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.println("main:"+threads.length+" polltask threads have been  launched");
		//ʹ��join()�����ȴ��߳����
		for(int i=0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main:size of the list:"+list.size());
	}
}
