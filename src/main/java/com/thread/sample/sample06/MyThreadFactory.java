package com.thread.sample.sample06;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	private int counter; //�洢�̶߳��������
    private String name; //��Ź���������
    private List<String> stats; //����̶߳����ͳ������
    public MyThreadFactory(String name){
        counter = 0;
        this.name = name;
        stats = new ArrayList<String>();
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread  t = new Thread(r, name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStats(){
        StringBuilder sb = new StringBuilder();
        Iterator<String> iter = stats.iterator();
        while(iter.hasNext()){
            sb.append(iter.next());
            sb.append("\n");
        }
        return sb.toString();
    }

}
