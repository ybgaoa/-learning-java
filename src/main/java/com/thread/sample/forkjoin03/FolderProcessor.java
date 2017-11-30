package com.thread.sample.forkjoin03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {
	private String path;
	private String extension;
	
	public FolderProcessor(String path,String extension){
		this.path = path;
		this.extension = extension;
	}
	@Override
	protected List<String> compute() {
		List<String> list = new ArrayList<>();
		List<FolderProcessor> tasks = new ArrayList<>();
		File file = new File(path);
		File content[] = file.listFiles();
		if(content!=null){
			for(int i=0;i<content.length;i++){
				if(content[i].isDirectory()){
					FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(),extension);
					//����fork()���������첽��ʽ��ִ��
					//fork()�������������̳߳�ʱ������̳߳����п��еĹ������̻߳��ߴ���һ���µ��̣߳�
					//��ô��ʼִ���������fork()�������������أ���ˣ���������Լ���������������
					task.fork();
					tasks.add(task);
				}else{
					if(checkFile(content[i].getName())){
						list.add(content[i].getAbsolutePath());
					}
				}
			}
			if(tasks.size()>50){
				System.out.println(file.getAbsolutePath()+":"+tasks.size()+":tasks ran");
			}
			addResultsFromTasks(list, tasks);
		}
		return list;
	}
	
	private void addResultsFromTasks(List<String> list,List<FolderProcessor> tasks){
		for(FolderProcessor item:tasks){
			//����Join()�����ȴ����͵��̳߳��е�����������ִ�����,����ȡ���
			list.addAll(item.join());
		}
	}
	
	private boolean checkFile(String name){
		return name.endsWith(extension);
	}

}
