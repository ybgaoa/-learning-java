package com.creation.model.singletonmodel.enumsingleton;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySingleton my = EnumSingleton.INSTANCE.getInstance();
		my.say("my");
		MySingleton my01 = EnumSingleton.INSTANCE.getInstance();
		my01.say("my01");
		MySingleton my02 = EnumSingleton.INSTANCE.getInstance();
		my02.say("my02");
	}

}
