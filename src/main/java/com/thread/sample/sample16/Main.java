package com.thread.sample.sample16;
//����ִ�����߳�
/**
 * �߳�ִ����
�Դ�java 5��ʼ��java����API�ṩ��һ�׻��ƣ����׻��Ƴ�֮Ϊִ�������(Executor Framework)��Χ����Executor�ӿں������ӽӿ�ExecutorService���Լ�ʵ���������ӿ�ThreadPoolExecutor��չ����
���׻��Ʒ���������Ĵ�����ִ�С�ͨ��ʹ��ִ����������Ҫʵ��Runnable�ӿڵĶ���Ȼ����Щ�����͸�ִ�������ɡ�
ִ����ͨ������������̣߳���������ЩRunnable����Ĵ�����ʵ�����Լ����С�
����ִ�������ܲ����ڴˣ���ʹ�����̳߳������Ӧ�ó�������ܡ�������һ�������ִ����ʱ��ִ�����᳢��ʹ���̳߳��е��߳���ִ��������񣬱����˲��ϵش����������̶߳�����ϵͳ�����½���
ִ�����������һ����Ҫ��������Callable�ӿڡ���������Runnable�ӿڣ�����ȴ�ṩ�����������ǿ��
1).����ӿڵ�����������Ϊcall()�����Է��ؽ����
2).������һ��Callable�����ִ����ʱ�������һ��ʵ��Future�ӿڵĶ��󣬿���ʹ���������������Callable�����״̬�ͽ����

�����߳�ִ�����Ļ������裺
1).ͨ��Executors���������߳�ִ�������̳߳أ����磻
ThreadPoolExecutor executor = Executors.newCachedThreadPool();
ע��Executors����Դ����������͵��̳߳أ��磺
Executors.newCachedThreadPool()����һ���������Ҫ�������̵߳��̳߳ء�
Executors.newSingleThreadExecutor()����ʹ�õ���worker�̵߳�Executor��
Executors.newFixedThreadPool()������Ϊ�����ù̶��߳������̳߳�
2).ͨ���̳߳ض���ִ������
executor.execute(task);//�÷���ִ�к�û�з���ֵ
����
executor.submit(task);//�÷���ִ�к󷵻�Future�ӿڶ��󣬸ýӿ���������һЩ��������ȡ�����������Ľ�������������ǵ�״̬
ע��һ��������ִ�������Ϳ���ʹ��ִ������execute()��������submit()����������Runnable����Callable���͵�����
3).�ر��߳�ִ����
executor.shutdown();
ע��ִ�����Լ�ThreadPoolExecutor��һ����Ҫ�������ǣ�ͨ����Ҫ��ʾ��ȥ��������
���������������ôִ����������ִ�У�����Ҳ������������ִ����û�������ִ���ˣ����������ȴ�������ĵ��������������ִ�С�
javaӦ�ó��򲻻����ֱ�����з��ػ��߳̽������ǵ����У���ˣ����û����ִֹ������Ӧ�ó�����Զ���������

ThreadPoolExecutor�ࣺ��Ϊjava.util.concurrent�������ṩ����ʵ�֣����ڲ��̳߳ص���ʽ�����ṩ��������ִ�У��̵߳��ȣ��̳߳ع���ȵȷ���
ScheduledThreadPoolExecutor�ࣺ���̳߳�ִ������һ�֣��̳�ThreadPoolExecutor����ThreadPoolExecutor�Ļ���������˰��ƻ�ִ���̵߳Ĺ��ܣ����ӳ�ִ�С���ʱִ�С�������ִ�С�
 * @author ybgaoa
 *
 */
public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		for(int i=0;i<10;i++){
			Task task = new Task("task-"+i);
			server.executeTask(task);
		}
		server.endServer();

	}

}
