package com.thread.sample.sample14;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
//�����ļ������࣬������һ���ļ��м������ļ����в��ҹ�ȥ24Сʱ���޸Ĺ���ָ����չ�����ļ�
public class FileSearch implements Runnable {
	//�����洢���ҵ��ļ���
	private String initPath;
	//�����洢Ҫ���ҵ��ļ�����չ��
	private String end;
	//�����洢���ҵ����ļ�������·��
	private List<String> results;
	//����һ��˽�е�Phaser���ԣ�������������ͬ�׶ε�ͬ��
	private Phaser phaser;
	
	public FileSearch(String initPath,String end,Phaser phaser){
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<>();
	}
	private void direcotryProcess(File file){
		File list[] = file.listFiles();
		if(list != null){
			for(int i=0;i<list.length;i++){
				if(list[i].isDirectory()){
					direcotryProcess(list[i]);
				}else{
					fileProcess(list[i]);
				}
			}
		}
	}
	private void fileProcess(File file){
		if(file.getName().endsWith(end)){
			results.add(file.getAbsolutePath());
		}
	}
	private void filterResults(){
		List<String> newResults = new ArrayList<>();
		long actualDate = new Date().getTime();
		for(int i=0;i<results.size();i++){
			File file = new File(results.get(i));
			long fileDate = file.lastModified();
			if(actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)){
				newResults.add(results.get(i));
			}
		}
		results = newResults;
	}
	private boolean checkResults(){
		if(results.isEmpty()){
			System.out.println(Thread.currentThread().getName()+":Phase "+ phaser.getPhase()+": 0 results");
			System.out.println(Thread.currentThread().getName()+":Phase "+ phaser.getPhase()+": end");
			//����Phaser�����arriveAndDeregister()������֪ͨPhaser����ǰ�߳��Ѿ���������׶Σ����ҽ����ٲ���������Ľ׶β���
			phaser.arriveAndDeregister();
			return false;
		}else{
			System.out.println(Thread.currentThread().getName()+":Phase "+ phaser.getPhase()+":"+results.size()+" results");
			//����Phaser�����arriveAndAwaitAdvance()��������֪ͨPhaser����ǰ�߳��Ѿ�����˵�ǰ�׶Σ���Ҫ������ֱ�������߳�Ҳ����ɵ�ǰ�׶�
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	private void showInfo(){
		for(int i=0;i<results.size();i++){
			File file = new File(results.get(i));
			System.out.println(Thread.currentThread().getName()+":"+file.getAbsolutePath());
		}
		//����Phaser�����arriveAndAwaitAdvance()��������֪ͨPhaser����ǰ�߳��Ѿ�����˵�ǰ�׶Σ���Ҫ������ֱ�������߳�Ҳ����ɵ�ǰ�׶�
		phaser.arriveAndAwaitAdvance();
	} 
	@Override
	public void run() {
		//��һ�׶Σ����ø÷���ʱ��Phaser���󽫼�һ�����Ұ�����߳���������״̬��ֱ�����������߳��������׶Ρ�
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName()+":starting...");
		File file = new File(initPath);
		if(file.isDirectory()){
			this.direcotryProcess(file);
		}
		if(!checkResults()){
			return;
		}
		filterResults();
		//checkResults()�����п�ʼ�ڶ��׶�
		if(!checkResults()){
			return;
		}
		//showInfo()�����п�ʼ�����׶�
		showInfo();
		//ͨ��������ã�������phaser���̵߳�ע�ᣬ���Ե������߳����н�����ʱ��phaser�����û�в���ͬ�����߳��ˡ�
		phaser.arriveAndDeregister();
		System.out.println(Thread.currentThread().getName()+":work completed");
	}

}
