package DesignPatterns.Singleton;

class Singleton implements Cloneable {
	private Singleton() {
	}

	private volatile static Singleton _instance;

	public static Singleton getInstance() {
		if (_instance == null) {
			synchronized (Singleton.class) {
				if (_instance == null) {
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}

	public Singleton clone() throws CloneNotSupportedException {
		//return super.clone();
		throw new CloneNotSupportedException();
	}
}

public class SingletonWithCloning {
	public static void main(String[] args) throws Exception {
		try {
			Singleton obj = Singleton.getInstance();
			System.out.println("Singleton Instance : " + obj);

			Singleton obj1 = (Singleton) obj.clone();
			System.out.println("Singleton clone : " + obj1);
		} catch (Exception e) {
			System.out.println("Exception clone : " + e.toString());
		}

	}
}