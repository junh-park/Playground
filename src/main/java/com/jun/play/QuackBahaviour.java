package com.jun.play;

public interface QuackBahaviour extends Behaviour {

	@Override
	default void behave() {
		quack();
	}

	void quack();
}
