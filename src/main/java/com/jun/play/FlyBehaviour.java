package com.jun.play;

public interface FlyBehaviour extends Behaviour {

	default void behave() {
		fly();
	}
	
	public void fly();
}
