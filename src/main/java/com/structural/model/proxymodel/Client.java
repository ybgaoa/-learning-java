package com.structural.model.proxymodel;

public class Client {
	public static void main(String[] args) {
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }
}
