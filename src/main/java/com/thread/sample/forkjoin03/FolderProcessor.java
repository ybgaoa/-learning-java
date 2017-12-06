package com.thread.sample.forkjoin03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
//创建名为FolderProcessor的类，并继承RecursiveTask类
public class FolderProcessor extends RecursiveTask<List<String>> {
	private String path;
	private String extension;
	
	public FolderProcessor(String path,String extension){
		this.path = path;
		this.extension = extension;
	}
	//实现compute()方法，并返回List<String>类型的对象
	@Override
	protected List<String> compute() {
		//声明一个名为list的String对象列表，用来存储文件夹中文件的名称
		List<String> list = new ArrayList<>();
		//声明一个名为tasks的FolderProcessor对象列表，用来存储子任务，这些子任务将处理文件夹中的子文件夹
		List<FolderProcessor> tasks = new ArrayList<>();
		//获取文件夹的内容
		File file = new File(path);
		File content[] = file.listFiles();
		if(content!=null){
			for(int i=0;i<content.length;i++){
				//对于文件夹中的每一个元素，如果它是子文件夹，就创建一个新的FolderProcessor对象，然后调用fork()方法采用异步方式来执行
				if(content[i].isDirectory()){
					FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(),extension);
					//调用fork()方法采用异步方式来执行
					//fork()方法发送任务到线程池时，如果线程池中有空闲的工作者线程或者创建一个新的线程，
					//那么开始执行这个任务，fork()方法会立即返回，因此，主任务可以继续处理其他任务。
					task.fork();
					tasks.add(task);
				}else{
					//否则调用checkFile()方法来比较文件的扩展名。如果文件的扩展名与将要搜索的扩展名相同，就将文件的完整路径存储到list对象列表中
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
