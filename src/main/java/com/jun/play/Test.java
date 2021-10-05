package com.jun.play;

public class Test {
	public static void main(String[] args) {
		Duck redDuck = new RedDuck("RedDuck", new FlyWithWings());
		redDuck.behave();
	}
}
