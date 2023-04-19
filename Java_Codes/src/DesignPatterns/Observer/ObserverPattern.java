package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
	public void add(Observer o);

	public void notifyUpdate(String msg);
}

interface Observer {
	public void update(String msg);
}

class MessagePublisher implements Subject {

	private List<Observer> observers = new ArrayList<>();

	@Override
	public void notifyUpdate(String msg) {
		for (Observer o : observers) {
			o.update(msg);
		}
	}

	@Override
	public void add(Observer o) {
		observers.add(o);
	}
}

class SMSMessage implements Observer {
	@Override
	public void update(String msg) {
		System.out.println("SMSMessage :: " + msg);
	}
}

class MailMessage implements Observer {
	@Override
	public void update(String msg) {
		System.out.println("MailMessage :: " + msg);
	}
}

public class ObserverPattern {
	public static void main(String[] args) {
		MessagePublisher p = new MessagePublisher();
		p.add(new SMSMessage());
		p.notifyUpdate("First Message");
		p.add(new MailMessage());
		p.notifyUpdate("Second Message");
	}
}