package com.thread.sample.sample06;

/**
 * 使用工厂类创建线程
 * 
 * 工厂模式是面向对象编程中最常使用的模式之一。它是一个创建者模式，使用一个类为其他的一个或者多个类创建对象。当我们要为这些类创建对象时，不需再使用new构造器，而使用工厂类。
使用工厂类，可以将对象的创建集中化，这样做有以下的好处：
1、更容易修改类，或者改变创建对象的方式；
2、更容易为有限资源限制创建对象的数目。例如，我们可以限制一个类型的对象不多于n个。
3、更容易为创建的对象生成统计数据。
Java提供了ThreadFactory接口，这个接口实现了线程对象工厂。Java并发API的高级工具类也使用了线程工厂创建线程。
 * @author ybgaoa
 *
 */
public class Main {
	public static void main(String[] args) {
		//创建一个自定义的工厂类
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread t;
        System.out.println("Starting the Threads");
        //使用工厂类创建10个线程对象
        for(int i=0;i<10;i++){
        	//使用工厂类创建线程
            t = factory.newThread(task);
            t.start();
        }
        System.out.println("Factory stats:");
        System.out.println(factory.getStats());
    }
}
