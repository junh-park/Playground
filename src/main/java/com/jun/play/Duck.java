package com.jun.play;

public class Duck {
	String name;
	Behaviour behaviour;
	
	
	public Duck(String name, Behaviour behaviour) {
		this.name = name;
		this.behaviour = behaviour;
	}

	public void behave() {
		behaviour.behave();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
