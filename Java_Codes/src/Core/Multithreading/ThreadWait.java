package Core.Multithreading;

import java.util.*;

public class ThreadWait {
	public static void main(String[] a) {
		ThreadG b = new ThreadG();
		for (int i = 0; i < 10; i++) {
			b.display();
		}
	}
}

class ThreadG {
	static int total;

	public void display() {
		try {
			total = total + 10;
			Thread.sleep(2000);
			System.out.println("B complete call from display method -> Total : " + total + new Date());
		} catch (Exception e) {
			System.out.println("InterruptedException" + e);
		}
	}
}