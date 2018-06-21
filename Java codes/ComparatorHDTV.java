import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class HDTV {
	private int size;
	private String brand;

	public HDTV(int size, String brand) {
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

class SizeComparator implements Comparator<HDTV> {
	@Override
	public int compare(HDTV tv1, HDTV tv2) {
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
		HDTV tv1 = new HDTV(55, "Samsung");
		HDTV tv2 = new HDTV(60, "Sony");
		HDTV tv3 = new HDTV(42, "Panasonic");
		HDTV tv4 = new HDTV(65, "LG");
		HDTV tv5 = new HDTV(23, "Philips");
		HDTV tv6 = new HDTV(45, "Intex");
		HDTV tv7 = new HDTV(45, "Micromax");

		ArrayList<HDTV> al = new ArrayList<HDTV>();
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
		for (HDTV a : al) {
			System.out.println(a.getSize() + " - " +  a.getBrand());
		}

		Collections.sort(al, new Comparator<HDTV>() {
					@Override
					public int compare(HDTV o1, HDTV o2) {
						return o1.getBrand().compareTo(o2.getBrand());
					}
		});
		System.out.println("--------------------");
		System.out.println("By Brand");
		System.out.println("--------------------");
		for (HDTV a : al) {
			System.out.println(a.getSize() + " - " + a.getBrand());
		}

	}
}
