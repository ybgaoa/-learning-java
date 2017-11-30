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
					//调用fork()方法采用异步方式来执行
					//fork()方法发送任务到线程池时，如果线程池中有空闲的工作者线程或者创建一个新的线程，
					//那么开始执行这个任务，fork()方法会立即返回，因此，主任务可以继续处理其他任务。
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
			//调用Join()方法等待发送到线程池中的所有子任务执行完成,并获取结果
			list.addAll(item.join());
		}
	}
	
	private boolean checkFile(String name){
		return name.endsWith(extension);
	}

}
