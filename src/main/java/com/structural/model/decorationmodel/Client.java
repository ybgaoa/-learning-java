package com.structural.model.decorationmodel;

public class Client {
	public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(bird);
        fish.move(); 
    }
}
