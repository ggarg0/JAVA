package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class HDTV1 {
	private int size;
	private String brand;

	public HDTV1(int size, String brand) {
		this.size = size;
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}

class SizeComparator implements Comparator<HDTV1> {
	@Override
	public int compare(HDTV1 tv1, HDTV1 tv2) {
		int tv1Size = tv1.getSize();
		int tv2Size = tv2.getSize();

		if (tv1Size > tv2Size) {
			return 1;
		} else if (tv1Size < tv2Size) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class ComparatorHDTV {
	public static void main(String[] args) {
		HDTV1 tv1 = new HDTV1(55, "Samsung");
		HDTV1 tv2 = new HDTV1(60, "Sony");
		HDTV1 tv3 = new HDTV1(42, "Panasonic");
		HDTV1 tv4 = new HDTV1(65, "LG");
		HDTV1 tv5 = new HDTV1(23, "Philips");
		HDTV1 tv6 = new HDTV1(45, "Intex");
		HDTV1 tv7 = new HDTV1(45, "Micromax");

		ArrayList<HDTV1> al = new ArrayList<HDTV1>();
		al.add(tv1);
		al.add(tv2);
		al.add(tv3);
		al.add(tv4);
		al.add(tv5);
		al.add(tv6);
		al.add(tv7);

		Collections.sort(al, new SizeComparator());
		System.out.println("By Id");
		System.out.println("--------------------");
		for (HDTV1 a : al) {
			System.out.println(a.getSize() + " - " +  a.getBrand());
		}

		Collections.sort(al, new Comparator<HDTV1>() {
					@Override
					public int compare(HDTV1 o1, HDTV1 o2) {
						return o1.getBrand().compareTo(o2.getBrand());
					}
		});
		System.out.println("--------------------");
		System.out.println("By Brand");
		System.out.println("--------------------");
		for (HDTV1 a : al) {
			System.out.println(a.getSize() + " - " + a.getBrand());
		}

	}
}
