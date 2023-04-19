package Collections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		Map<String, String> premiumPhone = new ConcurrentHashMap<String, String>();
		premiumPhone.put("Apple", "iPhone6");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung", "S6");

		Iterator<String> iterator = premiumPhone.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}
		System.out.println(premiumPhone);
	}
}
