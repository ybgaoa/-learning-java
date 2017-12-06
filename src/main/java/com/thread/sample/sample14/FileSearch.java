package com.thread.sample.sample14;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
//创建文件查找类，它将在一个文件夹及其子文件夹中查找过去24小时内修改过的指定扩展名的文件
public class FileSearch implements Runnable {
	//用来存储查找的文件夹
	private String initPath;
	//用来存储要查找的文件的扩展名
	private String end;
	//用来存储查找到的文件的完整路径
	private List<String> results;
	//声明一个私有的Phaser属性，用来控制任务不同阶段的同步
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
			//调用Phaser对象的arriveAndDeregister()方法来通知Phaser对象当前线程已经结束这个阶段，并且将不再参与接下来的阶段操作
			phaser.arriveAndDeregister();
			return false;
		}else{
			System.out.println(Thread.currentThread().getName()+":Phase "+ phaser.getPhase()+":"+results.size()+" results");
			//调用Phaser对象的arriveAndAwaitAdvance()方法，来通知Phaser对象当前线程已经完成了当前阶段，需要被阻塞直到其他线程也都完成当前阶段
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	private void showInfo(){
		for(int i=0;i<results.size();i++){
			File file = new File(results.get(i));
			System.out.println(Thread.currentThread().getName()+":"+file.getAbsolutePath());
		}
		//调用Phaser对象的arriveAndAwaitAdvance()方法，来通知Phaser对象当前线程已经完成了当前阶段，需要被阻塞直到其他线程也都完成当前阶段
		phaser.arriveAndAwaitAdvance();
	} 
	@Override
	public void run() {
		//第一阶段，调用该方法时，Phaser对象将减一，并且把这个线程置于休眠状态，直到所有其他线程完成这个阶段。
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
		//checkResults()方法中开始第二阶段
		if(!checkResults()){
			return;
		}
		//showInfo()方法中开始第三阶段
		showInfo();
		//通过这个调用，撤销了phaser中线程的注册，所以当所有线程运行结束的时候，phaser对象就没有参与同步的线程了。
		phaser.arriveAndDeregister();
		System.out.println(Thread.currentThread().getName()+":work completed");
	}

}
