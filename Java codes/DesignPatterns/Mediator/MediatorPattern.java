package DesignPatterns.Mediator;

import java.util.Date;

class ChatRoom {
	public static void showMessage(User user, String message) {
		System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
	}
}

class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		this.name = name;
	}

	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
}

public class MediatorPattern {
	public static void main(String[] args) {
		User robert = new User("Moore");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Moore!");
	}
}