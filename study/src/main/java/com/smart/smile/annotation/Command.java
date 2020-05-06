package com.smart.smile.annotation;

public class Command {
	private int id;

	public Command() {
		System.out.println("create command object");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object execute() {
		System.out.println("command id: " + id);
		return id;
	}
}
